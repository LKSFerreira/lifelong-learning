CID="$(docker ps -aq --filter label=com.docker.compose.service=app | head -n 1)"
docker exec -u vscode -it "$CID" bash




ls -la /home/vscode/.antigravity-server/bin
cd /home/vscode/.antigravity-server/bin

# este hash vem do seu log (commit 1504c8cc...) e a pasta 1.16.5-1504c8cc... aparece no log também
ln -sfn "1.16.5-1504c8cc4b34dbfbb4a97ebe954b3da2b5634516" "1504c8cc4b34dbfbb4a97ebe954b3da2b5634516"

ls -la | grep 1504c8cc
