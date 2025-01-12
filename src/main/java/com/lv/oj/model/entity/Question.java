package com.lv.oj.model.entity;

import java.util.Date;
import java.util.List;

/**
 * 题目
 * @TableName question
 */
public class Question {
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
     * 标签列表（json数组）
     */
    private List<String> tags;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 题目提交数
     */
    private Integer submitnum;

    /**
     * 题目通过数
     */
    private Integer acceptednum;

    /**
     * 判题用例（json数组）
     */
    private String judgecase;

    /**
     * 判题配置（json对象）
     */
    private String judgeconfig;

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
     * 标签列表（json数组）
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * 标签列表（json数组）
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * 题目答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 题目答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 题目提交数
     */
    public Integer getSubmitnum() {
        return submitnum;
    }

    /**
     * 题目提交数
     */
    public void setSubmitnum(Integer submitnum) {
        this.submitnum = submitnum;
    }

    /**
     * 题目通过数
     */
    public Integer getAcceptednum() {
        return acceptednum;
    }

    /**
     * 题目通过数
     */
    public void setAcceptednum(Integer acceptednum) {
        this.acceptednum = acceptednum;
    }

    /**
     * 判题用例（json数组）
     */
    public String getJudgecase() {
        return judgecase;
    }

    /**
     * 判题用例（json数组）
     */
    public void setJudgecase(String judgecase) {
        this.judgecase = judgecase;
    }

    /**
     * 判题配置（json对象）
     */
    public String getJudgeconfig() {
        return judgeconfig;
    }

    /**
     * 判题配置（json对象）
     */
    public void setJudgeconfig(String judgeconfig) {
        this.judgeconfig = judgeconfig;
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
        Question other = (Question) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()))
            && (this.getSubmitnum() == null ? other.getSubmitnum() == null : this.getSubmitnum().equals(other.getSubmitnum()))
            && (this.getAcceptednum() == null ? other.getAcceptednum() == null : this.getAcceptednum().equals(other.getAcceptednum()))
            && (this.getJudgecase() == null ? other.getJudgecase() == null : this.getJudgecase().equals(other.getJudgecase()))
            && (this.getJudgeconfig() == null ? other.getJudgeconfig() == null : this.getJudgeconfig().equals(other.getJudgeconfig()))
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
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        result = prime * result + ((getSubmitnum() == null) ? 0 : getSubmitnum().hashCode());
        result = prime * result + ((getAcceptednum() == null) ? 0 : getAcceptednum().hashCode());
        result = prime * result + ((getJudgecase() == null) ? 0 : getJudgecase().hashCode());
        result = prime * result + ((getJudgeconfig() == null) ? 0 : getJudgeconfig().hashCode());
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
        sb.append(", answer=").append(answer);
        sb.append(", submitnum=").append(submitnum);
        sb.append(", acceptednum=").append(acceptednum);
        sb.append(", judgecase=").append(judgecase);
        sb.append(", judgeconfig=").append(judgeconfig);
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