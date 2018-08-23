package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.act;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.byteam.superadapter.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.adapter.SingleAdapter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.base.BaseMvpActivity;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.view.recyclerview.CommonLinerRecyclerView;


//import rx.Observable;

/**
 * 描述：RxJava 的基础使用
 * 作者：zhuangzeqin
 * 时间: 2018/8/9-20:58
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
@Route(path = "/RxJava/RxJavaActivity")
public class RxJavaActivity extends BaseMvpActivity {
    private CommonLinerRecyclerView commonLinerRecyclerView;
    private SingleAdapter mSingleAdapter;
    private List<String> items = new ArrayList<>();
    private SmartRefreshLayout refreshLayout;

    @Override
    protected int getContentView() {
        return R.layout.activity_rx_java;
    }

    @Override
    protected String setTitle() {
        return "RxJava 的基础使用";
    }

    @Override
    protected void initView() {
        initBgBar(R.color.eposp_red_2);
        refreshLayout = (SmartRefreshLayout) getViewById(R.id.refreshLayout);
        commonLinerRecyclerView = (CommonLinerRecyclerView) getViewById(R.id.rv_list);
        mSingleAdapter = new SingleAdapter(mContext, items, R.layout.listitem);
        mSingleAdapter.setData(items);
        commonLinerRecyclerView.setAdapter(mSingleAdapter);
    }

    @Override
    protected void eventOnClick() {


        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(500);
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(500);
            }
        });
        refreshLayout.setNoMoreData(true);
        mSingleAdapter.setOnlyOnce(false);
        mSingleAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int viewType, int position) {
                switch (position) {
//                    case 0:
//                        initMerge();
//                        break;
//                    case 1:
//                        initzip();
//                        break;
//                    case 2:
//                        initScan();
//                        break;
//                    case 3:
//                        initFilter();
//                        break;
//                    case 4:
//                        initelementAt();
//                        break;
//                    case 5:
//                        initStartWith();
//                        break;
//                    case 6:
////                        delay操作符，延迟数据发送
//                        initdelay();
//                        break;
//                    case 7:
//                        initTimer();
//                        break;
//                    case 8:
//                        initinterval();
//                        break;
//                    case 9:
//                        initdoOnNext();
//                        break;
//                    case 10:
//                        initbuffer();
//                        break;
//                    case 11:
//                        inintthrottleFirst();
//                        break;
//                    case 12:
//                        initDistinct();
//                        break;
//                    case 13:
//                        initdebounce();
//                        break;
//                    case 14:
//                        initdoOnSubscribe();
//                        break;
//                    case 15:
//                        initRange();
//                        break;
//                    case 16:
//                        initdefer();
//                        break;
//                    case 17:
//                        initmap();
//                        break;
//                    case 18:
//                        initflatMap();
//                        break;
//                    case 19:
//                        initrepeat();
//                        break;
//                    case 20:
//                        initgroupBy();
//                        break;
//                    case 21:
//                        initcast();
//                        break;
//                    case 22:
//                        initwindow();
//                        break;
//                    case 23:
//                        initoftype();
//                        break;
//                    case 24:
//                        initSingle();
//                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {
        items.add("merge操作符，合并观察对象");
        items.add("zip操作符,合并多个观察对象的数据。并且允许Func2函数重新发送合并后的数据");
        items.add("scan累加器操作符的使用");
        items.add("filter过滤操作符的使用");
        items.add("elementAt的指定元素发送使用");
        items.add("startWith开头插入指定的项");
        items.add("delay操作符延迟数据发送");
        items.add("timer 操作符");
        items.add("interval 轮询操作符");
        items.add("doOnNext() 操作符");
        items.add("Buffer 操作符");
        items.add("throttleFirst && throttleLast 操作符");
        items.add("distinct操作符过滤重复的数据");
        items.add("debounce() 操作符一段时间后如果没有任何操作就开始发送事件");
        items.add("doOnSubscribe() 操作符");
        items.add("Range操作符");
        items.add("defer 操作符是在订阅者订阅时才创建Observable");
        items.add("map 操作符是一对一的转化");
        items.add("flatmap 操作符是一对多的转化");
        items.add("repeat/repeatWhen操作符");
        items.add("groupBy分组操作符");
        items.add("cast类型转换操作符");
        items.add("window操作符跟Buffer类似");
        items.add("ofType操作符按照类型对结果进行过滤");
        items.add("single操作符");
    }
//
//    /**
//     * merge操作符，合并观察对象
//     */
//    private void initMerge() {
//        List<String> list1 = new ArrayList<>(5);
//        List<String> list2 = new ArrayList<>(5);
//        //list1
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        //list2
//        list2.add("a");
//        list2.add("b");
//        list2.add("c");
//        Observable<String> observable1 = Observable.from(list1);
//        Observable<String> observable2 = Observable.from(list2);
//        //合并数据先发送observable1的全部数据，然后发送 observable2的全部数据
//        Observable.merge(observable1, observable2).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Logger.d("rx-- " + s);
//            }
//        });
//    }
//
//    /**
//     * ------注释说明--zip操作符，合并多个观察对象的数据。并且允许 Func2（）函数重新发送合并后的数据------
//     **/
//    private void initzip() {
//        List<String> list1 = new ArrayList<>(5);
//        List<String> list2 = new ArrayList<>(5);
//        //list1
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        //list2
//        list2.add("a");
//        list2.add("b");
//        list2.add("c");
//        list2.add("d");//多出一个d 出现了数据项不等的情况
//        Observable<String> observable1 = Observable.from(list1);
//        Observable<String> observable2 = Observable.from(list2);
//        //合并两个的观察对象数据项应该是相等的；如果出现了数据项不等的情况，合并的数据项以最小数据队列为准。
//        Observable.zip(observable1, observable2, new Func2<String, String, String>() {
//            @Override
//            public String call(String s, String s2) {
//                return String.format("%s%s", s, s2);
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Logger.d("rx-- " + s);
//            }
//        });
//    }
//
//    /**
//     * ------注释说明--scan累加器操作符的使用------
//     **/
//    private void initScan() {
//        //数组
//        Observable<Integer> just = Observable.just(1, 2, 3, 4, 5);
//        just.scan(new Func2<Integer, Integer, Integer>() {
//            @Override
//            public Integer call(Integer integers, Integer integers2) {
//                return integers + integers2;
//            }
//        }).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                //第一次发射得到1，作为结果与2相加；发射得到3，作为结果与3相加，以此类推，打印结果：
//                Logger.d("rx-- " + integer);
//            }
//        });
//    }
//
//    /**
//     * ------注释说明--filter 过滤操作符的使用------
//     **/
//    private void initFilter() {
//        Observable<Integer> just = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        just.filter(new Func1<Integer, Boolean>() {
//            @Override
//            public Boolean call(Integer integer) {
//                return integer > 5;//大于5的事件打印出来
//            }
//            /** ------注释说明-------- **/
//         /*   消息数量过滤操作符的使用
//            take ：取前n个数据
//            takeLast：取后n个数据
//            first 只发送第一个数据
//            last 只发送最后一个数据
//            skip() 跳过前n个数据发送后面的数据
//            skipLast() 跳过最后n个数据，发送前面的数据*/
//        }).take(3).takeLast(2).skip(1).last().subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                System.out.println("filter-- " + integer);
//            }
//        });
//    }
//
//    private void initelementAt() {
//        Observable<Integer> just = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        //elementAt() 发送数据序列中第n个数据 ，序列号从0开始
//        //如果该序号大于数据序列中的最大序列号，则会抛出异常，程序崩溃
//        //所以在用elementAt操作符的时候，要注意判断发送的数据序列号是否越界
//        just.elementAt(2).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                System.out.println("elementAt-- " + integer);
//            }
//        });
//        //定义订阅者
//        Observer<Integer> integerObserver = new Observer<Integer>() {
//
//            @Override
//            public void onError(Throwable e) {
//                System.out.println("elementAtOrDefault-- " + e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                System.out.println("elementAtOrDefault-- " + integer);
//            }
//        };
//        //elementAtOrDefault( int n , Object default ) 发送数据序列中第n个数据 ，序列号从0开始。
//        //如果序列中没有该序列号，则发送默认值
////        Subscription subscribe = just.elementAtOrDefault(11, 1001).subscribe(integerObserver);
//    }
//
//    //delay操作符，延迟数据发送
//    //延迟数据发射的时间，仅仅延时一次，也就是发射第一个数据前延时。发射后面的数据不延时
//    private void initdelay() {
//        Observable<Integer> just = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        //延迟3秒钟
//        just.delay(3, TimeUnit.SECONDS).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                System.out.println("delay-- " + integer);
//            }
//        });
//
////        Timer 延时操作符的使用;使用场景：xx秒后，执行xx
//    }
//
//    private void initTimer() {
//        //5秒后输出 hello world ,
////        timer 返回一个 Observable , 它在延迟一段给定的时间后发射一个简单的数字0
////        timer 操作符默认在computation调度器上执行，当然也可以用 Scheduler 在定义执行的线程。
//
////        io.reactivex.Observable.timer(5, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
////            @Override
////            public void call(Long aLong) {
////                System.out.println("timer--hello world " + aLong);
////            }
////        });
//       /* delay 、timer 总结：　
//        相同点：delay 、 timer 都是延时操作符。
//        不同点：delay  延时一次，延时完成后，可以连续发射多个数据。timer延时一次，延时完成后，只发射一次数据。*/
//    }
//
//    //    interval 轮询操作符，循环发送数据，数据从0开始递增
//    private void initinterval() {
//        //参数一：延迟时间  参数二：间隔时间  参数三：时间颗粒度
//        //循环发送数字
//        //循环发送数字
////       Observable.interval(0, 1, TimeUnit.SECONDS).
//////                subscribeOn(Schedulers.io()).
//////                observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
//////            @Override
//////            public void call(Long aLong) {
//////                System.out.println("lifecycle--" + aLong);
//////            }
//////        });
//       /* io.reactivex.Observable.interval(0, 1, TimeUnit.SECONDS).
//                compose(this.<Long>bindToLifecycle())
//                .subscribeOn(io.reactivex.schedulers.Schedulers.io()).
//                observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread()).
//                subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        System.out.println("lifecycle--" + aLong);
//                    }
//                });*/
////                .subscribe(new Action1<Long>() {
////                    @Override
////                    public void call(Long aLong) {
////                        System.out.println("lifecycle--" + aLong);
////                    }
////                });
////        Subscription subscribe = Observable.interval(0, 1, TimeUnit.SECONDS)
////                .subscribeOn(Schedulers.io())
////                .compose(this.<Long>bindToLifecycle())   //这个订阅关系跟Activity绑定，Observable 和activity生命周期同步
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe(new Action1<Long>() {
////                    @Override
////                    public void call(Long aLong) {
////                        System.out.println("lifecycle--" + aLong);
////                    }
////                });
//
//      /*  bindUntilEvent( ActivityEvent event)
//
//        ActivityEvent.CREATE: 在Activity的onCreate()方法执行后，解除绑定。
//
//        ActivityEvent.START:在Activity的onStart()方法执行后，解除绑定。
//
//        ActivityEvent.RESUME:在Activity的onResume()方法执行后，解除绑定。
//
//        ActivityEvent.PAUSE: 在Activity的onPause()方法执行后，解除绑定。
//
//        ActivityEvent.STOP:在Activity的onStop()方法执行后，解除绑定。
//
//        ActivityEvent.DESTROY:在Activity的onDestroy()方法执行后，解除绑定*/
//    }
//
//    /**
//     * ------注释说明---doOnNext() 操作符-----
//     **/
//    private void initdoOnNext() {
////        在每次 OnNext() 方法被调用前,执行使用场景：从网络请求数据，在数据被展示前，缓存到本地
//        Observable<Integer> just = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
////        just.doOnNext(new Action1<Integer>() {
////            @Override
////            public void call(Integer integer) {
////                System.out.println("doOnNext--缓存数据" + integer);
////            }
////        }).subscribe(new Observer<Integer>() {
////            @Override
////            public void onCompleted() {
////
////            }
////
////            @Override
////            public void onError(Throwable e) {
////
////            }
////
////            @Override
////            public void onComplete() {
////
////            }
////
////            @Override
////            public void onSubscribe(Disposable d) {
////
////            }
////
////            @Override
////            public void onNext(Integer integer) {
////                System.out.println("onNext--" + integer);
////            }
////        });
//    }
//
//    private void initbuffer() {
////        Buffer( int n )      把n个数据打成一个list包，然后再次发送。
////        Buffer( int n , int skip)   把n个数据打成一个list包，然后跳过第skip个数据
////        使用场景：一个按钮每点击3次，弹出一个toast
//
//        List<String> list = new ArrayList<>();
//        for (int i = 1; i < 10; i++) {
//            list.add("" + i);
//        }
//        Observable<String> observable = Observable.from(list);
//        //把每3个数据为一组打成一个包，然后发送
//        observable.buffer(3, 2).subscribe(new Action1<List<String>>() {
//            @Override
//            public void call(List<String> strings) {
//                System.out.println("buffer------3个数据为一组打成一个包---------");
//                Observable.from(strings).subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        System.out.println("buffer data --" + s);
//                    }
//                });
//            }
//        });
//    }
//
//    /**
//     * ------注释说明--throttleFirst 操作符------
//     **/
//    private void inintthrottleFirst() {
////        在一段时间内，只取第一个事件，然后其他事件都丢弃。
////        使用场景：1、button按钮防抖操作，防连续点击   2、百度关键词联想，在一段时间内只联想一次，防止频繁请求服务器
////        throttleLast   在一段时间内，只取最后一个事件，然后其他事件都丢弃。
//
//
////        是循环发送数据，每秒发送一个。throttleFirst( 3 , TimeUnit.SECONDS )   在3秒内只取第一个事件，其他的事件丢弃。
//        Observable.interval(1, TimeUnit.SECONDS)
//                .throttleLast(2, TimeUnit.SECONDS, Schedulers.io())
////                .throttleFirst( 3 , TimeUnit.SECONDS )
//                .subscribe(new Action1<Long>() {
//                    @Override
//                    public void call(Long aLong) {
//                        //0,3,6
//                        System.out.println("throttleFirst--" + aLong);
//                    }
//                });
//    }
//
//    private void initDistinct() {
////        distinct 过滤重复的数据
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("1");
//        list.add("3");
//        list.add("4");
//        list.add("4");
//        list.add("4");
//        list.add("2");
//        list.add("1");
//        list.add("1");
//        list.add("1");
//        Subscription subscribe = Observable.from(list).distinct().subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                //1,2,3,4
//                System.out.println("distinct--" + s);
//            }
//        });
//        if (!subscribe.isUnsubscribed()) {
//            subscribe.unsubscribe();
//        }
////        distinctUntilChanged()操作符过滤连续重复的数据
//        Observable.from(list).distinctUntilChanged().subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println("distinctUntilChanged--" + s);
//            }
//        });
//    }
//
//    //debounce() 操作符 一段时间内没有变化，就会发送一个数据。
//    private void initdebounce() {
////        使用场景：百度关键词联想提示。在输入的过程中是不会从服务器拉数据的。当输入结束后，在400毫秒没有输入就会去获取数据。
////        避免了，多次请求给服务器带来的压力.
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("1");
//        Observable.from(list).debounce(500, TimeUnit.MILLISECONDS).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                //1
//                System.out.println("debounce--" + s);
//            }
//        });
//    }
//
//    private void initdoOnSubscribe() {
////        doOnSubscribe 操作符 使用场景： 可以在事件发出之前做一些初始化的工作，比如弹出进度条等
////        注意：
////        1、doOnSubscribe() 默认运行在事件产生的线程里面，然而事件产生的线程一般都会运行在 io 线程里。那么这个时候做一些，更新UI的操作，是线程不安全的。
////        所以如果事件产生的线程是io线程，但是我们又要在doOnSubscribe() 更新UI ， 这时候就需要线程切换。
////        2、如果在 doOnSubscribe() 之后有 subscribeOn() 的话，它将执行在离它最近的 subscribeOn() 所指定的线程。
////        3、 subscribeOn() 事件产生的线程 ； observeOn() : 事件消费的线程
////        Observable.create(new Observable.OnSubscribe<Object>() {
////
////
////            @Override
////            public void call(Subscriber<? super Object> subscriber) {
////                System.out.println(String.format("observer run in thread %s ", Thread.currentThread().getName()));
////                for (int i = 0; i < 5; i++) {
////                    subscriber.onNext(i);
////                }
////                subscriber.onCompleted();
////            }
////        }).subscribeOn(12).//线程切换
////                doOnSubscribe(new Action0() {
////            @Override
////            public void call() {
////                System.out.println(String.format("doOnSubscribe run in thread %s ", Thread.currentThread().getName()));
////                System.out.println("doOnSubscribe--需要在主线程执行");
//////                progressBar.setVisibility(View.VISIBLE); // 需要在主线程执行
////            }
////        }).subscribeOn(AndroidSchedulers.mainThread())// 线程切换 指定主线程---progressBar 需要在UI 线程里更新
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe(new Action1<Object>() {
////                    @Override
////                    public void call(Object o) {
////                        System.out.println(String.format("subscribe run in thread %s ", Thread.currentThread().getName()));
////                        System.out.println("doOnSubscribe--" + o);
////                    }
////                });
//    }
//
//    String i = "10";
//
//    private void initdefer() {
//        i = "11 ";
//        //defer 操作符 defer是在订阅者订阅时才创建Observable，此时才进行真正的赋值操作。
//        //Defer操作符会一直等待直到有观察者订阅它，然后它使用Observable工厂方法生成一个Observable
//        Observable<String> defer = Observable.defer(new Func0<Observable<String>>() {
//            @Override
//            public Observable<String> call() {
//                return Observable.just(i);
//            }
//        });
//        Observable test = Observable.just(i);
//        i = "12";
//        //才生成Observable可以确保Observable包含最新的数据
//        defer.subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.v("rx_defer  ", "" + s);
//            }
//        });
//        test.subscribe(new Action1() {
//            @Override
//            public void call(Object o) {
//                Log.v("rx_just ", "" + o);
//            }
//        });
//    }
//
//    /**
//     * 所谓变换，就是将事件序列中的对象或整个序列进行加工处理，转换成不同的事件或事件序列
//     */
//    private void initmap() {
//        //，map() 方法将参数中的 String 对象转换成一个 Bitmap 对象后返回，而在经过 map() 方法后，事件的参数类型也由 String 转为了 Bitmap。这种直接变换对象并返回的，是最常见的也最容易理解的变换。
//        Subscription subscribe = Observable.just("images/logo.png").map(new Func1<String, Boolean>() {
//            @Override
//            public Boolean call(String filePath) {// 参数类型 String
////                return getBitmapFromPath(filePath); // 返回类型 Boolean
//                return filePath.endsWith("logo.png");
//            }
//        }).subscribe(new Action1<Boolean>() {
//            @Override
//            public void call(Boolean bitmap) {// 参数类型 Boolean
////                showBitmap(bitmap);显示图片
//                ToastUtils.showShort("map:" + bitmap);
//            }
//        });
//    }
//
//
//    private void initflatMap() {
//        /** ------注释说明---- flatMap() 也常用于嵌套的异步操作，例如嵌套的网络请求---- **/
//        List<Students> studentsList = new ArrayList<>(5);
//        List<String> course = new ArrayList<>(9);
//        for (int i = 0; i < 5; i++) {
//            Students students = new Students();
//            students.getName();
//            students.setName("张" + i);
//            students.setAge(i);
//            course.clear();
//            for (int j = 1; j <= 9; j++) {
//                course.add("课程" + j);
//            }
//            students.setCourse(course);
//            studentsList.add(students);
//        }
//
//        Observable.from(studentsList).flatMap(new Func1<Students, Observable<String>>() {
//            @Override
//            public Observable<String> call(Students students) {
//                return Observable.from(students.getCourse());
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String strings) {
//                System.out.println("flatMap--" + strings);
//            }
//        });
//
//    }
//
//    /**
//     * ------注释说明-----Scheduler调度器，相当于线程控制器---
//     **/
//    private void initScheduler() {
////        Schedulers.immediate() : 直接在当前线程运行，相当于不指定线程。这是默认的 Scheduler。
////
////        Schedulers.newThread() :总是启用新线程，并在新线程执行操作.
////
////        Schedulers.io():I/O 操作（读写文件、读写数据库、网络信息交互等）所使用的 Scheduler。行为模式和 newThread() 差不多，区别在于 io() 的内部实现是是用一个无数量上限的线程池，可以重用空闲的线程，因此多数情况下 io() 比 newThread() 更有效率。不要把计算工作放在 io() 中，可以避免创建不必要的线程。
////
////        Schedulers.computation() : 计算所使用的 Scheduler。这个计算指的是 CPU 密集型计算，即不会被 I/O 等操作限制性能的操作，例如图形的计算。这个 Scheduler 使用的固定的线程池，大小为 CPU 核数。不要把 I/O 操作放在 computation() 中，否则 I/O 操作的等待时间会浪费 CPU。
////
////        还有RxAndroid里面专门提供了AndroidSchedulers.mainThread()，它指定的操作将在 Android 主线程运行。
////
//////        Observable.just("1", "2", "3")
//////                .subscribeOn(Schedulers.io())  //指定 subscribe() 发生在 IO 线程
//////                .observeOn(AndroidSchedulers.mainThread())  //指定 Subscriber 的回调发生在主线程
//////                .subscribe(new Action1<String>() {
//////                    @Override
//////                    public void call(String s) {
////////                        textView.setText( s );
//////                    }
//////                });
//    }
//
//    private void initRange() {
////        Range操作符发射一个范围内的有序整数序列，你可以指定范围的起始和长度。
////        RxJava将这个操作符实现为range函数，它接受两个参数，一个是范围的起始值，一个是范围的数据的数目。如果你将第二个参数设为0，将导致Observable不发射任何数据（如果设置为负数，会抛异常）。
////        range默认不在任何特定的调度器上执行。有一个变体可以通过可选参数指定Scheduler。
//        Observable.range(10, 3).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                System.out.println(String.format("range run in thread %s ", Thread.currentThread().getName()));
//                System.out.println("range--" + integer);
//            }
//        });
//    }
//
//    private void initrepeat() {
//        //repeat/repeatWhen操作符
////        repeat操作符是对某一个Observable，重复产生多次结果，
////        repeatWhen操作符是对某一个Observable，有条件地重新订阅从而产生多次结果
//
//        //连续产生两组(3,4,5)的数字
//        Observable.range(3, 3).repeat(2).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                System.out.println("repeat--" + integer);
//            }
//        });
//
//        Observable.just(1, 2, 3).repeatWhen(new Func1<Observable<? extends Void>, Observable<?>>() {
//            @Override
//            public Observable<?> call(Observable<? extends Void> observable) {
//                //重复3次
//                return observable.zipWith(Observable.range(1, 3), new Func2<Void, Integer, Integer>() {
//                    @Override
//                    public Integer call(Void aVoid, Integer integer) {
//                        return integer;
//                    }
//                }).flatMap(new Func1<Integer, Observable<?>>() {
//                    @Override
//                    public Observable<?> call(Integer integer) {
//                        System.out.println("delay repeat the " + integer + " count");
//                        //1秒钟重复一次
//                        return Observable.timer(1, TimeUnit.SECONDS);
//                    }
//                });
//            }
//        }).subscribe(new Subscriber<Integer>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("Sequence complete.");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                System.err.println("Error: " + e.getMessage());
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                System.out.println("Next:" + value);
//            }
//        });
//    }
//
//    private void initgroupBy() {
//        List<String> list1 = new ArrayList<>(5);
//        //list1
//        list1.add("number_11");
//        list1.add("number_22");
//        list1.add("number_33");
//        list1.add("letters_aa");
//        list1.add("letters_bb");
//
////        Observable.from(list1).groupBy(new Func1<String, String>() {
////            @Override
////            public String call(String s) {
////                if (s.startsWith("number_"))
////                    return "number";
////                else if (s.startsWith("letters_"))
////                    return "letters";
////                else
////                    return "";
////            }
////        }).subscribe(new Action1<GroupedObservable<String, String>>() {
////            @Override
////            public void call(final GroupedObservable<String, String> stringStringGroupedObservable) {
////                stringStringGroupedObservable.subscribe(new Action1<String>() {
////                    @Override
////                    public void call(String s) {
////                        System.out.println("key:" + stringStringGroupedObservable.getKey() + ", value:" + s);
////                    }
////                });
////            }
////        });
//    }
//
//    private void initcast() {
//        //cast操作符主要是做类型转换的，传入参数为类型class，如果源Observable产生的结果不能转成指定的class，
//        // 则会抛出ClassCastException运行时异常。
//        Observable.just(11, 22, 33).
//                cast(Integer.class).
//                subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer integer) {
//                        System.out.println("key:" + integer);
//                    }
//                });
//    }
//
//    private void initwindow() {
//        //        window操作符非常类似于buffer操作符，区别在于buffer操作符产生的结果是一个List缓存，
//        // 而window操作符产生的结果是一个Observable，订阅者可以对这个结果Observable重新进行订阅处理。
//        Observable.interval(1, TimeUnit.SECONDS).take(12)
//                .window(3, TimeUnit.SECONDS)
//                .subscribe(new Action1<Observable<Long>>() {
//                    @Override
//                    public void call(Observable<Long> observable) {
//                        System.out.println("subdivide begin......");
//                        observable.subscribe(new Action1<Long>() {
//                            @Override
//                            public void call(Long aLong) {
//                                System.out.println("Next:" + aLong);
//                            }
//                        });
//                    }
//                });
//    }
//
//    private void initoftype() {
////        fType操作符类似于filter操作符，区别在于ofType操作符是按照类型对结果进行过滤
//        Observable.just(1, "hello world", true, 200L, 0.23f).ofType(Float.class).subscribe(new Action1<Float>() {
//            @Override
//            public void call(Float aFloat) {
//                System.out.println("ofType-- " + aFloat);
//            }
//        });
//    }
//
//    private void initSingle() {
////        single操作符是对源Observable的结果进行判断，
//// 如果产生的结果满足指定条件的数量有且只有1个；不为1，则抛出异常，
//// 否则把满足条件的结果提交给订阅者
//        Observable.just(1,2,3,4,5,6).single(new Func1<Integer, Boolean>() {
//            @Override
//            public Boolean call(Integer integer) {
//                return integer>5; // 输出值为6
////                return integer>3; // 报错 Sequence contains too many elements
////                return integer>6; // 报错 Sequence contains no elements
//            }
//        }).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                System.out.println(integer+"");
//            }
//        });
//        //single操作符 类似；可以指定默认值
//        Observable.just(1,2,3,4,5,6,7,8).singleOrDefault(666, new Func1<Integer, Boolean>() {
//            @Override
//            public Boolean call(Integer s) {
//                return s>4;       //rx.exceptions.OnErrorNotImplementedException: Sequence contains too many elements
////                return s>12;      // 666
////                return s>7;       // 8
//            }
//        }).subscribe(new Action1<Object>() {
//            @Override
//            public void call(Object o) {
//                Log.i("sss",o+"");
//            }
//        });
//    }
//
//    private void initStartWith() {
//        //插入普通数据
//        //startWith 数据序列的开头插入一条指定的项 , 最多插入9条数据
//        Observable observable = Observable.just("aa", "bb", "cc");
//        observable.startWith("1", "2", "3").subscribe(new Action1() {
//            @Override
//            public void call(Object o) {
//                System.out.println("startWith-- " + o);
//            }
//        });
//
//        List<String> list1 = new ArrayList<>(5);
//        //list1
//        list1.add("11");
//        list1.add("22");
//        list1.add("33");
//        observable.startWith(Observable.from(list1)).subscribe(new Action1() {
//            @Override
//            public void call(Object o) {
//                System.out.println("startWith-- " + o);
//            }
//        });
//    }
}
