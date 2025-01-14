package com.lv.oj.model.dto.post;

import lombok.Data;

import java.util.List;


@Data
public class PostAddRequest {

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

    private List<String> tags;


}
