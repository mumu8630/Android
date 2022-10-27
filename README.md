# Android 
基于Android studio 编译工具的开发
基于移动设备开发大学生实验
##### 实验三--service实验



# RandomService

Handler是android提供更新UI的一套消息处理机制，主要作用有两个：
1.在新启动的线程中发送消息
2.在主线程中获取，处理消息
https://www.ngui.cc/el/1226780.html?action=onClick



## Activity 方法中

////////////////////////////////////

#### 1.定义一个activity 继承 activity

#### 2.定义layout组件的类型

​    textview button

#### 3.然后我们需要实现它的生命周期 onCreate  onDestroy

#### 4.在初始化onCreate中 我们获取layout 中组件的id  

- num =(TextView)findViewById(R.id.count);

- start = (Button) findViewById(R.id.button1);

- stop = (Button)findViewById(R.id.button2);

#### 5.并且给按钮附加监听器 setOnClickListener 分别执行 开启service 和 关闭service

#### 6.因为我们这儿需要的是刷新页面数据 每2秒刷新随机数 所以需要开启线程 Runnable 匿名内部实现

​    在run方法中 给textview赋值

#### 7.创建handler 将 Runnable线程信息发送给在主线程中的handler执行

#### 8.定义一个方法 UpdateCount 参数类型为 double 将值赋值给 activity的随机数randomNum

--------------------------------------------------------------------

## Service 方法中

\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

#### 1.先继承Service 

#### 2.再实现其生命周期 

######     1.OnCreate ---初始化

######     2.onStartCommand ---开启行为

######     3.OnBind ---绑定

######     4.onDestroy ---销毁

#### 3.定义本service的线程为 workThread

#### 4.本机线程的Runnable 定义其方法 

######     条件(线程未被中断) { 即可以正常执行该线程 }

###### ----》执行主要方法(生成随机数)

###### ----》执行在Activity中的 UpdateCount方法 将随机数传送给前端页面

###### ----》线程睡眠时间为2秒{暂停两秒后继续线程} 此时需要捕获异常

#### 5.在初始化中 存储 Runnable

​    workThread = new Thread(null,backgroundWork,"WorkThread");

#### 6.开启行为(onStartCommand)中 开启线程 (先判断线程是否执行完毕)

当onStartCommand() 方法的返回值为常量START_NOT_STICKY 时,表明在 onStartCommand() 方法运行结束后,如果系统杀死了Service,系统就不会再重建这个 Service,除非有待处理意图投递给它。这样,Service 在意外中止后将停止运行。


