package com.lv.oj.model.entity;

import java.util.Date;

/**
 * 用户
 * @TableName user
 */
public class User {
    /**
     * id
     */
    private Long id;

    /**
     * 账号
     */
    private String useraccount;

    /**
     * 密码
     */
    private String userpassword;

    /**
     * 微信开放平台id
     */
    private String unionid;

    /**
     * 公众号openId
     */
    private String mpopenid;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户头像
     */
    private String useravatar;

    /**
     * 用户简介
     */
    private String userprofile;

    /**
     * 用户角色：user/admin/ban
     */
    private String userrole;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 是否删除
     */
    private Integer isdelete;

    /**
     * id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 账号
     */
    public String getUseraccount() {
        return useraccount;
    }

    /**
     * 账号
     */
    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    /**
     * 密码
     */
    public String getUserpassword() {
        return userpassword;
    }

    /**
     * 密码
     */
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    /**
     * 微信开放平台id
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * 微信开放平台id
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * 公众号openId
     */
    public String getMpopenid() {
        return mpopenid;
    }

    /**
     * 公众号openId
     */
    public void setMpopenid(String mpopenid) {
        this.mpopenid = mpopenid;
    }

    /**
     * 用户昵称
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户昵称
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 用户头像
     */
    public String getUseravatar() {
        return useravatar;
    }

    /**
     * 用户头像
     */
    public void setUseravatar(String useravatar) {
        this.useravatar = useravatar;
    }

    /**
     * 用户简介
     */
    public String getUserprofile() {
        return userprofile;
    }

    /**
     * 用户简介
     */
    public void setUserprofile(String userprofile) {
        this.userprofile = userprofile;
    }

    /**
     * 用户角色：user/admin/ban
     */
    public String getUserrole() {
        return userrole;
    }

    /**
     * 用户角色：user/admin/ban
     */
    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    /**
     * 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 是否删除
     */
    public Integer getIsdelete() {
        return isdelete;
    }

    /**
     * 是否删除
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", useraccount=").append(useraccount);
        sb.append(", userpassword=").append(userpassword);
        sb.append(", unionid=").append(unionid);
        sb.append(", mpopenid=").append(mpopenid);
        sb.append(", username=").append(username);
        sb.append(", useravatar=").append(useravatar);
        sb.append(", userprofile=").append(userprofile);
        sb.append(", userrole=").append(userrole);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", isdelete=").append(isdelete);
        sb.append("]");
        return sb.toString();
    }

    public User() {
    }

    public User(Long id, String useraccount, String userpassword, String unionid, String mpopenid, String username, String useravatar, String userprofile, String userrole, Date createtime, Date updatetime, Integer isdelete) {
        this.id = id;
        this.useraccount = useraccount;
        this.userpassword = userpassword;
        this.unionid = unionid;
        this.mpopenid = mpopenid;
        this.username = username;
        this.useravatar = useravatar;
        this.userprofile = userprofile;
        this.userrole = userrole;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.isdelete = isdelete;
    }
}