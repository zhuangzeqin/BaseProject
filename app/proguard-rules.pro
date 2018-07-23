# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

#---------------------------------1.实体类---------------------------------
-keep class baseproject.demo.zzq.cn.eeepay.com.baseproject.bean.** { *; }
-keep class cn.eeepay.superchange._okhttpmanager.** { *; }
-keep class cn.eeepay.superchange._tab.** { *; }
-keep class baseproject.demo.zzq.cn.eeepay.com.baseproject.view.** { *; }
#播放器的相关类不混淆
-keep class com.android.tedcoder.wkvideoplayer.** { *; }
-keep class com.android.tedcoder.wkvideoplayer.**
-keep class org.cybergarage.** { *; }
-keep class org.cybergarage.**
-dontwarn com.android.tedcoder.wkvideoplayer.**
-dontwarn org.cybergarage.**
#---------------------------------第三方包---------------------------------
#）图片异步加载组件universal-image-loader配置
#图片加载
#universalimageloader图片加载框架不混淆
-keep class com.nostra13.universalimageloader.** { *; }#imageLoader包下所有类及类里面的内容不要混淆
-dontwarn com.nostra13.universalimageloader.**
#第三方zxing jar
#-libraryjars libs/core_3.2.0.jar

# 极光推送
-dontoptimize
-dontpreverify

-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }
-keep class * extends cn.jpush.android.helpers.JPushMessageReceiver { *; }

-dontwarn cn.jiguang.**
-keep class cn.jiguang.** { *; }
#-libraryjars libs/SaaS_AppAnalytics_Android_SDK_V4.0.9.jar
-keep class com.tendcloud.tenddata.** { *; }
-dontwarn com.tendcloud.tenddata.**
#-libraryjars libs/tbs_sdk_thirdapp_v3.6.0.1234_43608_sharewithdownload_withoutGame_obfs_20180510_111111.jar
-keep class com.tencent.** { *; }
-dontwarn com.tencent.**

#Gson相关的不混淆配置
-keepattributes Signature
-keepattributes *Annotation*
-keepattributes EnclosingMethod
-keep class com.google.gson.** { *; }
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-dontwarn com.google.gson.**
################okhttp###############
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn com.squareup.okhttp.**
#不混淆okio
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.** { *;}
-dontwarn okio.**
-dontwarn javax.annotation.Nullable
-dontwarn javax.annotation.ParametersAreNonnullByDefault
################ ButterKnife################
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}
################com.lovedise:permissiongen 权限检测################
-keepclassmembers class ** {
    @kr.co.namee.permissiongen.PermissionSuccess <methods>;
}
-keepclassmembers class ** {
    @kr.co.namee.permissiongen.PermissionFail <methods>;
}
-keep class kr.co.namee.permissiongen.**{ *; }
-dontwarn kr.co.namee.permissiongen.**
################Timber#################
-dontwarn org.jetbrains.annotations.**
################annotation###############
-keep class android.support.annotation.** { *; }
-keep interface android.support.annotation.** { *; }
################pickerview###############
-keep class com.bigkoo.pickerview.** { *; }
-keep interface com.bigkoo.pickerview.** { *; }
################Canary#################
-dontwarn com.squareup.haha.guava.**
-dontwarn com.squareup.haha.perflib.**
-dontwarn com.squareup.haha.trove.**
-dontwarn com.squareup.leakcanary.**
-keep class com.squareup.haha.** { *; }
-keep class com.squareup.leakcanary.** { *; }

#weixin
-keep class com.tencent.mm.opensdk.** {
   *;
}
-keep class com.tencent.wxop.** {
   *;
}
-keep class com.tencent.mm.sdk.** {
   *;
}
#人脸识别
-keep class com.linkface.** { *; }
-keep class com.sensetime.** { *; }
#---------------------------------webview------------------------------------
-keepclassmembers class fqcn.of.javascript.interface.for.Webview {
   public *;
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, jav.lang.String);
}
#---------------------------------3.与js互相调用的类------------------------
#-keepclasseswithmembers class com.demo.login.bean.ui.MainActivity$JSInterface {
#      <methods>;
#}
#如果是内部类的话，你可以这样
#-keepclasseswithmembers class 你的类所在的包.父类$子类 { <methods>; }
#---------------------------------4.反射相关的类和方法-----------------------
#-keep class 你的类所在的包.** { *; }


