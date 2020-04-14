# youqu
“友趣社区”微服务后台
* #### 简述：
  “友趣社区”：这是以“最右APP”为原型完成的毕业设计（右友可以集合嘻嘻），项目断断续续历经半年才完成。其中主要包括移动端APP、PC端管理后台。
  
  注：聊天后台借鉴了黑马的聊天项目，部分前端页面则来自DCloud、github，在此对原作者们表示衷心感谢!
  
  APP端: [传送门](https://github.com/ningxiaojian31/youqu-web) 
  
  PC端: [传送门](https://github.com/ningxiaojian31/youqu-pc)

* #### 系统架构：
<img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E6%9E%B6%E6%9E%84/%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%9E%B6%E6%9E%84.png" width="600" heigh="400"/>

* #### 模块设计：
<img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E6%9E%B6%E6%9E%84/%E6%A8%A1%E5%9D%97%E8%AE%BE%E8%AE%A1.png" width="600" heigh="400"/>

* #### 技术要点：
|  技术点   | 具体实现  |
|  ----  | ----  |
| Spring Boot  | 基础应用 |
| Spring Cloud  | 微服务化 |
| Mybatis-Plus  | 数据持久化 |
| Netty  | 即时通讯 |
| Redis | 点赞、收藏、邮箱验证码 |
| RabbitMQ | 邮箱验证码、日志 |
| 七牛云 | 文件存储 |


* #### 项目结构：
  - ***youqu-service-commons：***  公共模块
  - ***youqu-service-eureka：***  服务注册中心模块
  - ***youqu-service-zuul：***  网关路由模块
  - ***youqu-service-provider-invitation：***  帖子/评论/话题模块
  - ***youqu-service-provider-user：***  用户模块
  - ***youqu-service-provider-chat：***  聊天模块
  - ***youqu-service-other：***  redis/rabbitmq/七牛云/邮件集成模块

* #### 搭建：
<pre><code>
* 默认远程：无需安装环境，直接下载项目就能跑

  - 启动：
    1、启动eureka
    2、启动zuul
    3、启动other
    4、启动其他模块（commons无需启动）
    
  - 备注：
    统一网关入口：http://localhost:9999 （直接通过网关路由到其他模块需要token,即需要登录。测试接口的时候建议直接访问到具体模块）
    
* 本地：需要安装mysql/rabbitmq/redis、开通七牛云、开启邮箱SMTP，并修改相关连接参数
  数据库文件：sql/youqu.sql
</code></pre>

* #### 应用截图：

**APP：**

<img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%89%8D%E5%8F%B0/%E7%99%BB%E5%BD%95.jpg" width="200" heigh="300"/>    <img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%89%8D%E5%8F%B0/%E6%B3%A8%E5%86%8C.jpg" width="200" heigh="300"/>    <img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%89%8D%E5%8F%B0/%E8%81%8A%E5%A4%A9%E8%AE%B0%E5%BD%95.jpg" width="200" heigh="300"/>    <img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%89%8D%E5%8F%B0/%E5%BD%93%E5%89%8D%E8%81%8A%E5%A4%A9.jpg" width="200" heigh="300"/>

<img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%89%8D%E5%8F%B0/%E9%A6%96%E9%A1%B5.jpg" width="200" heigh="300"/>    <img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%89%8D%E5%8F%B0/%E5%9B%BE%E7%89%87%E8%AF%A6%E6%83%85.jpg" width="200" heigh="300"/>    <img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%89%8D%E5%8F%B0/%E8%A7%86%E9%A2%91%E8%AF%A6%E6%83%85.jpg" width="200" heigh="300"/>    <img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%89%8D%E5%8F%B0/%E5%8F%91%E5%B8%83%E5%B8%96%E5%AD%90.jpg" width="200" heigh="300"/>

<img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%89%8D%E5%8F%B0/%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83.jpg" width="200" heigh="300"/>    <img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%89%8D%E5%8F%B0/%E4%BF%AE%E6%94%B9%E4%B8%AA%E4%BA%BA%E4%BF%A1%E6%81%AF.jpg" width="200" heigh="300"/>


**PC：**

<img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%90%8E%E5%8F%B0/%E7%99%BB%E5%BD%95-%E5%90%8E%E5%8F%B0.png" width="600" heigh="400"/>
<img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%90%8E%E5%8F%B0/%E5%B8%96%E5%AD%90-%E5%90%8E%E5%8F%B0.png" width="600" heigh="400"/>
<img src="https://github.com/ningxiaojian31/youqu/blob/master/sql/img/%E5%90%8E%E5%8F%B0/%E6%97%A5%E5%BF%97-%E5%90%8E%E5%8F%B0.png" width="600" heigh="400"/>


* #### 联系作者：微信：ningxiaojian31
