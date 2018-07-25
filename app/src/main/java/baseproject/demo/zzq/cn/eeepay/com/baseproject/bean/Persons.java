package baseproject.demo.zzq.cn.eeepay.com.baseproject.bean;

import java.io.Serializable;

/**
 * 描述：class describe
 * 作者：zhuangzeqin
 * 时间: 2018/7/24-16:22
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class Persons implements Serializable{
    /**
     * careingpeople_id : 33
     * lovecode : null
     * appellation : 父亲
     * name : 王健林
     * birthday : 2015-04-08
     * mobile : 15689653698
     * areano : 320583
     * communityno : 1
     * communityname : 测试小区
     * agency_id : 1
     * street :
     * sex : null
     * canselfcare : 0
     * language : 本地话
     * disease : 糖尿病
     * memo : 哈哈
     * price : null
     * ctime : null
     */

    private String careingpeople_id;
    private String lovecode;
    private String appellation;
    private String name;
    private String birthday;
    private String mobile;
    private String areano;
    private String communityno;
    private String communityname;
    private String agency_id;
    private String street;
    private boolean sex;
    private String canselfcare;
    private String language;
    private String disease;
    private String memo;
    private double price;
    private long ctime;

    public String getCareingpeople_id() {
        return careingpeople_id;
    }

    public void setCareingpeople_id(String careingpeople_id) {
        this.careingpeople_id = careingpeople_id;
    }

    public String getLovecode() {
        return lovecode;
    }

    public void setLovecode(String lovecode) {
        this.lovecode = lovecode;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAreano() {
        return areano;
    }

    public void setAreano(String areano) {
        this.areano = areano;
    }

    public String getCommunityno() {
        return communityno;
    }

    public void setCommunityno(String communityno) {
        this.communityno = communityno;
    }

    public String getCommunityname() {
        return communityname;
    }

    public void setCommunityname(String communityname) {
        this.communityname = communityname;
    }

    public String getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(String agency_id) {
        this.agency_id = agency_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getCanselfcare() {
        return canselfcare;
    }

    public void setCanselfcare(String canselfcare) {
        this.canselfcare = canselfcare;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "careingpeople_id='" + careingpeople_id + '\'' +
                ", lovecode='" + lovecode + '\'' +
                ", appellation='" + appellation + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", mobile='" + mobile + '\'' +
                ", areano='" + areano + '\'' +
                ", communityno='" + communityno + '\'' +
                ", communityname='" + communityname + '\'' +
                ", agency_id='" + agency_id + '\'' +
                ", street='" + street + '\'' +
                ", sex=" + sex +
                ", canselfcare='" + canselfcare + '\'' +
                ", language='" + language + '\'' +
                ", disease='" + disease + '\'' +
                ", memo='" + memo + '\'' +
                ", price=" + price +
                ", ctime=" + ctime +
                '}';
    }
}
