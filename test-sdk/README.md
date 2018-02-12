# SpringBoot微服务--SDK
创建自己的SDK，提供微服务的同时，需要提供公共服务的SKD jar包。公司内部，团队之间的后端交互使用RPC接口，性能更高，代码更加简洁。前后端之间、公司外部的交互，统一使用Restful接口，通用性强，不暴露模型定义方式。

**知识点**</br>
	
	1.创建pom包，而不是普通的jar/war包
	2.使用<modules>标签，添加子功能模块。
	3.对外提供的接口，使用jar包。发布sdk使用标签<distributionManagement>
	4.微服务部署，使用war包


	
	