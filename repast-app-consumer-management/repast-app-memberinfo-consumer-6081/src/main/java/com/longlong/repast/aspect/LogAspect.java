package com.longlong.repast.aspect;

import com.longlong.repast.annotation.LoginLogAnnotation;
import com.longlong.repast.model.LoginLog;
import com.longlong.repast.model.Member;
import com.longlong.repast.service.IRepastService;
import com.longlong.repast.util.AddressUtil;
import com.longlong.repast.util.DateUtil;
import com.longlong.repast.util.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import static com.longlong.repast.Staticstatus.StaticCode.*;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-11
 * @Description:
 */
@Slf4j
@Component
@Aspect
public class LogAspect {

    @Autowired
    private IRepastService repastService;


    /**
     * @Author longlong
     * @Description
     * 定义切面
     * @Date 2020/3/11
     * @Param
     * @Return
     **/
    @Pointcut("@annotation(com.longlong.repast.annotation.LoginLogAnnotation)")
    public void pointcut(){
    }

    /**
     * @Author longlong
     * @Description
     * 定义环形切面
     * @Date 2020/3/11
     * @Param
     * @Return
     **/
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Exception{
        Object result=null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable t){
            t.printStackTrace();
        }

        //获取Request对象  IP
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取用户的ip地址
        String ipAddr = IPUtil.getIpAddr(request);

        Member member = new Member();
        //这里获取到所有的参数值的数组
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            member = (Member) arg;

        }

        //获取OperationType和OperationName的值
        //先进行初始化
        String operationType="";
        String operationName="";
        //获取目标路径（MemmberController类）的完全限定名
        String classname = proceedingJoinPoint.getTarget().getClass().getName();
        //通过反射获取到对象
        Class targetClass = Class.forName(classname);
        //获取到所需要切的方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        //获取到对象中所有的方法，得到一个数组
        Method[] methods = targetClass.getMethods();
        //遍历得到的方法数组，找到与所需方法名相同的方法
        for (Method method : methods) {
            //找到了相同名称的方法，但是有隐患，因为有重载，所以名称一样不能确定
            //一定是所需的方法
            if (method.getName().equalsIgnoreCase(methodName)){
                //确认过名称相同后再根据参数是否一致来确定方法
                //获取方法的参数类型个数
                Class[] parameterTypes = method.getParameterTypes();
                //再次判断
                if (parameterTypes.length==args.length){
                     operationType = method.getAnnotation(LoginLogAnnotation.class).operationType();
                     operationName = method.getAnnotation(LoginLogAnnotation.class).operationName();
                    break;
                }
            }
        }

        Map<String, Object> addressesMap = AddressUtil.getAddresses(TEST_IP, ENCODING);
        LoginLog loginLog = new LoginLog();
        loginLog.setProvince((String)addressesMap.get(PROVINCE));//登录信息，登录地址
        loginLog.setCity((String)addressesMap.get(CITY));//获取城市信息
        loginLog.setOpenId((String)member.getOpenId());//微信传过来的openID

        String dateString = DateUtil.formatDate(new Date(), FORMAT_DATE);
        loginLog.setCreateTime(dateString);//日志创建时间
        loginLog.setLoginType(3);//登录类型（3指小程序）
        loginLog.setIp(ipAddr);//用户ip地址


        loginLog.setOperationType(operationType);//操作类型
        loginLog.setOperationName(operationName);//具体操作事项


        Boolean ifSuccess = repastService.saveLog(loginLog);
        if (ifSuccess){
            return request;//返回request的目的就是让程序回到controller中
        }
        return null;//表示代码结束
    }
}
