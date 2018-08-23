package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.act; /**
 *
 */


import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ApiUtil;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.PreferenceUtils;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.view.dialog.CustomDialog;


/**
 * 描述：切换地址测试页面
 * 作者：zhuangzeqin
 * 时间: 2018/7/24-11:30
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class TestUpdateIPAct extends Activity implements RadioGroup.OnCheckedChangeListener {

    public static final String TEST_KEY = "change_key";
    public static final String CORE_URL = "core_url";

    TextView msg;

    TextView url_180;
    TextView url_zsc;
    TextView url_shengchan;

    RadioGroup radiogroup;
    RadioButton rb_180;
    RadioButton rb_zsc;
    RadioButton rb_shengchan;

    String str_url_180;
    String str_url_zsc;
    String str_url_shengchan;

    EditText customAddressEt;

    private CustomDialog exitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_update_ip);
        msg = (TextView) findViewById(R.id.msg);

        url_180 = (TextView) findViewById(R.id.url_180);
        url_zsc = (TextView) findViewById(R.id.url_zsc);
        url_shengchan = (TextView) findViewById(R.id.url_shengchan);

        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        rb_180 = (RadioButton) findViewById(R.id.rb_138);
        rb_zsc = (RadioButton) findViewById(R.id.rb_zsc);
        rb_shengchan = (RadioButton) findViewById(R.id.rb_shengchan);
        radiogroup.setOnCheckedChangeListener(this);

        str_url_180 = url_180.getText().toString();
        str_url_zsc = url_zsc.getText().toString();
        str_url_shengchan = url_shengchan.getText().toString();

        customAddressEt = (EditText) findViewById(R.id.et_custom_address);

        int index = PreferenceUtils.getIntParam(TEST_KEY, -1);

        switch (index) {
            case 0://线上环境（生产环境）
                setMsg(str_url_shengchan);
                rb_shengchan.setChecked(true);
                break;
            case 1://准生产环境
                setMsg(str_url_180);
                rb_zsc.setChecked(true);
                break;
            case 2://180环境
                setMsg(str_url_180);
                rb_180.setChecked(true);
                break;
            case 3:
                setMsg(PreferenceUtils.getStringParam(CORE_URL));
                break;
            default:
                setMsg(ApiUtil.API_HOST_URL);
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_shengchan://线上环境（生产环境）
                setMsg(str_url_shengchan);
                PreferenceUtils.saveParam(TEST_KEY, 0);
                PreferenceUtils.saveParam(CORE_URL, str_url_shengchan);
                break;
            case R.id.rb_zsc://准
                setMsg(str_url_zsc);
                PreferenceUtils.saveParam(TEST_KEY, 1);
                PreferenceUtils.saveParam(CORE_URL, str_url_zsc);
                break;
            case R.id.rb_138://180环境
                setMsg(str_url_180);
                PreferenceUtils.saveParam(TEST_KEY, 2);
                PreferenceUtils.saveParam(CORE_URL, str_url_180);
                break;
        }

    }

    /**
     * 自定义地址
     *
     * @param view
     */
    public void customAddressConfirm(View view) {
        String address = customAddressEt.getText().toString().trim();
        if (!TextUtils.isEmpty(address)) {
            setMsg(address);
            PreferenceUtils.saveParam(TEST_KEY, 3);
            PreferenceUtils.saveParam(CORE_URL, address);
        }
        showExitDialog();
    }

    public void setMsg(String url) {
        msg.setText("appNo=" + getString(R.string.app_name) + "\n------当前ip地址信息------\n"
                + "url=" + url);
    }


    /**
     * 退出对话框提示
     */
    private void showExitDialog() {
        if (exitDialog == null) {

            exitDialog = new CustomDialog(this);
            exitDialog.setTitles(getString(R.string.dialog_title)).setMsgGravity(Gravity.CENTER);
            exitDialog.setMessage("您确定要退出吗？");
            exitDialog.setNegativeButton(getString(R.string.cancel), new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.exit(0);
                }
            }).setPositiveButton(getString(R.string.ok), new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.exit(0);
                }
            }).show();

        }
        if (!exitDialog.isShowing()) {
            exitDialog.show();
        }
    }

}
