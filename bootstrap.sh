#!/bin/bash
echo "creating volume"
kubectl apply -f .\\k8s\\pv-volume.yaml
echo "creating claim"
kubectl apply -f .\\k8s\\pv-claim.yaml
echo "creating pod"
kubectl apply -f .\\k8s\\pv-pod.yaml
kubectl port-forward demo-k8s-pod 8081:8081

#Tom Daniels
