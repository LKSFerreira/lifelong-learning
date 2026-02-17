#!/usr/bin/env bash
set -euo pipefail

# Corrigir permissões do volume Maven (necessário no Windows)
if [ -d "${HOME}/.m2" ]; then
    echo "[fix] adjusting permissions for ${HOME}/.m2" | tee -a "$LOG"
    sudo chown -R vscode:vscode "${HOME}/.m2"
fi

# BASE="${HOME}/.antigravity-server/bin"
# LOG="/tmp/fix-devcontainer.log"

# echo "[watch] start $(date -Is) user=$(id -u -n) home=$HOME base=$BASE" | tee -a "$LOG"

# # espera até existir pelo menos um diretório no formato 1.*-* (ex: 1.16.5-<hash>)
# deadline=$((SECONDS + 180))
# while [ $SECONDS -lt $deadline ]; do
#   if [ -d "$BASE" ]; then
#     shopt -s nullglob
#     dirs=("$BASE"/1.*-*)
#     if [ ${#dirs[@]} -gt 0 ]; then
#       cd "$BASE"
#       changed=0
#       for d in 1.*-*; do
#         [ -d "$d" ] || continue
#         h="${d#*-}"
#         ln -sfn "$d" "$h"
#         changed=1
#       done
#       echo "[watch] done changed=$changed at $(date -Is)" | tee -a "$LOG"
#       exit 0
#     fi
#   fi
#   sleep 0.25
# done

# echo "[watch] timeout, nothing to do" | tee -a "$LOG"
exit 0
