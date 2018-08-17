package baseproject.demo.zzq.cn.eeepay.com.baseproject.bean;

import java.io.Serializable;

/**
 *@author  :xqf
 *@date    :2017/11/6 11:23
 *@desc    :狀態和错误信息
 *@update  :
 */
public class CommonBean implements Serializable {

//    {
//        status:
//        data:{
//        }
//    }
    /**
     * result : SUCCESS
     * msg : null
     */

    private String status;//200成功；错误403 404

    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
