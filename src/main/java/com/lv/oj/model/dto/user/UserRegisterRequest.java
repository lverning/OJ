package com.lv.oj.model.dto.user;


import java.io.Serializable;

public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String userAccount, String userPassword, String checkPassword) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.checkPassword = checkPassword;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    @Override
    public String toString() {
        return "UserRegisterRequest{" +
                "userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", checkPassword='" + checkPassword + '\'' +
                '}';
    }
}
