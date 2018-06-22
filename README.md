[TOC]

# Revolver
> 一款使用简单的反射工具库，它的宗旨是让反射调用变得简单且直观

## 一、简介
Revolver是一款完全模仿Retrofit的设计风格。
它主要是对反射类方法和字段的实现进行了封装.
调用者只需要构建一个interface,在内部配置需要反射的接口(字段)即可实现接口(字段)的反射。

## 二、使用方法

- 构建Revolver对象
  ```
  mRevolver = new Revolver.Builder()
                  .level(Build.VERSION.SDK_INT)
                  .build();
  ```
  我们通过Revolver的Builder类来构建一个Revolver的对象，目前这个Builder的内容比较简单。
  level()的意义是为了实现api的调用限制。因为有的方法在低版本的sdk中是不存在的，这就意味
  着我们的反射是会出现异常，为了解决这种问题，所以设定一个一个api的level，来确保我们需要
  在反射的时候会通过api的level来判断是否要对当前方法做反射，如果达不到api标准则返回默认值。
  
- 接口声明
  ```java
  public interface Api {
    
    @CLASS("android.telephony.TelephonyManager")
    String getImei(@Invoker("android.telephony.TelephonyManager") Object invoker);
  
  }
  ```
  用Revolver反射接口(方法)是需要通过接口声明。