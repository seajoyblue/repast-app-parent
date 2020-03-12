package com.longlong.repast.base;

import org.springframework.stereotype.Controller;

import static com.longlong.repast.status.LoginStatus.*;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-09
 * @Description:
 */
@Controller
public class BaseController {


/**
 * @Author longlong
 * @Description
 * 登陆成功，使用系统消息
 * @Date 2020/3/9
 * @Param 
 * @Return
 **/
    protected ResultData success() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Author longlong
     * @Descriptio
     *     登陆成功，自定义返回消息
     * @Date 2020/3/9
     * @Param 
     * @Return 
     **/
    protected ResultData success(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Author longlong
     * @Description
     *  登陆成功，自定义返回消息和自定义解释说明
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected ResultData success(String msg, String detail) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setDetail(detail);
        return resultData;
    }
    
    /**
     * @Author longlong
     * @Description
     * 登陆成功，使用系统消息，自定义返回值
     * @Date 2020/3/9
     * @Param 
     * @Return 
     **/
    protected ResultData success(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Author longlong
     * @Description
     * 登陆成功，自定义消息，自定义返回值
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected ResultData success(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Author longlong
     * @Description
     * 登陆成功，自定义消息,自定义解释说明，自定义数据
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected ResultData success(String msg, String detail, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Author longlong
     * @Description
     * 登录失败，使用系统消息
     * @Date 2020/3/10
     * @Param
     * @Return
     **/
    protected ResultData failed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }
    /**
     * @Author longlong
     * @Description 
     * 登陆失败，使用自定义消息
     * @Date 2020/3/9
     * @Param 
     * @Return 
     **/
    protected ResultData failed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Author longlong
     * @Description
     * 登陆失败，自定义返回消息和自定义解释说明
     * @Date 2020/3/9
     * @Param 
     * @Return 
     **/
    protected ResultData failed(String msg, String detail) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @Author longlong
     * @Description
            登陆失败，使用系统消息，自定义返回值
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected ResultData failed(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Author longlong
     * @Description
     * 登陆失败，自定义消息，自定义返回值
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected ResultData failed(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
    /**
     * @Author longlong
     * @Description
     * 登陆失败，自定义消息,自定义解释说明，自定义数据
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected ResultData failed(String msg, String detail, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        resultData.setDetail(detail);
        resultData.setData(data);
        return resultData;
    }
}
