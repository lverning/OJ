package com.lv.oj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lv.oj.common.ErrorCode;
import com.lv.oj.exception.BusinessException;
import com.lv.oj.exception.ThrowUtils;
import com.lv.oj.mapper.QuestionMapper;
import com.lv.oj.model.dto.question.QuestionQueryRequest;
import com.lv.oj.model.entity.Question;

import com.lv.oj.model.entity.User;
import com.lv.oj.model.vo.QuestionVO;
import com.lv.oj.model.vo.UserVO;
import com.lv.oj.service.QuestionService;
import com.lv.oj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description 针对表【question(题目)】的数据库操作Service实现
 */
@Slf4j
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
        implements QuestionService {

    @Autowired
    private UserService userService;

    /**
     * 校验题目是否合法
     *
     * @param question
     * @param add
     */
    @Override
    public void validPost(Question question, boolean add) {
        if (question == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String title = question.getTitle();
        String content = question.getContent();
        String tags = question.getTags();
        String answer = question.getAnswer();
        // 创建时参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAllBlank(title, content, tags), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(title) && title.length() > 80) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "标题过长");
        }
        if (StringUtils.isNotBlank(content) && content.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容过长");
        }
        if (StringUtils.isNotBlank(answer) && answer.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "答案过长");
        }
    }

    @Override
    public QuestionVO getQuestionVO(Question question, HttpServletRequest request) {
        QuestionVO questionVO = QuestionVO.objToVo(question);
        Long userId = question.getUserId();
        User user = null;
        if (userId != null && userId > 0) {
            user = userService.getById(userId);
        }
        UserVO userVO = userService.getUserVO(user);
        questionVO.setUserVO(userVO);
        return questionVO;
    }

    @Override
    public QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest) {
        if (questionQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        Long id = questionQueryRequest.getId();
        String title = questionQueryRequest.getTitle();
        String content = questionQueryRequest.getContent();
        List<String> tags = questionQueryRequest.getTags();
        String answer = questionQueryRequest.getAnswer();
        Integer acceptedNum = questionQueryRequest.getAcceptedNum();
        Long userId = questionQueryRequest.getUserid();
        // 拼接查询条件
        queryWrapper.like(StringUtils.isAllBlank(title), "title", title);
        queryWrapper.like(StringUtils.isAllBlank(content), "content", title);
        queryWrapper.like(StringUtils.isAllBlank(answer), "answer", title);
        for (String tag : tags) {
            queryWrapper.like("tage", "\"" + tag + "\"");
        }
        queryWrapper.eq(ObjectUtils.isEmpty(id), "id", id);
        queryWrapper.eq(ObjectUtils.isEmpty(userId), "userId", userId);
        queryWrapper.eq("isDelete", false);
        return queryWrapper;
    }

    @Override
    public QueryWrapper<Question> getPageQuestion(QuestionQueryRequest questionQueryRequest) {
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(questionQueryRequest.getId())) {
            queryWrapper.like("id", questionQueryRequest.getId());
        }
        if (StringUtils.isNotBlank(questionQueryRequest.getContent())) {
            queryWrapper.like("content", questionQueryRequest.getContent());
        }
        if (StringUtils.isNotBlank(questionQueryRequest.getTitle())) {
            queryWrapper.like("title", questionQueryRequest.getTitle());
        }
        return queryWrapper;
    }

    /**
     * 数据脱敏
     * @param page
     * @param request
     * @return
     */
    @Override
    public Page<QuestionVO> getQuestionVOPage(Page<Question> page, HttpServletRequest request) {
        Page<QuestionVO> questionVOPage = new Page<QuestionVO>();
        // 填充信息
        List<QuestionVO> questionVOList = page.getRecords().stream().map(question -> {
            QuestionVO questionVO = QuestionVO.objToVo(question);
            User user = userService.getById(question.getUserId());
            questionVO.setUserTd(user.getId());
            userService.getUserVO(user);
            questionVO.setUserVO(userService.getUserVO(user));
            return questionVO;
        }).collect(Collectors.toList());
        questionVOPage.setRecords(questionVOList);
        return questionVOPage;
    }
}




