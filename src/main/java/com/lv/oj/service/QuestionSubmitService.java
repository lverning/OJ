package com.lv.oj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.lv.oj.model.entity.QuestionSubmit;

import java.util.List;

/**
* @author 吕
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2025-01-11 21:43:55
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     * @param questionSubmitAddRequest
     * @return
     */
    long questionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest);

    List<QuestionSubmit> questionSubmitList();
}
