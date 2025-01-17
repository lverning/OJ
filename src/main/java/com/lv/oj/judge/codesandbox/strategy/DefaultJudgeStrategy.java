package com.lv.oj.judge.codesandbox.strategy;

import cn.hutool.json.JSONUtil;
import com.lv.oj.enums.JudgeInfoMessageEnum;
import com.lv.oj.enums.QuestionSubmitStatusEnum;
import com.lv.oj.model.dto.question.JudgeCase;
import com.lv.oj.model.dto.question.JudgeConfig;
import com.lv.oj.model.dto.questionsubmit.JudgeInfo;
import com.lv.oj.model.entity.Question;
import com.lv.oj.model.entity.QuestionSubmit;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * 默认判题策略
 */
@Slf4j
public class DefaultJudgeStrategy implements JudgeStrategy {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        Long memory = judgeInfo.getMemory();
        Long time = judgeInfo.getTime();
        List<String> inputList = judgeContext.getInputList();
        List<String> outputList = judgeContext.getOutputList();
        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPTED;
        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setMemory(memory);
        judgeInfoResponse.setTime(time);
        // 先判断沙箱执行的结果输出数量是否和预期输出数量相等
        if (inputList.size() != outputList.size()) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            log.info("输入输出数量判断失败");
            return judgeInfoResponse;
        }
        // 依次判断每一项输出和预期输出是否相等
        for (int i = 0; i < judgeCaseList.size(); i++) {
            JudgeCase judgeCase = judgeCaseList.get(i);
            if (!judgeCase.getOutput().equals(outputList.get(i))){
                judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
                log.info("答案判断失败");
                return judgeInfoResponse;
            }
        }
        // 判断题目限制
        Question question = judgeContext.getQuestion();
        String judgeConfigStr = question.getJudgeConfig();
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
        if (memory > judgeConfig.getMemoryLimit()){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.MEMORY_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            log.info("内存判断超出");
            return judgeInfoResponse;
        }
        if (time > judgeConfig.getTimeLimit()){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            log.info("时间判断超出");
            return judgeInfoResponse;
        }
        judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
        log.info("代码判断成功");
        return judgeInfoResponse;
    }


}
