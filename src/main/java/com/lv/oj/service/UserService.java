package com.lv.oj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.oj.model.entity.User;
import com.lv.oj.model.vo.LoginUserVO;

import javax.servlet.http.HttpServletRequest;

public interface UserService extends IService<User> {


    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    LoginUserVO loginUser(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取脱敏的已登录用户信息
     *
     * @return
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    Long userRegister(String userAccount, String userPassword, String checkPassword);

}
