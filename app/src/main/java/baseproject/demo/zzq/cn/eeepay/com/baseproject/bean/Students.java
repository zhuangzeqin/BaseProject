package baseproject.demo.zzq.cn.eeepay.com.baseproject.bean;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：学生类
 * 作者：zhuangzeqin
 * 时间: 2018/8/15-11:19
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class Students implements Serializable {
    private String name;//姓名
    private int age;// 18
    private List<String> course;//多个课程

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

}
