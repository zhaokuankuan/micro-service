
maven工程构建和jar包管理优化
架构的演变暂且不谈，能够点进来这篇文章的我想应该对架构的演变工程有一定的理解：
从 单体架构
   集群部署
   SoA
   分布式架构
   服务网格
 可见，现在的项目所需要的工程越来越庞大，功能也是越来越细分,伴随着工程数量的增长，虽然有很多的工程管理工具，但是需要管理的工程数量和jar包的版本也是很麻烦的。
 今天就来谈谈在项目开发过程中需要注意的一些目录结构的划分和jar的管理问题。
 一.项目构建和管理中遇见的问题
      

 1. 工程迭代中各模块的版本控制
 2. 工程中所依赖的第三方包的版本控制
 3. 各个子模块的依赖包的问题,继承父类中的无用jar包
 二.解决以上问题可以通过优化工程的构建和jar包的管理来实现。
 
 1.创建父亲工程pom文件如下：
 	

``` stylus
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <version>1.0.0</version>
    <packaging>pom</packaging>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.microservice.platform</groupId>
    <artifactId>microservice-platform</artifactId>
    <description>springcloud工程技术栈合集</description>

    <modules>
        <module>micro-service-register</module>
        <module>micro-service-server</module>
        <module>micro-service-gateway</module>
        <module>micro-service-config</module>
        <module>micro-service-sleuth</module>
        <module>micro-service-hystrix</module>
    </modules>


    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <springcloud-dependencies.vsersion>Finchley.SR4</springcloud-dependencies.vsersion>
        <springboot-dependencies.version>2.0.9.RELEASE</springboot-dependencies.version>
        <springboot-maven-plugin.version>2.1.1.RELEASE</springboot-maven-plugin.version>
        <fastjson.version>1.2.60</fastjson.version>
    </properties>


    <dependencies>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.7</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>${fastjson.version}</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${springcloud-dependencies.vsersion}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${springboot-dependencies.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <pluginManagement>
            <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                    <version>${springboot-maven-plugin.version}</version>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>


    <developers>
        <developer>
            <name>zhaokk</name>
            <email>935068797@qq.com</email>
        </developer>
    </developers>

</project>
```
说明：
 dependencyManagement ：用来管理jar包的版本的,加入到此标签中的jar不会出现在子类中出现，除非主动的子类中引入
 properties：将一些工程中配置的关于版本的信息提出到这里统一管理
 不需要继承任何第三方包，并且在dependency标签中只能出现所有模块中都用到的jar包，不然将jar包放入到dependencyManagement中，避免重复依赖的问题
 2.创建子工程的pom文件如下：
 

``` stylus
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>microservice-platform</artifactId>
        <groupId>com.microservice.platform</groupId>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.microservice.platform</groupId>
    <artifactId>micro-service-hystrix</artifactId>
    <packaging>pom</packaging>
    <modules>
        <module>microservice-hystrix-databoard</module>
        <module>microservice-hystrix-turbine</module>
    </modules>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
        </dependency>
    </dependencies>
</project>
```
说明：
1.只需要继承父工程的jar包，不用继承别的第三方包
2.需要引入的jar包在dependencies引入即可，不用携带版本，自动从父模块中继承约定的版本，避免了整个系统中的版本不一致的问题

三.总结
	按照上面的构建思路和jar包的引用规则就可以解决之前提到的三个问题，以上是个人在开发和构建工程的过程中总结的一些新的和体会，记录下来一方面也是跟大家共享。
    也是为后面的博文，springcloud实战做一个铺垫，项目地址，可以参考该项目加深对模块管理的理解。
    如有问题或者理解不到位的地方，欢迎一起留言探讨！

 	


 