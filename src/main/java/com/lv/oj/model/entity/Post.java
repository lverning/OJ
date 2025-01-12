package com.lv.oj.model.entity;

import java.util.Date;

/**
 * 帖子
 * @TableName post
 */
public class Post {
    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private String tags;

    /**
     * 点赞数
     */
    private Integer thumbnum;

    /**
     * 收藏数
     */
    private Integer favournum;

    /**
     * 创建用户 id
     */
    private Long userid;

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
     * 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 标签列表（json 数组）
     */
    public String getTags() {
        return tags;
    }

    /**
     * 标签列表（json 数组）
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 点赞数
     */
    public Integer getThumbnum() {
        return thumbnum;
    }

    /**
     * 点赞数
     */
    public void setThumbnum(Integer thumbnum) {
        this.thumbnum = thumbnum;
    }

    /**
     * 收藏数
     */
    public Integer getFavournum() {
        return favournum;
    }

    /**
     * 收藏数
     */
    public void setFavournum(Integer favournum) {
        this.favournum = favournum;
    }

    /**
     * 创建用户 id
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 创建用户 id
     */
    public void setUserid(Long userid) {
        this.userid = userid;
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
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Post other = (Post) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getThumbnum() == null ? other.getThumbnum() == null : this.getThumbnum().equals(other.getThumbnum()))
            && (this.getFavournum() == null ? other.getFavournum() == null : this.getFavournum().equals(other.getFavournum()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getIsdelete() == null ? other.getIsdelete() == null : this.getIsdelete().equals(other.getIsdelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getThumbnum() == null) ? 0 : getThumbnum().hashCode());
        result = prime * result + ((getFavournum() == null) ? 0 : getFavournum().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getIsdelete() == null) ? 0 : getIsdelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", tags=").append(tags);
        sb.append(", thumbnum=").append(thumbnum);
        sb.append(", favournum=").append(favournum);
        sb.append(", userid=").append(userid);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", isdelete=").append(isdelete);
        sb.append("]");
        return sb.toString();
    }
}