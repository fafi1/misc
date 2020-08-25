#!/bin/bash

export KUBECONFIG=$1.conf
kubectl config --kubeconfig=$1.conf use-context $1

