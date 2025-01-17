package com.lv.oj.judge;

import com.lv.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.lv.oj.model.entity.QuestionSubmit;
import com.lv.oj.model.vo.QuestionSubmitVO;

public interface JudgeService {

    QuestionSubmit doJudge(long questionSubmitId);

}
