package com.longlong.repast.fallback;

import com.longlong.repast.model.LoginLog;
import com.longlong.repast.model.Member;
import com.longlong.repast.service.IRepastService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-10
 * @Description:
 */
@Component
public class RepastFallBackFactory implements FallbackFactory<IRepastService> {
    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService() {
            @Override
            public Boolean doLogin(Member member) {
                System.out.println("熔断登录方法！");
                return null;
            }

            @Override
            public Boolean saveLog(LoginLog loginLog) {
                return null;
            }
        };

        return repastService;
    }
}
