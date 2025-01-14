package com.lv.oj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.oj.model.entity.User;
import com.lv.oj.model.vo.LoginUserVO;
import com.lv.oj.model.vo.UserVO;

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
     * 获取脱敏的题目创建人信息
     *
     * @return
     */
    UserVO getUserVO(User user);

    /**
     * 是否为管理员
     *
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 是否为管理员
     *
     * @param user
     * @return
     */
    boolean isAdmin(User user);

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    Long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户注销
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 获取当前用户
     * @param request
     * @return 当前用户
     */
    User getLoginUser(HttpServletRequest request);

    
}
