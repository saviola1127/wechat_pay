package com.fsi.ticket.wechat_pay2.model;

import java.util.Date;

public class UserBuyTicketInfo {
    private Integer id;

    private String userName;

    private String mobileNumber;

    private Integer sportId;

    private Integer priceId;

    private Integer deliveryAddress;

    private Integer expressName;

    private Integer expressNo;

    private Date payStatus;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber == null ? null : mobileNumber.trim();
    }

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Integer getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Integer deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getExpressName() {
        return expressName;
    }

    public void setExpressName(Integer expressName) {
        this.expressName = expressName;
    }

    public Integer getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(Integer expressNo) {
        this.expressNo = expressNo;
    }

    public Date getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Date payStatus) {
        this.payStatus = payStatus;
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