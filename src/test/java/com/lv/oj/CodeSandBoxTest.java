package com.lv.oj;

import com.lv.oj.enums.QuestionSubmitLanguageEnum;
import com.lv.oj.judge.JudgeService;
import com.lv.oj.judge.codesandbox.CodeSandBox;
import com.lv.oj.judge.codesandbox.CodeSandBoxFactory;
import com.lv.oj.judge.codesandbox.CodeSandBoxProxy;
import com.lv.oj.judge.codesandbox.impl.ExampleCodeSandBoxImpl;
import com.lv.oj.judge.codesandbox.impl.RemoteCodeSandBoxImpl;
import com.lv.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lv.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.lv.oj.model.entity.QuestionSubmit;
import com.lv.oj.model.vo.QuestionSubmitVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CodeSandBoxTest {

    @Value("${codesandbox.type:example}")
    private String type;

    @Autowired
    private JudgeService judgeService;

    @Test
    void codeSandBox() {
        QuestionSubmit questionSubmitVO = judgeService.doJudge(1879907108871467010L);


    }
}
