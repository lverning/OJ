package com.lv.oj.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * 题目提交
 * @TableName question_submit
 */
@Data
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
    private String judgeCase;

    /**
     * 判题状态 (0-待判题,1-判题中,2-成功,3-失败)
     */
    private Integer status;

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 创建用户id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDelete;


}