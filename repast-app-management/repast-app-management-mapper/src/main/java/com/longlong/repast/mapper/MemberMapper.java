package com.longlong.repast.mapper;


import com.longlong.repast.model.Member;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface MemberMapper extends Mapper<Member> {

    Member selectMemberByOpenId(String openId);

}