#-------------------------------------------基本不用动区域--------------------------------------------
#---------------------------------基本指令区----------------------------------
-dontskipnonpubliclibraryclasses # 不忽略非公共的库类
-dontskipnonpubliclibraryclassmembers #指定不去忽略非公共的库的类的成员
-optimizationpasses 5            # 指定代码的压缩级别，代码混淆的压缩比例，值在0-7之间
-dontusemixedcaseclassnames      # 是否使用大小写混合
-dontpreverify                   # 混淆时是否做预校验
-verbose                         # 混淆时是否记录日志
-keepattributes *Annotation*,InnerClasses     # 保持注解
-dontwarn                        # 忽略警告
-dontoptimize                    # 优化不优化输入的类文件
-printmapping proguardMapping.txt #生成原类名和混淆后的类名的映射文件
-keepattributes Signature         #不混淆泛型
-keepattributes SourceFile,LineNumberTable #抛出异常时保留代码行号
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*  # 混淆时所采用的算法

#---------------------------------默认保留区---------------------------------
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService
#-keepnames class * implements java.io.Serializable #不混淆Serializable
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-keep public class * extends android.support.** #如果有引用v4或者v7包，需添加
-keep class android.support.** {*;}
-keepclassmembers class **.R$* { #不混淆资源类
    public static <fields>;
}
-keepclasseswithmembernames class * {  # 保持 native 方法不被混淆
    native <methods>;
}
-keepclassmembers class * extends android.app.Activity { # 保持自定义控件类不被混淆
    public void *(android.view.View);
}
-keepclassmembers enum * {             # 保持枚举 enum 类不被混淆
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keepclassmembers class * {
    void *(**On*Event);
}
-keep class * implements android.os.Parcelable {         # 保持 Parcelable 不被混淆
    public static final android.os.Parcelable$Creator *;
}
 # 保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
#生成日志数据，gradle build时在本项目根目录输出
-dump class_files.txt            #apk包内所有class的内部结构
-printseeds seeds.txt            #未混淆的类和成员
-printusage unused.txt           #打印未被使用的代码
-printmapping mapping.txt        #混淆前后的映射

######################################################
# icloudsoft
-keep class chat.icloudsoft.**{*;}
-dontwarn chat.icloudsoft.**

-keep class com.nineoldandroids.**{*;}

# tavendo
-keep class de.tavendo.autobahn.**{*;}
-dontwarn de.tavendo.**

# dom4j
-keep class org.dom4j.** { *; }
-dontwarn org.dom4j.**

# retrofit
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn com.fasterxml.**
-dontwarn retrofit2.**

# picasso
-dontwarn com.squareup.okhttp.**
-dontwarn com.squareup.picasso.**

-keep class org.json.** { *; }
#Android 代码混淆异常 transformClassesAndResourcesWithProguardForRelease FAILED
-ignorewarnings   # 抑制警告

# otto混淆规则
-keepattributes *Annotation*
-keepclassmembers class ** {
    @com.squareup.otto.Subscribe public *;
    @com.squareup.otto.Produce public *;
}
#arouter 混淆规则
-keep public class com.alibaba.android.arouter.routes.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}
# 如果使用了 byType 的方式获取 Service，需添加下面规则，保护接口
-keep interface * implements com.alibaba.android.arouter.facade.template.IProvider
# 如果使用了 单类注入，即不定义接口实现 IProvider，需添加下面规则，保护实现
-keep class * implements com.alibaba.android.arouter.facade.template.IProvider
