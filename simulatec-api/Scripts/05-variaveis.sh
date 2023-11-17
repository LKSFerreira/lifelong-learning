#!/bin/bash
#Script para gerar o arquivo .env caso não exista ou caso não tenha as variáveis de ambiente necessárias

if [ ! -f .env ] || ! grep -q 'DB_HOST=' .env; then
    cat > .env <<EOL
DB_HOST=
DB_PORT=
DB_DATABASE=
DB_USERNAME=
DB_PASSWORD=
EOL
fi