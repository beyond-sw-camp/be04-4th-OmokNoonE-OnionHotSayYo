VUE_DIR=../frontend/OnionHotSayYo_frontend      # frontend 디렉토리 경로
PASSWORD='0000'                                                         # sudo password

# vue project build
cd $VUE_DIR
echo $PASSWORD | sudo -S docker build -t orlzll/onion-front2 .
echo $PASSWORD | sudo -S docker push orlzll/onion-front2

# deployment restart
kubectl rollout restart deployments vue001dep