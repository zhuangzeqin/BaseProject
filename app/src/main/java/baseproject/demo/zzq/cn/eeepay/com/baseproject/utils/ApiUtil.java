package baseproject.demo.zzq.cn.eeepay.com.baseproject.utils;


/**
 * @author :xqf
 * @date :2017/11/3 17:54
 * @desc :
 * @update :
 */
public class ApiUtil {
    //rsa 公钥
    public static final String PUB_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD1mecWBLMB1snW3J089PGK/yICyWRzXnheUuIHD756S9g9XT0QqeR2l8k8L946VnTWLm3QmtpkS32c2ejfarvVnzkuJrYZyGZivN2hswz+PRxwresR8n/8NQOJ9hu9XVURL24owRKICQg5pD3lqRVL0MFxW+BJB/BZn+uSUFQMIwIDAQAB";
    //服务器IP
    public static String API_HOST_URL ="http://redeem.pay-world.cn/";//生成域名
//    public static String API_HOST_URL = "http://192.168.4.24:8080/";//zja
//    public static String API_HOST_URL = "http://test-devcjd.pay-world.cn/";//zja--外网映射
//    public static String API_HOST_URL2 = "http://192.168.4.24:8080/";//
//    public static String API_HOST_URL3 = "http://192.168.4.24:8080/";//

//    public static  String API_HOST_URL = "http://hmh.qhylpay.com/";//zja
//    public static String API_HOST_URL = "http://redeem.pay-world.cn/";//生产环境
//    public static String API_HOST_URL = "http://test-redeem.pay-world.cn/";//准生产
//    public static String API_HOST_URL = "http://192.168.1.182:8107/";//测试


//    public static  String API_HOST_URL2 = "http://hmh.qhylpay.com/";//lsw
//    public static String API_HOST_URL4 = "http://hmh.qhylpay.com/";//hmh

    public static String API_HOST_NAMESPACE = "%spersonalCenter/receive/%s";//zja的统一写


    /**
     * 公共参数
     *
     * @return
     */
//    public static Map<String, String> getParams() {
//        Map<String, String> params = new HashMap<>();
//        params.put("osVersion", ABAppUtil.getSystemVersion());
//        params.put("appName", MyApplication.getInstance().getApplicationContext().getString(R.string.app_name));
//        params.put("platform", "android");
//        params.put("clientVersion", ABAppUtil.getAppVersion(MyApplication.getInstance().getApplicationContext()));//app版本号
//        params.put("oem_no", MyApplication.getInstance().getApplicationContext().getString(R.string.oem_no));
//        params.put("nonceStr", Utils.getUUID());//长度为32位的UUID,必传
//        if(TextUtils.isEmpty(ABPreferenceUtils.getStringParam(BaseCons.JPUSH_REGID, ""))){
//            String registerID = JPushInterface.getRegistrationID(MyApplication.getInstance().getApplicationContext());
//            Logger.d("极光生成的id:"+registerID);
//            params.put("device_id", registerID);//极光获取到的设备id
//        }else{
//            params.put("device_id", ABPreferenceUtils.getStringParam(BaseCons.JPUSH_REGID, ""));//极光获取到的设备id
//        }
//
//        return params;
//    }

//    public static String getAPI_HOST_ZJA_URL() {
//        return String.format(API_HOST_NAMESPACE, OkHttpClientManager.getInstance().changeUrl(API_HOST_URL), Utils.getUUID());
//    }


    //-----start-----------xqf------------

    //修改手機號
    public static String UPDATE_PHONE_NAME = "modifyMobilPhone";
    public static String UPDATE_PHONE_TAG = "001";

    //获取图像验证码
   // public static String GETIMAGECHECKCODE_URL = OkHttpClientManager.getInstance().changeUrl(API_HOST_URL) + "checkCode/getImageCheckCode?imageCodekey=";
    public static String GETIMAGECHECKCODE_TAG = "002";

    //获取短信验证码
    public static String GETSMSCHECKCODE_URL = API_HOST_URL + "checkCode/getSMSCheckCode";
    public static String GETSMSCHECKCODE_TAG = "003";

    // 检查商户是否注册
    public static String CHECKREGISTER_URL = API_HOST_URL + "user/checkRegister";
    public static String CHECKREGISTER_TAG = "004";

    //注册商户
    public static String REGISTER_URL = API_HOST_URL + "user/register";
    public static String REGISTER_TAG = "005";

    //提现
    public static String WITHDRAWCASH_URL = API_HOST_URL + "withdrawCash/withdrawCash";
    public static String WITHDRAWCASH_TAG = "006";

    //登录
    public static String MERLOGIN_NAME = "merLogin";
    public static String MERLOGIN_TAG = "007";

    //我的信息
    public static String MYINFO_NAME = "myInfo";
    public static String MYINFO_TAG = "008";

    //提现校验
    public static String JUMPTOWITHDRAWCASHAPP_URL = API_HOST_URL + "withdrawCash/jumpToWithdrawCashApp";
    public static String JUMPTOWITHDRAWCASHAPP_TAG = "009";

