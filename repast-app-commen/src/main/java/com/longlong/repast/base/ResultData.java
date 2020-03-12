package com.longlong.repast.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-09
 * @Description:
 */
@Data
public class ResultData<T> implements Serializable {
    //状态码
    private String code;
    //返回状态消息
    private String msg;
    //对返回状态消息的解释
    private String detail;
    private T data;
}
