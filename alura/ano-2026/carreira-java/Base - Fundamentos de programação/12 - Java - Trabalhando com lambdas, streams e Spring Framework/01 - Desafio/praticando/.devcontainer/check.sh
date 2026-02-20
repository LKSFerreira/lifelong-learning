#!/usr/bin/env bash
set -euo pipefail

fail() { echo "❌ $*" >&2; exit 1; }
ok()   { echo "✅ $*"; }

echo "== Verificando ambiente =="

# --- Java 21 ---
command -v java >/dev/null 2>&1 || fail "java não encontrado"

# Captura a versão ignorando a linha 'Picked up JAVA_TOOL_OPTIONS', quando existir
JAVA_MAJOR="$(
  java -version 2>&1 | awk '
    /^Picked up JAVA_TOOL_OPTIONS:/ { next }

    # Formato comum: openjdk version "21.0.10" ...
    /version/ {
      # geralmente o token 3 é a string entre aspas
      v=$3
      gsub(/"/, "", v)
      split(v, a, ".")
      print a[1]
      exit
    }

    # Formato alternativo (java --version em algumas builds): openjdk 21.0.10 2026-01-20
    /^openjdk[[:space:]]+/ {
      v=$2
      split(v, a, ".")
      print a[1]
      exit
    }
  '
)"

[ "${JAVA_MAJOR:-}" = "21" ] || fail "Java esperado 21, veio: ${JAVA_MAJOR:-desconhecido}"
ok "Java 21 OK ($(java -version 2>&1 | awk 'NR==1{print; exit}'))"

# --- Node 24 ---
command -v node >/dev/null 2>&1 || fail "node não encontrado"
NODE_MAJOR="$(node -v | sed 's/^v//' | cut -d. -f1)"
[ "$NODE_MAJOR" = "24" ] || fail "Node esperado 24.x, veio: $(node -v)"
ok "Node 24 OK ($(node -v))"

# --- Python 3.13 ---
command -v python3.13 >/dev/null 2>&1 || fail "python3.13 não encontrado"
PY313="$(python3.13 -c 'import sys; print(f"{sys.version_info.major}.{sys.version_info.minor}.{sys.version_info.micro}")')"
echo "$PY313" | grep -q '^3\.13\.' || fail "Python esperado 3.13.x, veio: $PY313"
ok "Python 3.13 OK ($PY313)"

# Opcional: garantir que "python" aponta pra 3.13
if command -v python >/dev/null 2>&1; then
  PYP="$(python -c 'import sys; print(f"{sys.version_info.major}.{sys.version_info.minor}")')"
  [ "$PYP" = "3.13" ] || fail "'python' não está em 3.13 (está em $PYP). Se quiser, ajusto no Dockerfile com update-alternatives."
  ok "python -> 3.13 OK"
else
  fail "comando 'python' não encontrado (instale python-is-python3 ou configure alternatives)"
fi

# --- socat ---
command -v socat >/dev/null 2>&1 || fail "socat não encontrado"
SOCAT_VER="$(socat -V 2>/dev/null | head -n 1 || true)"
[ -n "$SOCAT_VER" ] || fail "não consegui ler versão do socat"
ok "socat OK ($SOCAT_VER)"

# --- Antigravity symlink check (melhora estabilidade do forwardPort) ---
BASE="${HOME}/.antigravity-server/bin"
if [ -d "$BASE" ]; then
  found=0
  for dir in "$BASE"/1.*-*; do
    [ -d "$dir" ] || continue
    found=1
    name="$(basename "$dir")"
    hash="${name#*-}"
    [ -L "$BASE/$hash" ] || fail "Antigravity: faltando symlink $BASE/$hash -> $name"
  done

  [ "$found" = "1" ] && ok "Antigravity symlinks OK" || ok "Antigravity: nenhuma pasta 1.*-* encontrada ainda (ok se ainda não instalou o server)"
else
  ok "Antigravity: pasta ~/.antigravity-server ainda não existe (ok antes do primeiro attach)"
fi

echo "== Tudo certo ✅ =="
