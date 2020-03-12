package com.longlong.repast.status;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-09
 * @Description:
 */
public enum LoginStatus {
    LOGIN_SUCCESS("201","登陆成功"),
    LOGIN_FAILED("501","登陆失败"),
    USER_EXIST("202","用户存在"),
    USER_NOT_EXIST("401","用户不存在"),
    PASSWORD_WRONG("502","密码错误"),
    LOGOUT_WRONG("503","用户退出异常");

    LoginStatus(String code,String msg){
        this.code=code;
        this.msg=msg;
    };

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
