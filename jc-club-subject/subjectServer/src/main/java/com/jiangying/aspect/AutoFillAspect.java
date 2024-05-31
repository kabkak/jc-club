package com.jiangying.aspect;



import com.jiangying.annotation.AutoFill;
import com.jiangying.context.BaseContext;
import com.jiangying.enumeration.OperationType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AutoFillAspect {
    //切入点 带有注解的mapper切点
    @Pointcut("execution(* com.jiangying.mapper.*.*(..)) && @annotation(com.jiangying.annotation.AutoFill)")
    public void autoFillPointCut() {
    }
    //@AutoFill(value = OperationType.UPDATE)
    @Before("autoFillPointCut()")
    public void before(JoinPoint joinPoint) throws Exception {
        //获得当前方法的数据库操作类型
        AutoFill autoFill = (AutoFill) joinPoint.getSignature().getDeclaringType().getAnnotation(AutoFill.class);
        OperationType value = autoFill.value();

        Object[] args = joinPoint.getArgs();
        //判断args是否为空
        if (args == null || args.length == 0) {
            return;
        }
        Object object = args[0];
        LocalDateTime now = LocalDateTime.now();
        Long id = BaseContext.getCurrentId();
        switch (value) {
            case UPDATE:
                //通过反射给当前对象的属性值赋值

                object.getClass().getDeclaredField("updateTime").set(object, now);
                object.getClass().getDeclaredField("updateBy").set(object, now);

                //更新
                break;
            case INSERT:
                object.getClass().getDeclaredField("createTime").set(object, now);
                object.getClass().getDeclaredField("updateTime").set(object, now);
                object.getClass().getDeclaredField("updateBy").set(object, id);
                object.getClass().getDeclaredField("createBy").set(object, id);
                //新增
                break;
        }
    }
}
