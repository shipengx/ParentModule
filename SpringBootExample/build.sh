#!/usr/bin/env bash
#
#


docker build -t myspringbootapp .
docker run -p 8080:8080 myspringbootapp



# Start minikube
minikube start

# Set docker env
eval $(minikube docker-env)

# Build image
docker build -t myspringbootapp .

# Run in minikube
kubectl run myspringbootapp --image=myspringbootapp:latest --image-pull-policy=Never --port=8080

# Check that it's running
kubectl get pods


kubectl expose deployment myspringbootapp --type=NodePort

curl -X GET http://$(minikube ip):30486/

# display log messages from a pod by pod name
kubectl logs  demo-backend-7d4b47dbcb-7lvxd


# Create the configmap
kubectl create configmap game-config --from-file=configure-pod-container/configmap/



kubectl delete service demo-backend;
kubectl delete deployment demo-backend;

mvn clean package;
docker build -t myspringbootapp .;
kubectl create -f backend-deployment.yaml;
kubectl create -f backend-service.yaml;



