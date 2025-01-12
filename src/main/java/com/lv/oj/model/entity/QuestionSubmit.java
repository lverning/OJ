package com.lv.oj.model.entity;

import java.util.Date;

/**
 * 题目提交
 * @TableName question_submit
 */
public class QuestionSubmit {
    /**
     * id
     */
    private Long id;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;

    /**
     * 判题信息（json对象）
     */
    private String judgecase;

    /**
     * 判题状态 (0-待判题,1-判题中,2-成功,3-失败)
     */
    private Integer status;

    /**
     * 题目id
     */
    private Long questionid;

    /**
     * 创建用户id
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
     * 编程语言
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 编程语言
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 用户代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 用户代码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 判题信息（json对象）
     */
    public String getJudgecase() {
        return judgecase;
    }

    /**
     * 判题信息（json对象）
     */
    public void setJudgecase(String judgecase) {
        this.judgecase = judgecase;
    }

    /**
     * 判题状态 (0-待判题,1-判题中,2-成功,3-失败)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 判题状态 (0-待判题,1-判题中,2-成功,3-失败)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 题目id
     */
    public Long getQuestionid() {
        return questionid;
    }

    /**
     * 题目id
     */
    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    /**
     * 创建用户id
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 创建用户id
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
        QuestionSubmit other = (QuestionSubmit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLanguage() == null ? other.getLanguage() == null : this.getLanguage().equals(other.getLanguage()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getJudgecase() == null ? other.getJudgecase() == null : this.getJudgecase().equals(other.getJudgecase()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getQuestionid() == null ? other.getQuestionid() == null : this.getQuestionid().equals(other.getQuestionid()))
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
        result = prime * result + ((getLanguage() == null) ? 0 : getLanguage().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getJudgecase() == null) ? 0 : getJudgecase().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getQuestionid() == null) ? 0 : getQuestionid().hashCode());
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
        sb.append(", language=").append(language);
        sb.append(", code=").append(code);
        sb.append(", judgecase=").append(judgecase);
        sb.append(", status=").append(status);
        sb.append(", questionid=").append(questionid);
        sb.append(", userid=").append(userid);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", isdelete=").append(isdelete);
        sb.append("]");
        return sb.toString();
    }
}