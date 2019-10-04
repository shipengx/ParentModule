#!/bin/bash
#
#

eval $(minikube docker-env)
docker build -t myspringbootapp .

kubectl create -f backend-deployment.yaml
kubectl create -f backend-service.yaml




