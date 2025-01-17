package com.lv.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lv.oj.common.ErrorCode;
import com.lv.oj.enums.QuestionSubmitLanguageEnum;
import com.lv.oj.enums.QuestionSubmitStatusEnum;
import com.lv.oj.exception.BusinessException;
import com.lv.oj.judge.JudgeService;
import com.lv.oj.mapper.QuestionSubmitMapper;
import com.lv.oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.lv.oj.model.entity.Question;
import com.lv.oj.model.entity.QuestionSubmit;
import com.lv.oj.service.QuestionService;
import com.lv.oj.service.QuestionSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author 吕
 * @description 针对表【question_submit(题目提交)】的数据库操作Service实现
 * @createDate 2025-01-11 21:43:55
 */
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
        implements QuestionSubmitService {

    @Autowired
    private QuestionService questionService;


    @Autowired
    @Lazy
    private JudgeService judgeService;

    @Override
    public long questionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest) {
        long questionId = questionSubmitAddRequest.getQuestionId();
        // 判断题目是否存在
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "题目不存在");
        }
        QuestionSubmit questionSubmit = new QuestionSubmit();
        // 判断编程语言是否合法
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(questionSubmitAddRequest.getLanguage());
        if (languageEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "编程语言不合法");
        }
        if (languageEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "编程语言不合法");
        }
        questionSubmit.setLanguage(questionSubmitAddRequest.getLanguage());
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setJudgeInfo(question.getJudgeCase());
        // 状态，默认为待判题
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setQuestionId(questionSubmitAddRequest.getQuestionId());
        questionSubmit.setUserId(question.getUserId());
        boolean save = this.save(questionSubmit);
        if (!save) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"数据插入失败");
        }
        long questionSubmitId = questionSubmit.getId();
        // 执行判题服务
        CompletableFuture.runAsync(()->{
           judgeService.doJudge(questionSubmitId);
        });
        return questionSubmitId;
    }
}




