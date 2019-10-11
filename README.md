# boot-cloud-demo
集成了`Eureka`,`Feign`,`Hystrix`,`Config`,`Zuul`组件的Spring Cloud项目示例项目,四个模块需要分别启动

## eureka-server
### 组件说明
- `config`作为`config-server`获取git上的分布式系统的配置,
 [config-repo地址](https://github.com/B3C2BAB2/config-repo)
- `eureka-server`用于注册`eureka`实例
- `hystrix-dashboard`使用`hystrix`仪表盘查看`hystrix`的使用情况

### 重要接口
- 显示eureka实例的运行状况:
[http://localhost:8761/](http://localhost:8761/)
- 熔断器仪表盘,输入`http://localhost:8081/actuator/hystrix.stream`可查看`feign-service`的熔断器使用情况:
[http://localhost:8761/hystrix](http://localhost:8761/hystrix)
- 获取`feign-service`的配置文件:
[http://localhost:8761/feign-service-develop.properties](http://localhost:8761/feign-service-develop.properties)
- 获取`feign-client`的配置文件:
[http://localhost:8761/feign-client-develop.properties](http://localhost:8761/feign-client-develop.properties)
- 获取`zuul-server`的配置文件:
[http://localhost:8761/zuul-server-develop.properties](http://localhost:8761/zuul-server-develop.properties)

## feign-service
### 组件说明
- `config`用于从`config-server`获取配置
- `eureka-client`用于在`eureka-server`上发现其他的`eureka`客户端
- `hystrix`熔断器,这里的示例用于异常处理

### 重要接口
- 返回1/{number}的整数结果:
[http://localhost:8080/service/hystrix-test/1](http://localhost:8080/service/hystrix-test/1)
- 通过计算除数为0的算式抛出运行时异常以触发`@HystrixCommand`:
[http://localhost:8080/service/hystrix-test/0](http://localhost:8080/service/hystrix-test/0)
- 返回`feign-service`的`eureka`实例名,供`zuul-server`调用:
[http://localhost:8080/service/name](http://localhost:8080/service/name)

## feign-client
### 组件说明
- `config`用于从`config-server`获取配置
- `eureka-client`用于在`eureka-server`上发现其他的eureka客户端
- `feign`用于调用`feign-service`的接口

### 重要接口
- 使用`feign`调用上述`feign-service`的接口:
[http://localhost:8081/client/hystrix-test/0](http://localhost:8081/client/hystrix-test/0)
- 返回`feign-client`的`eureka`实例名,供`zuul-server`调用:
[http://localhost:8081/client/name](http://localhost:8081/client/name)

## zuul-server
模块中不编写任何接口，只通过`zuul`调用`feign-service`,`feign-client`的接口
### 组件说明
- `config`用于从`config-server`获取配置
- `eureka-client`用于在`eureka-server`上发现其他的`eureka`客户端
- `zuul`起路由和过滤器的功能

### 重要接口
- 使用过滤器处理，返回`feign-service`的`eureka`实例名:
[http://localhost:8082/service/name](http://localhost:8082/service/name)
- 使用过滤器处理，返回`feign-client`的`eureka`实例名:
[http://localhost:8082/client/name](http://localhost:8082/client/name)

## 参考文档
* [https://cloud.spring.io/spring-cloud-netflix/reference/html/](https://cloud.spring.io/spring-cloud-netflix/reference/html/)
* [https://cloud.spring.io/spring-cloud-config/reference/html/](https://cloud.spring.io/spring-cloud-config/reference/html/)