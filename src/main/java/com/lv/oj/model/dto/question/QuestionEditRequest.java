package com.lv.oj.model.dto.question;

import lombok.Data;

import java.util.List;

@Data
public class QuestionEditRequest {

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
     * 判题用例（json数组）
     */
    private String judgeCase;

    /**
     * 判题配置（json对象）
     */
    private String judgeConfig;


    private static final long serialVersionUID = 1L;


}