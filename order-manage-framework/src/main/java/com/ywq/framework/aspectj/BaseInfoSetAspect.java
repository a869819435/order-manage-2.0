package com.ywq.framework.aspectj;

import com.ywq.common.core.domain.model.LoginUser;
import com.ywq.common.utils.ServletUtils;
import com.ywq.common.utils.reflect.ReflectUtils;
import com.ywq.common.utils.spring.SpringUtils;
import com.ywq.framework.web.service.TokenService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class BaseInfoSetAspect {
    
    @Pointcut(value = "execution(* com.ywq.*.service.*.insert*(..))")
    public void insertInitInfoPointCut(){
    }

    @Pointcut(value = "execution(* com.ywq.*.service.*.update*(..))")
    public void updateInitInfoPointCut(){
    }
    
    @Before(value = "insertInitInfoPointCut()")
    public void insertInitInfo(JoinPoint joinPoint){
        LoginUser loginUser = SpringUtils.getBean(TokenService.class).getLoginUser(ServletUtils.getRequest());
        Object[] args = joinPoint.getArgs();
        if (args.length > 0){
            Object temp = args[0];
            ReflectUtils.invokeSetter(temp,"isDeleted",0);
            ReflectUtils.invokeSetter(temp,"createUser",loginUser.getUser().getUserId());
            ReflectUtils.invokeSetter(temp,"createDate",new Date());
            ReflectUtils.invokeSetter(temp,"updateUser",loginUser.getUser().getUserId());
            ReflectUtils.invokeSetter(temp,"updateDate",new Date());
        }
    }

    @Before(value = "updateInitInfoPointCut()")
    public void updateInitInfo(JoinPoint joinPoint){
        LoginUser loginUser = SpringUtils.getBean(TokenService.class).getLoginUser(ServletUtils.getRequest());
        Object[] args = joinPoint.getArgs();
        if (args.length > 0){
            Object temp = args[0];
            ReflectUtils.invokeSetter(temp,"updateUser",loginUser.getUser().getUserId());
            ReflectUtils.invokeSetter(temp,"updateDate",new Date());
        }
    }
}
