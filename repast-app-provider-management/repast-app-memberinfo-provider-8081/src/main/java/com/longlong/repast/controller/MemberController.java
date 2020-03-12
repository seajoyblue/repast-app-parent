package com.longlong.repast.controller;

import com.longlong.repast.model.LoginLog;
import com.longlong.repast.model.Member;
import com.longlong.repast.service.LoginLogService;
import com.longlong.repast.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-10
 * @Description:
 */
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private LoginLogService loginLogService;
    /**
     * @Author longlong
     * @Description
     * 执行登录操作
     * @Date 2020/3/10
     * @Param
     * @Return
     **/
    @PostMapping("/doLogin")
    public Boolean doLogin(@RequestBody Member member) {
        return memberService.doLogin(member);
    }


    /**
     * @Author longlong
     * @Description
     * 登录日志保存
     * @Date 2020/3/12
     * @Param
     * @Return
     **/
    @PostMapping("/saveLog")
    public Boolean saveLog(@RequestBody LoginLog loginLog){
        return loginLogService.addLoginLog(loginLog);
    }
}
