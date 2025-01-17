package com.lv.oj.judge.codesandbox.impl;

import com.lv.oj.enums.QuestionSubmitStatusEnum;
import com.lv.oj.judge.codesandbox.CodeSandBox;
import com.lv.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lv.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.lv.oj.model.dto.questionsubmit.JudgeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 远程代码沙箱
 */
public class RemoteCodeSandBoxImpl implements CodeSandBox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        List<String> outputList = new ArrayList<>();
        outputList.add("1 2");
        executeCodeResponse.setOutputList(outputList);
        executeCodeResponse.setMessage("成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue().toString());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage("成功");
        judgeInfo.setMemory(1000L);
        judgeInfo.setTime(1000L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
