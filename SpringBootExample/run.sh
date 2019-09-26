#!/bin/bash
#
#


# Set docker env
eval $(minikube docker-env)

kubectl delete service demo-backend;
kubectl delete deployment demo-backend;

mvn clean package;
docker build -t myspringbootapp .;
kubectl create -f backend-deployment.yaml;
kubectl create -f backend-service.yaml;

# wait for 5 seconds
sleep 5

curl -X GET http://$(minikube ip):31001/

