**springcloud实战总章**

 前言：
	该主题springcloud实战总章是基于springcloud Finchley.SR4 版本的，因为springcloud版本更新较快，因为在阅读该专题时候注意查看自己的版本和博主的版本是否一致。
	本专题将按照搭建的过程从零到一的讲述搭建的时候的一些细节和过程中踩过的坑点，在阅读之前最好能拥有一些springboot的使用基础，可以查看博主有的springboot对基本的使用有一个认识。
    本专题将按照：
    	1.服务的注册和发现中心(micro-service-register)
    	2.搭建高可用的服务注册和发现中心(register-eureka)
    	3.服务的注册(micro-service-server)
    	4.服务的网关(microservice-zuul)
    	5.服务之间的调用Feign方式(microservice-provide、microservice-consumer、microservice-business)
    	6.服务之间的调用Ribbon+rest方式(microservice-provide、microservice-consumer、microservice-business)
    	7.服务的保护装断容器Hystrix(microservice-provide、microservice-consumer、microservice-business)
    	8.服务断路的监控台Hystrix Databorad(microservice-hystrix-databoard)
    	9.服务断路聚合监控台(microservice-hystrix-turbine)
    	10.服务的全局配置中心(microservice-cloud-config) 
    	11.搭建高可用的服务全局配置中心(microservice-cloud-config)
    	12.服务的消息总线(microservice-consumer)
    	13.服务的全局链路追踪(microservice-zipkin)
    记录自己的搭建和开发工程，与大家分享有问题的话可以提出和指正！
    
    接下来所有的构建都是基于前章 maven的优化挂历和全局的jar包管理优化进行的，springboot工程的构建方法也是基于Springboot从0开始构建和运行原理介绍的纯净方式自行构建的。
    不了解的话可以先看下前面两章的内容
    