    //收入明细
    public static String GETSHAREORDERLIST_URL = API_HOST_URL + "order/getShareOrderList/%s/%s";
    public static String GETSHAREORDERLIST_TAG = "010";

    //提现明细
    public static String GETWITHDRAWCASHORDERLIST_URL = API_HOST_URL + "order/getWithdrawCashOrderList/%s/%s";
    public static String GETWITHDRAWCASHORDERLIST_TAG = "011";

    //提现结果查询
    public static String JUMPTOWITHDRAWCASHRESULTAPP_URL = API_HOST_URL + "withdrawCash/jumpToWithdrawCashResultApp";
    public static String JUMPTOWITHDRAWCASHRESULTAPP_TAG = "011";

    //商户注册(app) 注册接口会返回商户信息，登录也会，注意下发的商户信息有变动，则要注意改这两个接口
    public static String REGISTERAPP_URL = API_HOST_URL + "user/registerApp";
    public static String REGISTERAPP_TAG = "012";

    //绑定微信
    public static String BINDWXAPP_URL = API_HOST_URL + "user/bindWxApp";
    public static String BINDWXAPP_TAG = "013";

    //绑定手机号
    public static String BINDMOBILEAPP_URL = API_HOST_URL + "user/bindMobileApp";
    public static String BINDMOBILEAPP_TAG = "014";

    //海报链接地址
   // public static String HAIBAO_URL = OkHttpClientManager.getInstance().changeUrl(API_HOST_URL) + "personalCenter/receive/%s?merchant_no=%s&apiTag=%s&apiType=%s&viewName=%s&platform=%s&merchant_no_sign=%s&oem_no=%s";
    //    http://hmh.qhylpay.com/personalCenter/receive/955bd5c4ecb3ab82fb9df51962c6ba2a?merchant_no=57302&apiTag=myInfo&apiType=h5&viewName=weixin/exclusive_posters&nonceStr=14fdf24d666c820a2bea36f81ed0b38d&merchant_no_sign=afadbf3301fdb0e682abf21d5eb88456&platform=APP
    //微信登录
    public static String WECHATLOGIN_NAME = "wechatLogin";
    public static String WECHATLOGIN_TAG = "015";

    //忘记密码
    public static String FORGOTPASSWORDAPP_URL = API_HOST_URL + "user/forgotPasswordApp";
    public static String FORGOTPASSWORDAPP_TAG = "016";


    //校验卡并返回开户行;reqCardType (传“1”代表信用卡，"2"代表储蓄卡)
    public static String CHECKCARD_URL = API_HOST_URL + "merchant/checkCard";
    public static String CHECKCARD_TAG = "007";

    //根据卡和城市获取支行
    public static String GETBANKANDCNAP_URL = API_HOST_URL + "merchant/getBankAndCnap";
    public static String GETBANKANDCNAP_TAG = "008";


    //linkface
    public static String LINKFACE_URL = "https://cloudapi.linkface.cn/ocr/parse_bankcard_ocr_result";
    public static String LINKFACE_TAG = "000";


    //版本更新
    public static String PUBLIC_URL = API_HOST_URL + "version/getVersionInfo";
    public static String PUBLIC_TAG = "017";

    //注册协议
    public static String XIEYI_URL = API_HOST_URL + "agreement/agreement_%s.html";

    //用户礼品转让协议
    public static String YHLPZR_XIEYI_URL = API_HOST_URL + "agreement/platform_protocol_%s.html";


    //-----end-----------xqf------------

    //-----start-----------LiangAn------------//
    /**  **/
    public static final int _TAG = 10;

    //平安广告RUL
    public static String PINGAN_GUANG_GAO_URL = "http://icorepams.pingan.com.cn/mobile_single_insurance/queryProductDetails.do?account=xinghuazhifu&productCode=A8020150326000002003";
    //众安保险广告RUL
    public static String ZHONGANBAOXIAN_GUANG_GAO_URL = "https://ztg.zhongan.com/promote/entrance/promoteEntrance.do?redirectType=h5&promotionCode=INST171154292020&productCode=PRD160341670013&promoteCategory=single_product&token=";


    /**
     * 获取支行
     **/
    public static final int GETCNAPS_TAG = 101;
    public static String GETCNAPS_NAME = "getCnaps";

    /**
     * 绑定或者修改结算卡 同一个接口
     **/
    public static final int MODIFYCARD_TAG = 102;
    public static String MODIFYCARD_NAME = "modifyCard";

    /**
     * 根据银行卡号获取银行名称
     **/
    public static final int GETBANKNAME_TAG = 103;
    public static String GETBANKNAME_NAME = "getBankName";

    /**
     * 同时获取粉丝跟普通商户
     **/
    public static final int GETFANSANDORDINARY_TAG = 104;
    public static String GETFANSANDORDINARY_NAME = "getFansAndOrdinary";

    /**
     * 取消订单
     **/
    public static final int CANCELORDER_TAG = 105;
    public static String CANCELORDER_NAME = "cancelOrder";

    /**
     * 系统公告查询
     **/
    public static final int NOTICE_TAG = 106;
    public static String NOTICE_NAME = "";

