package com.example.lucenedemo.config;


import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CountDownLatch;

/**
 * https://www.cnblogs.com/quanxiaoha/p/10414681.html
 * @author www.exception.site (exception )
 * @date 2019/2/12
 * @time 14:03
 * @discription
 **/
@Aspect
@Component
public class WebLogAspect {

    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    /**

     * 定义切入点：对要拦截的方法进行定义与限制，如包、类

     * 1、execution(public * *(..)) 任意的公共方法

     * 2、execution（* set*（..）） 以set开头的所有的方法

     * 3、execution（* com.lingyejun.annotation.LoggerApply.*（..））com.lingyejun.annotation.LoggerApply这个类里的所有的方法

     * 4、execution（* com.lingyejun.annotation.*.*（..））com.lingyejun.annotation包下的所有的类的所有的方法

     * 5、execution（* com.lingyejun.annotation..*.*（..））com.lingyejun.annotation包及子包下所有的类的所有的方法

     * 6、execution(* com.lingyejun.annotation..*.*(String,?,Long)) com.lingyejun.annotation包及子包下所有的类的有三个参数，第一个参数为String类型，第二个参数为任意类型，第三个参数为Long类型的方法

     * 7、execution(@annotation(com.lingyejun.annotation.Lingyejun))

     */
    //指定路径下的所有方法
//    @Pointcut("execution(public * com.example.lucenedemo.interfaceInfo.LogInfo..*.*(..))")
     //指定路径下加自定义注解的
    @Pointcut("@annotation(com.example.lucenedemo.interfaceInfo.LogInfo)")
    public void webLog() {}



    /**
     * 在切点之前织入
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 打印请求相关参数
        logger.info("========================================== Start ==========================================");
        // 打印请求 url
        logger.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        logger.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        logger.info("Request Args   : {}", new Gson().toJson(joinPoint.getArgs()));
    }

    /**
     * 在切点之后织入
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter() throws Throwable {
        logger.info("=========================================== End ===========================================");
        // 每个请求之间空一行
        logger.info("");
    }

    /**
     * 环绕
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        logger.info("Response Args  : {}", new Gson().toJson(result));
        // 执行耗时
        logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }

}

