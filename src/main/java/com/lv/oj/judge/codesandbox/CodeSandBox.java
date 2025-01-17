package com.lv.oj.judge.codesandbox;

import com.lv.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lv.oj.judge.codesandbox.model.ExecuteCodeResponse;

public interface CodeSandBox {

    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
