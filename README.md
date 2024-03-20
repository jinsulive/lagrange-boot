<p align="center">
    <img alt="" src="https://img.shields.io/badge/Java-17-brightgreen.svg"/>
    <img alt="" src="https://img.shields.io/badge/SpringBoot-3.0.5-green.svg"/>
</p>

## Lagrange-Boot

> 本项目基于[Lagrange.Core](https://github.com/KonataDev/Lagrange.Core)实现  
> 参照 [OneBot 11标准](https://github.com/botuniverse/onebot-11)

#### 问题说明
>
> 1、若出现``InaccessibleObjectException: Unable to make xxx accessible: module java.base does not "opens java.util" to unnamed module ``  
> 这是由jdk9及以上版本的模块化系统引入的一个安全特性导致的。自Java 9起，核心类库被组织成模块，并且默认情况下对非模块化的代码（unnamed module）提供了封装保护。  
> 解决方案：请添加``VM options``参数，将模块开放非模块化代码使用
>
> ```
> --add-opens java.base/java.util=ALL-UNNAMED
> ```
> 

