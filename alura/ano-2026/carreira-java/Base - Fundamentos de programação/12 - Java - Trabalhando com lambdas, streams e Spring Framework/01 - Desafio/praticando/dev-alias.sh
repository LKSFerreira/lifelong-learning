# dev-alias.sh
# Use: . dev-alias.sh

# Roda o java dentro do container
alias java='docker compose -f .devcontainer/compose.yaml exec -T app java'

# Roda o Maven dentro do container (Recomendado para Spring Boot)
alias mvn='docker compose -f .devcontainer/compose.yaml exec -T app sh ./mvnw'

# Roda o Spring Boot dentro do container
alias run='mvn spring-boot:run'