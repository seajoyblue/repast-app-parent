package com.longlong.repast.service;

import com.longlong.repast.base.BaseService;
import com.longlong.repast.mapper.MemberMapper;
import com.longlong.repast.model.Member;
import com.longlong.repast.util.IDUtil;
import com.longlong.repast.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-10
 * @Description:
 */
@Service
public class MemberService extends BaseService<Member> {

    @Autowired
    private MemberMapper memberMapper;
    @Override
    public Mapper<Member> getMapper() {
        return memberMapper;
    }

    /**
     * @Author longlong
     * @Description
     * 执行登录操作
     * @Date 2020/3/10
     * @Param
     * @Return
     **/
    public Boolean doLogin(Member member){
        if (null != member && null != member.getOpenId() && StringUtil.isNotEmpty(member.getOpenId())){
            try {
                Member mb = memberMapper.selectMemberByOpenId(member.getOpenId());
                String token = IDUtil.getUUID() + member.getOpenId();
                //判断是否登录过
                if (null!=null){
                    mb.setToken(token);
                    Integer updateResult = super.update(mb);
                    if (updateResult>0){
                        return true;
                    }
                }else {
                    //如果是新用户,需要执行的是insert操作
                    member.setToken(token);
                    Integer saveResult = super.save(member);
                    if (saveResult>0){
                        //保存成功
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
