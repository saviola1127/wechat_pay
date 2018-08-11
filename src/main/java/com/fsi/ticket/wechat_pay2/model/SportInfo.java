package com.fsi.ticket.wechat_pay2.model;

import java.util.Date;

public class SportInfo {
    private Integer id;

    private String sportName;

    private Date sportTime;

    private String status;


    private String sportType;


    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName == null ? null : sportName.trim();
    }

    public Date getSportTime() {
        return sportTime;
    }

    public void setSportTime(Date sportTime) {
        this.sportTime = sportTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }


    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType == null ? null : sportType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}