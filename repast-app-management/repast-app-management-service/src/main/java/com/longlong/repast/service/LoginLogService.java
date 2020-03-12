package com.longlong.repast.service;

import com.longlong.repast.base.BaseService;
import com.longlong.repast.mapper.LoginLogMapper;
import com.longlong.repast.model.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-12
 * @Description:
 */
@Service
public class LoginLogService extends BaseService<LoginLog> {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public Mapper<LoginLog> getMapper() {
        return loginLogMapper;
    }
    
    /**
     * @Author longlong
     * @Description
     * 保存登录日志
     * @Date 2020/3/12
     * @Param 
     * @Return 
     **/
    public Boolean addLoginLog(LoginLog loginLog){
        try {
            Integer saveResult = super.save(loginLog);
            if (saveResult>0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
