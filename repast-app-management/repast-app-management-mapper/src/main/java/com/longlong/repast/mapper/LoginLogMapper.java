package com.longlong.repast.mapper;

import com.longlong.repast.model.LoginLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface LoginLogMapper extends Mapper<LoginLog> {
        Integer  addLoginLog(LoginLog loginLog);
}