package com.lv.oj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.oj.model.dto.question.QuestionQueryRequest;
import com.lv.oj.model.entity.Question;
import com.lv.oj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 吕
 * @description 针对表【question(题目)】的数据库操作Service
 * @createDate 2025-01-11 21:15:09
 */
public interface QuestionService extends IService<Question> {

    /**
     * 校验
     *
     * @param question
     * @param add
     */
    void validPost(Question question, boolean add);

    /**
     * @param question
     * @return
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);

    /**
     * 分页查询构造器
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getPageQuestion(QuestionQueryRequest questionQueryRequest);


    /**
     * 数据脱敏
     * @param page
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> page, HttpServletRequest request);
}
