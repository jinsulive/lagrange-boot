<p align="center"><font size="6">Lagrange-Boot</font></p>

<p align="center">
    <img alt="Java-17" src="https://img.shields.io/badge/Java-17-brightgreen.svg"/>
    <img alt="SpringBoot-3.0.5" src="https://img.shields.io/badge/SpringBoot-3.0.5-green.svg"/>
    <img alt="GPL-3.0" src="https://img.shields.io/badge/license-GPL%203.0-blue.svg"/>
</p>

[//]: # (<p align="center">)

[//]: # (    <a href="https://github.com/jinsulive/lagrange-boot" target="_blank">)

[//]: # (        <img alt="lagrange-boot" src="https://img.shields.io/github/stars/jinsulive/lagrange-boot.svg?style=social&label=Stars"/>)

[//]: # (    </a>)

[//]: # (    <a href="https://gitee.com/jinsulive/lagrange-boot" target="_blank">)

[//]: # (        <img alt="lagrange-boot" src="https://gitee.com/jinsulive/lagrange-boot/badge/star.svg"/>)

[//]: # (    </a> )

[//]: # (</p>)

### 项目介绍

> 本项目基于[Lagrange.Core](https://github.com/KonataDev/Lagrange.Core)实现  
> 参照 [OneBot 11标准](https://github.com/botuniverse/onebot-11)  
> 基于SpringBoot 3.0.5 + Java 17 开发的SpringBoot组件  
> 本项目目前还处于开发阶段，相关内容后续可能会有所改动，部分sdk未经验证，如有错误，欢迎提issue  
>
并非所有标准API可用，具体参照[Lagrange.Core文档](https://github.com/LagrangeDev/Lagrange.Core?tab=readme-ov-file#features-list)

### 使用说明

<Details>
<summary>MAVEN引入</summary>

目前最新版本为 `1.0.0.Beta.3`，下文配置方式以最新版本为例
```xml
<dependency>
    <groupId>cn.jinsulive</groupId>
    <artifactId>lagrange-spring-boot-starter</artifactId>
    <version>版本号</version>
</dependency>
```

</Details>

> 使用`@EnableLagrangeBot`开启即可，如需启用内置的`http`的`sdk`，将`sendType`设置为`SendType.HTTP`  
> `lagrangeBotClient` 默认配置为 `cn.jinsulive.lagrange.sdk.DefaultLagrangeBotClient`  
> 若需自定义实现`lagrangeBotClient`，请继承`cn.jinsulive.lagrange.sdk.AbstractLagrangeBotClient`抽象类

#### 配置

> 两种配置方式二选一即可，若同时配置，YAML配置将覆盖JSON配置

<Details>
<summary>YAML方式</summary>

> 在spring-boot配置文件中配置

```yaml
lagrange:
  bots:
    - id: botId
      web-socket-server: ws://127.0.0.1:8081
      http-server: http://127.0.0.1:8083
      web-socket-token: ""
      http-token: ""
      token-type: "Bearer "
  open-mata-event-log: false
  open-debug-log: false
  lagrange-bot-client: cn.jinsulive.lagrange.sdk.DefaultLagrangeBotClient
```

</Details>

<Details>
<summary>JSON方式</summary>

> 将 `lagrange.json` 或 `config/lagrange.json` 文件放置到`classpath`目录或项目根目录下

[lagrange-example.json](./lagrange-spring-boot-starter/src/main/resources/lagrange-example.json)

```json
{
  "lagrange": {
    "bots": [
      {
        "id": 0,
        "webSocketServer": "ws://127.0.0.1:8081",
        "httpServer": "http://127.0.0.1:8083",
        "webSocketToken": "",
        "httpToken": "",
        "tokenType": "Bearer "
      }
    ],
    "openDebugLog": false,
    "openMataEventLog": false,
    "lagrangeBotClient": "cn.jinsulive.lagrange.sdk.DefaultLagrangeBotClient"
  }
}
```

</Details>

#### 事件监听

##### 1、消息事件

> 注册一个消息监听事件，监听方法允许的参数类型为`GroupMessageEvent`、`FriendMessageEvent`、`String`  
> 若设置为`GroupMessageEvent`或`FriendMessageEvent`，只会监听群或好友消息  
> 若设置为`String`，将传递一个json object类型的字符串，群和好友消息都会被监听

```java

@MessageListener(
        contentTrim = true, // 是否清除前后空格
        match = @MessageListener.Match(), // 匹配器
        filter = @MessageListener.Filter() // 过滤器
)
public void messageListener(String event) {
}
```

##### 2、通知事件

> 注册一个通知监听事件，允许的参数类型为`NoticeEvent`、`String`

```java

@NoticeListener(
        match = @NoticeListener.Match(), // 匹配器
        filter = @NoticeListener.Filter() // 过滤器
)
public void noticeListener(NoticeEvent event) {
}
```

##### 3、请求事件

> 注册一个请求监听事件，允许的参数类型为`RequestEvent`、`String`

```java

@RequestListener(
        match = @RequestListener.Match() // 匹配器
)
public void requestListener(RequestEvent event) {
}
```

#### 消息发送示例

> 以SDK形式发送为例

```java
    public void sendGroupMessage() {
        Long groupId = 0L;
        List<Message> messages = MessageChain.builder()
                .text("测试")
                .get();
        SendGroupMessageRequest request = new SendGroupMessageRequest();
        request.setGroupId(groupId);
        request.setMessage(messages);
        BotManager.getSdkClient(botId).execute(request);
    }
```

