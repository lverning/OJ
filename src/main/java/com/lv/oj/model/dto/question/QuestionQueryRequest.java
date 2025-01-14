package com.lv.oj.model.dto.question;

import com.lv.oj.common.PageRequest;
import lombok.Data;

import java.util.List;

@Data
public class QuestionQueryRequest extends PageRequest {

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
     * 题目通过数
     */
    private Integer acceptedNum;


    /**
     * 创建用户 id
     */
    private Long userid;

    private static final long serialVersionUID = 1L;


}
