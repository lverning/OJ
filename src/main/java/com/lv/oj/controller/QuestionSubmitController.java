package com.lv.oj.controller;

import com.lv.oj.common.BaseResponse;
import com.lv.oj.common.ErrorCode;
import com.lv.oj.common.ResultUtils;
import com.lv.oj.exception.BusinessException;
import com.lv.oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.lv.oj.model.entity.QuestionSubmit;
import com.lv.oj.service.QuestionSubmitService;
import com.lv.oj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 题目提交
 */
@RestController
@RequestMapping("/questionSubmit")
public class QuestionSubmitController {

    @Autowired
    private QuestionSubmitService questionSubmitService;

    @Autowired
    private UserService userService;

    /**
     * 题目提交
     * @param questionSubmitAddRequest
     * @return
     */
    @PostMapping("/questionSubmit")
    public BaseResponse<Object> questionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest){
        if (questionSubmitAddRequest == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long id = questionSubmitService.questionSubmit(questionSubmitAddRequest);
        return ResultUtils.success(id);
    }

    @PostMapping("/questionSubmitList")
    public BaseResponse<List<QuestionSubmit>> questionSubmitList(HttpServletRequest request){
        userService.getLoginUser(request);
        List<QuestionSubmit> questionSubmitList = questionSubmitService.questionSubmitList();
        return ResultUtils.success(questionSubmitList);
    }
}
