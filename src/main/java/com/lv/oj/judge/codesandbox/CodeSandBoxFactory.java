package com.lv.oj.judge.codesandbox;

import com.lv.oj.judge.codesandbox.impl.ExampleCodeSandBoxImpl;
import com.lv.oj.judge.codesandbox.impl.RemoteCodeSandBoxImpl;
import com.lv.oj.judge.codesandbox.impl.ThirdPartyCodeSandBoxImpl;

/**
 * 代码沙箱工厂
 */
public class CodeSandBoxFactory {

    public static CodeSandBox newInstance(String type) {

        switch (type) {
            case "example":
                return new ExampleCodeSandBoxImpl();
            case "remote":
                return new RemoteCodeSandBoxImpl();
            case "thirdParty":
                return new ThirdPartyCodeSandBoxImpl();
            default:
                return new ExampleCodeSandBoxImpl();
        }

    }
}
