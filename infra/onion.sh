# 디렉토리 경로 설정
KUBE_DIR=../../infra
VUE_DIR=../frontend/OnionHotSayYo_frontend          # frontend 디렉토리 경로
PASSWORD='0000'                                                         # sudo password

# vue project build
cd $VUE_DIR
echo $PASSWORD | sudo -S docker build -t orlzll/onion-front2 .
echo $PASSWORD | sudo -S docker push orlzll/onion-front2

# manifest
cd $KUBE_DIR
kubectl apply -f vue001dep.yml && kubectl apply -f vue001ser.yml
kubectl apply -f boot001dep.yml && kubectl apply -f boot001ser.yml