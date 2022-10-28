#!/bin/bash
echo "Removing kubernetes testing deployment"

echo "Removing pod"
kubectl delete pod demo-k8s-pod
echo "Removing volume claim"
kubectl delete pvc demo-pv-claim
echo "Removing persistent volume"
kubectl delete pv demo-pv-volume