    /**
     * 查询粉丝商户
     **/
    public static final int QUERYFAN_TAG = 107;
    public static String QUERYFAN_NAME = "queryFan";

    /**
     * 查询普通商户
     **/
    public static final int QUERYORDINARYMER_TAG = 108;
    public static String QUERYORDINARYMER_NAME = "queryOrdinaryMer";

    /**
     * 查询代理订单
     **/
    public static final int QUERYACTIVITYORDER_TAG = 109;
    public static String QUERYACTIVITYORDER_NAME = "queryActivityOrder";

    /**
     * 查询报单订单
     **/
    public static final int UERYDECLAREORDER_TAG = 110;
    public static String UERYDECLAREORDER_NAME = "queryDeclareOrder";

    /**
     * 修改密码
     **/
    public static final int MODIFYPASSWORDAPP_TAG = 111;
    public static String MODIFYPASSWORDAPP_URL = API_HOST_URL + "user/modifyPasswordApp";

    /**
     * 更新商户二维码
     **/
    public static final int MODIFYWECAHTQRCODE_TAG = 112;
    public static String MODIFYWECAHTQRCODE_NAME = "modifyWeChatQrCode";

    /**
     * 代理详情，申请人信息查询
     **/
    public static final int GETACTIVITYORDERDETAIL_TAG = 113;
    public static String GETACTIVITYORDERDETAIL_NAME = "getActivityOrderDetail";

    //-----end-----------LiangAn------------//


    //--start---------zw-----201-300


    /**
     * 修改结算卡
     **/
    public static String CHANGE_SETTLEMTNT_CARD_URL = API_HOST_URL + "core2/card/updateRepaySettlementAccount";
    public static final String CHANGE_SETTLEMTNT_CARD_TAG = "223";


    //-----end-----------zw------------//


    //------------zhuangzeqin ----------------301-400

    /**
     * 收款记录查询
     **/
    public final static String SELECTCOLLECTIONRECORD = API_HOST_URL + "gather/selectCollectionRecordV22";
    public final static String GET_SELECTCOLLECTIONRECORD_TAG = "306";

    /**
     * 获取所有机构查询
     **/
    public final static String GETORGLIST_APITAG = "getOrgList";
    public final static String GET_BANKI_INSTITUTION_INFO_TAG = "307";

    /**
     * 获取机构下当前级别商户的价格
     **/
    public final static String GETLEVELPRICES_APITAG = "getLevelPrices";
    public final static String GETLEVELPRICES_INFO_TAG = "308";

    /**
     * 获取机构下当前级别商户的价格
     **/
    public static String ACTIVECORDURL = API_HOST_URL + "active/actInfo";//hmh的
    public final static String GEACTIVECORD_INFO_TAG = "309";
    /**
     * 支付接口
     **/
   // public static String PAYCORDURL = OkHttpClientManager.getInstance().changeUrl(API_HOST_URL) + "active/payhtml";//hmh的 支付页面接口

    /**
     * 会员规则
     **/
   // public static String MENBERRULE =  OkHttpClientManager.getInstance().changeUrl(API_HOST_URL) + "personalCenter/receive/";
    /**
     * 分享
     */
   // public static String SHAREAUTH =  OkHttpClientManager.getInstance().changeUrl(API_HOST_URL) + "active/shareAuth";

    /**
     * 支付页面回来点击确定接口
     **/
    public static String PAYQUERY = API_HOST_URL + "active/payQuery";//hmh的 支付页面回来点击确定接口
    public final static String PAYQUERY_INFO_TAG = "311";

    /**
     * hmh的 支付页面回来点击确定接口  重新支付的新接口
     **/
    //public static String REPAYHTML = OkHttpClientManager.getInstance().changeUrl(API_HOST_URL) + "active/repayhtml?orderNo=%s";//

    /**
     * 跳转到报单页面接口
     **/
    public static String JUMPTOCUSTOMSDECLARATIONAPP = API_HOST_URL + "product/jumpToCustomsDeclarationApp";
    public final static String JUMPTOCUSTOMSDECLARATIONAPP_TAG = "312";

    /**
     * 跳转到报单编辑信息页面(app)接口
     **/
    public static String JUMPTOORDERINFORMATIONAPP = API_HOST_URL + "product/jumpToOrderInformationApp";
    public final static String JUMPTOORDERINFORMATIONAPP_TAG = "313";

    /**
     * 提交报单接口
     **/
    public static String DECLARATIONPRODUCT = API_HOST_URL + "product/declarationProduct";
    public final static String DECLARATIONPRODUCT_TAG = "314";
    /**
     * 扫描二维码； 替换引路人
     **/
    public static String CLIENTMERCHANGE = API_HOST_URL + "active/clientMerChange";//hmh的 支付页面回来点击确定接口
    public static final String CLIENTMERCHANGE_TAG = "315";
    /**
     * 兑换入口
     */
    public static String GETPRODUCTTYPEINFO  = API_HOST_URL+"product/getProductTypeInfo";
    public static final String GETPRODUCTTYPEINFO_TAG = "316";
    /**
     * banner 下发的接口
     */
    public static String GETBANNERINFO = "getBanner";
    public static final String GETBANNERINFO_TAG = "317";

}
