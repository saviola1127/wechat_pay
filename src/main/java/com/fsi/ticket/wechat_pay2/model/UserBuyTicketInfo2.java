package com.fsi.ticket.wechat_pay2.model;

import java.util.Date;

public class UserBuyTicketInfo2 {
    private Integer id;

    private String sportName;

    private String openid;

    private String sportTime;

    private String orderNo;

    private String userPrice;

    private String ticketNumber;

    private String oughtAmount;

    private String userName;

    private String mobilePhone;

    private String userEmail;

    private String orderStatus;

    private Date payTime;

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? "" : openid.trim();
    }

    public String getSportTime() {
        return sportTime;
    }

    public void setSportTime(String sportTime) {
        this.sportTime = sportTime == null ? null : sportTime.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getUserPrice() {
        return userPrice;
    }

    public void setUserPrice(String userPrice) {
        this.userPrice = userPrice == null ? null : userPrice.trim();
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber == null ? null : ticketNumber.trim();
    }

    public String getOughtAmount() {
        return oughtAmount;
    }

    public void setOughtAmount(String oughtAmount) {
        this.oughtAmount = oughtAmount == null ? null : oughtAmount.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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