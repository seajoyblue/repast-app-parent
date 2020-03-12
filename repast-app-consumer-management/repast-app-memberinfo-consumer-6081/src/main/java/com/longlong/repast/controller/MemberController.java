package com.longlong.repast.controller;

import com.longlong.repast.annotation.LoginLogAnnotation;
import com.longlong.repast.base.BaseController;
import com.longlong.repast.base.ResultData;
import com.longlong.repast.model.Member;
import com.longlong.repast.service.IRepastService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-10
 * @Description:
 */
@RestController
@Api(value = "用户信息",tags = "用户信息接口（提供用户所有有关操作）")
public class MemberController extends BaseController {

    @Autowired
    private IRepastService repastService;

/**
 * @Author longlong
 * @Description
 * 执行登录操作
 * @Date 2020/3/10
 * @Param
 * @Return
 **/
    @PostMapping("/doLogin")
    @ApiOperation(value = "登录",notes = "用户执行登录操作（接受微信段传递数据）")
    @LoginLogAnnotation(operationType = "登录操作",operationName = "普通用户登录")
    public ResultData doLogin (Member member){
        Boolean ifSuccess = repastService.doLogin(member);
        if (ifSuccess){
            return super.success();
        }
        return super.failed();
    }
}
