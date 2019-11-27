# SpringCloud 项目
###springboot-emailf:功能:邮件发送  定时任务  异步请求先返回执行结果 后执行

### 消费者:springcloud- consumer-dept-80: Dept80 集成Eureka服务注册于发现 通过Ribbon实现负载均衡  通过RestTemplate调用Service层
### 消费者:springcloud-consumer-dept-feign:Dept80 集成Eureka 服务注册于发现  通过Feign调用 srpingcloud-api01 的service(有点问题)

### 服务注册于发现: springcloud-eureka-7001:配置Eureka 搭载Eureka集群 7002和7003


### 提供者:springcloud-provider01-dept-8001 :配置Eureka 要注册在Eureka的集群里面 实现sql监控页面


### 服务熔断:springcloud-provider-dept-hystrix-8001 :配置Hystrix 

![](https://oscimg.oschina.net/oscnet/a60f3008dd96969889fb9e2e6652800636e.jpg)
## 一般项目流程:
- 导入依赖      pom
- 编写配置     yml...
- 开启这个功能  @Enable...
- 配置类
## Zookeeper 和 Eureka的区别
[Zookeeper 和 Eureka的区别](https://www.cnblogs.com/u013533289/p/11629059.html)  
### ZooKeeper作为发现服务的问题
在分布式系统领域有个著名的 CAP定理（C- 数据一致性；A-服务可用性；P-服务对网络分区故障的容错性，这三个特性在任何分布式系统中不能同时满足，最多同时满足两个）；ZooKeeper是个 CP的，即任何时刻对ZooKeeper的访问请求能得到一致的数据结果，同时系统对网络分割具备容错性；但是它不能保证每次服务请求的可用性（注：也就 是在极端环境下，ZooKeeper可能会丢弃一些请求，消费者程序需要重新请求才能获得结果）。但是别忘了，ZooKeeper是分布式协调服务，它的 职责是保证数据（注：配置数据，状态数据）在其管辖下的所有服务之间保持同步、一致；所以就不难理解为什么ZooKeeper被设计成CP而不是AP特性 的了，如果是AP的，那么将会带来恐怖的后果（注：ZooKeeper就像交叉路口的信号灯一样，你能想象在交通要道突然信号灯失灵的情况吗？）。而且， 作为ZooKeeper的核心实现算法 Zab，就是解决了分布式系统下数据如何在多个服务之间保持同步问题的。
### 做出正确的选择：Eureka的成功
## Eureka 和 Ribbon:
![](http://small-howe.cn-bj.ufileos.com/26a04598-d82b-476b-9019-884f8b01f5ff.png?UCloudPublicKey=TOKEN_7728f428-03f0-4a5f-b3fd-e5632771d02e&Signature=znWbJGOVAWrESeFUcv%2FudM%2Fz2%2Fk%3D&Expires=1890026105)

## Feign 和 Ribbon (Feign 集成了Ribbon)负载均衡
Ribbon 基于客户端去做负载均衡
Feign的声明式的web service客户端

## Hystrix
![Hystrix](https://www.cnblogs.com/cjsblog/p/9391819.html)
![](https://images2018.cnblogs.com/blog/874963/201807/874963-20180730172725624-245631738.png)