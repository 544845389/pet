package com.pet.pet.entity;

import com.codingapi.mybaties.entity.BaseEntity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 侯存路
 * @date 2018/7/27
 * @company codingApi
 * @description
 */
@Table(name = "yqxx")
public class UserData extends BaseEntity {

    private  int id;

    private  String openid;

    private String  xm;

    private String  xb;

    private String  lxdh;

    private String  zjlx;

    private String  zjhm;

    private String  yqrzz;

    private String  sspcs;

    private String  qm;

    private String  qz;

    private String  ms;

    private String  ql;

    private String  qzxb;

    private String  jg;

    private String  tc;

    private String  bz;

    private String  myrq;

    private String  mydmc;

    private String  myzh;

    private String  qzly;

    private String  shyj;

    /**
     * 状态  0:未审核  1：审核成功 2：审核失败
     */
    private int  state;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public String getYqrzz() {
        return yqrzz;
    }

    public void setYqrzz(String yqrzz) {
        this.yqrzz = yqrzz;
    }

    public String getSspcs() {
        return sspcs;
    }

    public void setSspcs(String sspcs) {
        this.sspcs = sspcs;
    }

    public String getQm() {
        return qm;
    }

    public void setQm(String qm) {
        this.qm = qm;
    }

    public String getQz() {
        return qz;
    }

    public void setQz(String qz) {
        this.qz = qz;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getQl() {
        return ql;
    }

    public void setQl(String ql) {
        this.ql = ql;
    }

    public String getQzxb() {
        return qzxb;
    }

    public void setQzxb(String qzxb) {
        this.qzxb = qzxb;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getMyrq() {
        return myrq;
    }

    public void setMyrq(String myrq) {
        this.myrq = myrq;
    }

    public String getMydmc() {
        return mydmc;
    }

    public void setMydmc(String mydmc) {
        this.mydmc = mydmc;
    }

    public String getMyzh() {
        return myzh;
    }

    public void setMyzh(String myzh) {
        this.myzh = myzh;
    }

    public String getQzly() {
        return qzly;
    }

    public void setQzly(String qzly) {
        this.qzly = qzly;
    }

    public String getShyj() {
        return shyj;
    }

    public void setShyj(String shyj) {
        this.shyj = shyj;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
