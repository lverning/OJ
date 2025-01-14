package com.lv.oj.common;

import lombok.Data;

@Data
public class PageRequest {

    /**
     * 当前页号
     */
    private long current = 1;

    /**
     * 每页大小
     */
    private long size = 10;
}
