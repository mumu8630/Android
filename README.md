# Android 
基于Android studio 编译工具的开发
基于移动设备开发大学生实验
##### 实验五--广播实验



# broadcast

## 动态注册和静态注册的区别

##### 1.优先级动态广播的优先级比静态广播高

##### 2.静态称为常驻型广播，程序关闭后收到消息也会被系统调用。

#####     动态不是常驻型广播，也就是说广播跟随程序的生命周期

##### 3.动态广播在代码里注册，而静态广播在AndroidManifest.xml中注册

## 静态广播的注册

### 1.静态广播需在==功能清单(manifests)==配置 

![image-20221026211945746](F:\22 Summer\javaweb-复&提\picture\image-20221026211945746.png)

#### enabled--->能否被实例化

#### exported--->能否被其他app调用

### 2.通过intent来传递给“绝对路径”的MyReceiver

### 3.intent.putExtra来存储key 和value

### 4.sendBroadcast(intent)来发送广播



## 动态广播

### 1.动态广播与静态广播最大的不同在于动态广播不需要通过xml配置，而是通过代码来调用

### 2.正常声明生命一个类MyReceiver 来继承BroadcastReceiver 

### 3.动态代理需要执行的生命周期

1. #### 注册动态广播

   - ##### 声明MyReceiver的对象

   - ##### 注册广播需要调用类->IntentFilter (意图过滤器)声明对象filter

   - ##### filter执行addAction来注册广播 -->后续intent通过setAction来调用同名action

   - ##### registerReceiver来注册广播

     - ###### myReceiver --->前面声明的MyReceiver对象

     - ###### filter --->前面声明的意图过滤器

2. #### 发送广播

   - ##### 通过intent来发送广播 发送给前文addAction  --->所以可以直接写死同名action

   - ##### intent.putExtra 传入相关 key value

   - ##### sendBroadcast 来发送广播

3. #### 销毁广播

   - ##### 通过unregisterReceiver来销毁myReceiver





## 有序广播（通过注册动态广播）

#### 1.注册广播

- ##### 在此，我们需要注册三个广播来观察其顺序

- ##### 所以需要创造三个MyRecceiver来继承BroadcastReceiver 分别定义 one two three

- ##### 各种继承onReceive 来输出不同的广播内容

- ##### 同样，需要定义 filter1,filter2,filter3

- ##### 继续执行addAction  registerReceiver

- ##### 在不同的filter中，需要设置各自的优先级(setPriority)  ---> 范围在-1000~1000

### 2.发送广播 此时需要用sendOrderedBroadcast

- ##### 传入两个参数

  - ###### intent

  - ###### 相关权限 --receiverPermission







