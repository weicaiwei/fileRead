package com.caiwei.entity;

import java.sql.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class StaffInfo {
    
    public StaffInfo() {};
    public String getStaffId() {
        return staffId;
    }
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public String getIdentityCard() {
        return identityCard;
    }
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }
    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Date getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
    @JSONField(ordinal=1)
    private String staffId;
    @JSONField(ordinal=2)
    private String staffName;
    @JSONField(ordinal=3)
    private String identityCard;
    @JSONField(ordinal=4)
    private Integer sex;
    @JSONField(ordinal=5,format="yyyy.MM.dd")
    private Date birthday;
    @JSONField(ordinal=6,format="yyyy.MM.dd")
    private Date entryTime;
}
