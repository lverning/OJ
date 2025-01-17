package com.lv.oj.judge;

import cn.hutool.json.JSONUtil;
import com.lv.oj.common.ErrorCode;
import com.lv.oj.enums.JudgeInfoMessageEnum;
import com.lv.oj.enums.QuestionSubmitStatusEnum;
import com.lv.oj.exception.BusinessException;
import com.lv.oj.judge.codesandbox.CodeSandBox;
import com.lv.oj.judge.codesandbox.CodeSandBoxFactory;
import com.lv.oj.judge.codesandbox.CodeSandBoxProxy;
import com.lv.oj.judge.codesandbox.JudgeManager;
import com.lv.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lv.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.lv.oj.judge.codesandbox.strategy.JudgeContext;
import com.lv.oj.model.dto.question.JudgeCase;
import com.lv.oj.model.dto.question.JudgeConfig;
import com.lv.oj.model.dto.questionsubmit.JudgeInfo;
import com.lv.oj.model.entity.Question;
import com.lv.oj.model.entity.QuestionSubmit;
import com.lv.oj.model.vo.QuestionSubmitVO;
import com.lv.oj.service.QuestionService;
import com.lv.oj.service.QuestionSubmitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JudgeServiceImpl implements JudgeService {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionSubmitService questionSubmitService;
    
    @Autowired
    private JudgeManager judgeManager;

    @Value("${codesandbox.type:example}")
    private String type;

    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {
        QuestionSubmit questionSubmit = questionSubmitService.getById(questionSubmitId);
        if (questionSubmit == null) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "提交不存在");
        }
        Long questionId = questionSubmit.getQuestionId();
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "题目不存在");
        }
        if (!questionSubmit.getStatus().equals(QuestionSubmitStatusEnum.WAITING.getValue())) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "题目正在判题中");
        }
        // 更改题目状态为判题中
        QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        boolean updateResult = questionSubmitService.updateById(questionSubmitUpdate);
        if (!updateResult) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "题目状态修改失败");
        }
        String language = questionSubmit.getLanguage();
        String code = questionSubmit.getCode();
        String judgeCaseStr = question.getJudgeCase();
        // 获取输入用例
        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
        List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());
        ExecuteCodeRequest executeCodeRequest = new ExecuteCodeRequest();
        executeCodeRequest.setInputList(inputList);
        executeCodeRequest.setCode(code);
        executeCodeRequest.setLanguage(language);
        // 调用代码沙箱执行代码，获取执行结果
        CodeSandBox codeSandBox = CodeSandBoxFactory.newInstance(type);
        codeSandBox = new CodeSandBoxProxy(codeSandBox);
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        List<String> outputList = executeCodeResponse.getOutputList();
        // 调用策略模式
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(outputList);
        judgeContext.setJudgeCaseList(judgeCaseList);
        judgeContext.setQuestion(question);
        judgeContext.setQuestionSubmit(questionSubmit);
        JudgeInfo judgeInfo = judgeManager.doJudge(judgeContext);
        // 修改数据库中的判题结果
        questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        boolean result = questionSubmitService.updateById(questionSubmitUpdate);
        if (!result){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"题目状态更新失败");
        }
        QuestionSubmit questionSubmitResult = questionSubmitService.getById(questionSubmitId);
        return questionSubmitResult;
    }
}
