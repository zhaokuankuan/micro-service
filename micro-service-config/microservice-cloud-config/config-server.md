springcloud-config全局配置中心服务端
分为服务端和客户端两个部分：

服务端：cloud-config工程
1.负责向git拉取配置的仓库的文件
可以将server发送到eureka中做高可用处理


客户端：consumer工程
从配置中心的配置端拉取当前工程的配置
 命令规范：
    工程的application名称，加上profile拉取配置文件的内容
    后期可以通过actactor和bus来动态的刷新和拉取修改的配置文件
    需要整合mq