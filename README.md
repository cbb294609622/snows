###Android 项目 -- 雪极###
    **博主滑雪运动爱好者，由于是穷屌丝，没钱请教练，只能网上随便找一些零散视频看着学。割了！
    **所以，博主打算免费提供一款APP 让大家有个学习交流圣地。
    **能否完整开发完成，还要看博主的时间是否允许！
    **至此，代码全部提交到GITHUB，以便及时更新！
=============================
###1.InstallActivity 秒开应用
	其实就是欺骗自己眼睛的一种技术，启动页面什么都不做，在样式Style里面去重写Theme。
###2.SplashActivity 广告页面
	一张图片加一个定时器。图片做了个放大动画，根据定时器的6秒 去规定动画播放的时间。
###3.CrashHandler 全局异常捕获
    放在MyApplication进行初始化，一旦应用异常退出，可以捕获异常，缓存到本地。
###4.增加2个Base类 一个Activity，一个Fragment的。
    注:BaseActivity有带沉浸式状态栏
###5.GuideActivity 引导页面
    添加了guidelibrary第三方类库，进行了guide编写，图文需要替换
###6.Butterknife 增加注解 
    放弃findviewById,使用注解view不能是private类型。
