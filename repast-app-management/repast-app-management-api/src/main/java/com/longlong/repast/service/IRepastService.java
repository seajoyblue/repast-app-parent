package com.longlong.repast.service;

import com.longlong.repast.fallback.RepastFallBackFactory;
import com.longlong.repast.model.LoginLog;
import com.longlong.repast.model.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-10
 * @Description:
 */
@FeignClient(value = "memberinfo-interface")
//@FeignClient(value = "memeberinfo-interface",fallbackFactory = RepastFallBackFactory.class)
public interface IRepastService {

    /**
     * @Author longlong
     * @Description 执行登录方法
     * @Date 2020/3/10
     * @Param
     * @Return
     **/
    @PostMapping("/doLogin")
    Boolean doLogin(@RequestBody Member member);

    /**
     * @Author longlong
     * @Description
     * 登录日志保存
     * @Date 2020/3/12
     * @Param 
     * @Return 
     **/
    @PostMapping("/saveLog")
    Boolean saveLog(@RequestBody LoginLog loginLog);
}
