## Docker命令操作 

   1 docker search mysql   从docker.hub找mysql的镜像<br>
   2 docker pull 镜像名:tar(版本) 拉取镜像<br>
   3 docker images 查看你有多少镜像<br>
   4 docker rmi ID 删除镜像<br>  rm删除开启的容器的
   5 docker run (--name 自己起名字 )(可以不写) -d  -p (将主机端口号映射到容器端口号用冒好隔开) (后台运行的)你拉取的镜像的名字有时要加版本号  运行一个镜像容器<br>
  eg: docker run -d -p 8888:8080 tomcat(后台的名字访问多个tomcat该端口号就行) </br>
   7 docker ps -a(查看所有的,包括运行中的和已退出的) 查看当前运行的容器<br>
   8 docker stop 停止容器<br>
   9 docker logs 容器名字/容器ID 查看容器日志<br>
  
查看docker命令的地址
https://docs.docker.com/engine/reference/commandline/docker/