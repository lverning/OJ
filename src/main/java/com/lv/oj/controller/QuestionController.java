package com.lv.oj.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.lv.oj.common.BaseResponse;
import com.lv.oj.common.DeleteRequest;
import com.lv.oj.common.ErrorCode;
import com.lv.oj.common.ResultUtils;
import com.lv.oj.constant.UserConstant;
import com.lv.oj.enums.UserRoleEnum;
import com.lv.oj.exception.BusinessException;
import com.lv.oj.exception.ThrowUtils;
import com.lv.oj.model.dto.question.JudgeCase;
import com.lv.oj.model.dto.question.JudgeConfig;
import com.lv.oj.model.dto.question.QuestionAddRequest;
import com.lv.oj.model.dto.question.QuestionQueryRequest;
import com.lv.oj.model.entity.Question;
import com.lv.oj.model.entity.User;
import com.lv.oj.model.vo.QuestionVO;
import com.lv.oj.service.QuestionService;
import com.lv.oj.service.QuestionSubmitService;
import com.lv.oj.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @Resource
    private UserService userService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    private final static Gson GSON = new Gson();

    /**
     * 创建题目
     *
     * @param questionAddRequest
     * @param request
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Long> addQuestion(@RequestBody QuestionAddRequest questionAddRequest, HttpServletRequest request) {
        if (questionAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionAddRequest, question);
        List<String> tags = questionAddRequest.getTags();
        if (tags != null) {
            question.setTags(GSON.toJson(tags));
        }
        List<JudgeCase> judgeCase = questionAddRequest.getJudgeCase();
        if (judgeCase != null) {
            question.setJudgeCase(GSON.toJson(judgeCase));
        }
        JudgeConfig judgeConfig = questionAddRequest.getJudgeConfig();
        if (judgeConfig != null) {
            question.setJudgeConfig(GSON.toJson(judgeConfig));
        }
        questionService.validPost(question, true);
        User loginUser = userService.getLoginUser(request);
        question.setUserId(loginUser.getId());
        question.setFavourNum(0);
        question.setThumbNum(0);
        boolean result = questionService.save(question);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newQuestionId = question.getId();
        return ResultUtils.success(newQuestionId);
    }

    /**
     * 删除
     *
     * @param deleteRequest
     * @param request
     * @return
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteQuestion(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.getLoginUser(request);
        long id = deleteRequest.getId();
        // 判断是否存在
        Question oldQuestion = questionService.getById(id);
        ThrowUtils.throwIf(oldQuestion == null, ErrorCode.NOT_FOUND_ERROR);
        // 仅本人或管理员可删除
        if (!oldQuestion.getUserId().equals(user.getId()) && !userService.isAdmin(request)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        boolean b = questionService.removeById(id);
        return ResultUtils.success(b);
    }

    /**
     * 分页查询
     *
     * @param questionQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/pageQuestionQuery")
    public BaseResponse<Page<QuestionVO>> pageQuestionQuery(@RequestBody QuestionQueryRequest questionQueryRequest, HttpServletRequest request) {
        if (questionQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long current = questionQueryRequest.getCurrent();
        long size = questionQueryRequest.getSize();
        QueryWrapper<Question> queryWrapper = questionService.getPageQuestion(questionQueryRequest);
        Page<Question> page = questionService.page(new Page<>(current, size), queryWrapper);
        // 脱敏
        Page<QuestionVO> questionVOPage = questionService.getQuestionVOPage(page, request);
        return ResultUtils.success(questionVOPage);
    }

    /**
     * 分页查询（管理员）
     *
     * @param questionQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/pageQuestionQueryAdmin")
    public BaseResponse<Page<Question>> pageQuestionQueryAdmin(@RequestBody QuestionQueryRequest questionQueryRequest, HttpServletRequest request){
        if (questionQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 判断是否为管理员
        User loginUser = userService.getLoginUser(request);
        if (!loginUser.getUserRole().equals(UserConstant.ADMIN_ROLE)){
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        long current = questionQueryRequest.getCurrent();
        long size = questionQueryRequest.getSize();
        QueryWrapper<Question> queryWrapper = questionService.getPageQuestion(questionQueryRequest);
        Page<Question> page = questionService.page(new Page<>(current, size), queryWrapper);
        return ResultUtils.success(page);
    }
}
