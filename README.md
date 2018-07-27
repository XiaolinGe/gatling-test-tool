# 应用

### Restart Docker

### kill the exit container 
```aidl

docker ps -l

docker kill fd3c0c622af6

docker rm fd3c0c622af6

```

### 启动数据库

```aidl
  docker run -d \
  --name postgres \
  -e POSTGRES_DB=gatling \
  -e POSTGRES_USER=gatling \
  -e POSTGRES_PASSWORD=gatling123 \
  -p 5432:5432 \
  postgres
  
```

### 相关资料

- [性能测试之 Gatling](https://www.jianshu.com/p/cdd9d29256c0)


- [Gatling官网](https://gatling.io/)