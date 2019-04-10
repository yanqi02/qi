package com.yq.yqim.model.bean;

public class InvationInfo {
    private UserInfo user;
    private GroupInfo group;
    private String reason;
    private InvationStatus status;//邀请的状态

    public InvationInfo() {
    }

    public InvationInfo(UserInfo user, GroupInfo group, String reason, InvationStatus status) {
        this.user = user;
        this.group = group;
        this.reason = reason;
        this.status = status;
    }

    @Override
    public String toString() {
        return "InvationInfo{" + "user=" + user + ", group=" + group + ", reason='" + reason + '\'' + ", status=" + status + '}';
    }

    public enum InvationStatus                         //枚举
    {
//联系人邀请信息状态
        NEW_INVITE,//新邀请
        INVITE_ACCEPT,//接受邀请
        INVITE_ACCEPT_BY_PEER,//邀请被接受
        NEW_GROUP_INVITE,
        NEW_GROUP_APPLICATION,
        GROUP_INVITE_ACCEPTED,
        GROUP_APPLICATION_ACCEPTED,
       GROUP_INVITE_DECLINED,
       GROUP_APPLICATION_DECLINED,
        GROUP_ACCEPT_INVITE,
        GROUP_ACCEPT_APPLICATION,
        GROUP_REJECT_APPLICATION,
        GROUP_REJECT_INVITE
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public GroupInfo getGroup() {
        return group;
    }

    public void setGroup(GroupInfo group) {
        this.group = group;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public InvationStatus getStatus() {
        return status;
    }

    public void setStatus(InvationStatus status) {
        this.status = status;
    }
}