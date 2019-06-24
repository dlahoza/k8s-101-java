# Kubernetes 101 for Java Developers

### Docker build and push
```bash
docker build -t github.com/dlag/todo-manager:v1.0.0 .
docker push github.com/dlag/todo-manager:v1.0.0
```

### Docker Compose
```bash
docker-compose up
```

### Kubernetes
```bash
kubectl apply -f todo-multiple-deployments.yaml
kubectl get deploy -w
```
