package com.lv.oj.controller;

import com.lv.oj.common.BaseResponse;
import com.lv.oj.common.ErrorCode;
import com.lv.oj.common.ResultUtils;
import com.lv.oj.exception.BusinessException;
import com.lv.oj.model.dto.UserLoginRequest;
import com.lv.oj.model.dto.UserRegisterRequest;
import com.lv.oj.model.vo.LoginUserVO;
import com.lv.oj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public BaseResponse<LoginUserVO> loginUser(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAllBlank(userAccount, userPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        LoginUserVO loginUserVO = userService.loginUser(userAccount, userPassword, request);
        return ResultUtils.success(loginUserVO);
    }

    /**
     * 用户注册
     */
    @PostMapping("/userRegister")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest){
        if (userRegisterRequest == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if (StringUtils.isAllBlank(userAccount,userPassword,checkPassword)){
            return null;
        }
        Long result = userService.userRegister(userAccount,userPassword,checkPassword);
        return ResultUtils.success(result);
    }
}
