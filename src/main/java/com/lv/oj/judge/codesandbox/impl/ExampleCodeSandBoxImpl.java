package com.lv.oj.judge.codesandbox.impl;

import com.lv.oj.enums.JudgeInfoMessageEnum;
import com.lv.oj.enums.QuestionSubmitStatusEnum;
import com.lv.oj.judge.codesandbox.CodeSandBox;
import com.lv.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lv.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.lv.oj.model.dto.questionsubmit.JudgeInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 示例代码沙箱
 */
@Slf4j
public class ExampleCodeSandBoxImpl implements CodeSandBox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> outputList = new ArrayList<>();
        outputList.add("777");
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(outputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(JudgeInfoMessageEnum.ACCEPTED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(500L);
        judgeInfo.setTime(500L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        log.info("ExampleCodeSandBoxImpl执行");
        return executeCodeResponse;
    }
}
