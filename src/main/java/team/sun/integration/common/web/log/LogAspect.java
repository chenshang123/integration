package team.sun.integration.common.web.log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import team.sun.integration.common.base.model.vo.Ret;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import team.sun.integration.common.annotation.BusinessLog;
import team.sun.integration.common.annotation.ParamParser;
import team.sun.integration.common.utils.IpUtil;
import team.sun.integration.common.utils.WebUtils;


/**
 * 日志切面
 *
 * @author TaoYu
 */
@Aspect
public class LogAspect {
    private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);

    private final ExecutorService executorService = new ThreadPoolExecutor(5, 50,
            5, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(512), // 使用有界队列，避免OOM
            new ThreadPoolExecutor.CallerRunsPolicy());//CallerRunsPolicy策略：如果线程池的线程数量达到上限，该策略会把任务队列中的任务放在调用者线程当中运行；

    @Around("@annotation(team.sun.integration.common.annotation.BusinessLog))")
    public Ret logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Ret ret = null;
        long startTime = 0;
        long costTime;
        try {
            startTime = System.currentTimeMillis();
            ret = (Ret) proceedingJoinPoint.proceed();
        } catch (Exception e) {
            LOG.error("切面保存日志入口异常   error");
            throw e;
        } finally {
            costTime = (System.currentTimeMillis() - startTime) / 1000;
            if (ret == null) {// 实际方法异常
                ret = ret.fail();
            }

            MethodInvocationProceedingJoinPoint joinPoint = (MethodInvocationProceedingJoinPoint) proceedingJoinPoint;
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            BusinessLog businessLog = method.getDeclaredAnnotation(BusinessLog.class);
            Map<String, Object> map = new HashMap<>();
            if (businessLog != null) {
                String ip = IpUtil.getRequestIp(WebUtils.request());
                String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

                String operation = businessLog.value();
                Integer logType = businessLog.type();
                String exceLevel = businessLog.exceLevel();

                StringBuffer sb = new StringBuffer();
                String orgIdString = WebUtils.request().getHeader("USER_NAME");
                String orgId = WebUtils.request().getHeader("ORG_ID");
                sb.append("【").append(orgIdString).append("】").append(operation);
                Object paramParserObj = null;
                Parameter[] parameters = method.getParameters();
                if (parameters != null && parameters.length > 0) {
                    Object[] args = joinPoint.getArgs();
                    for (int i = 0; i < parameters.length; i++) {
                        Annotation an = parameters[i].getDeclaredAnnotation(ParamParser.class);
                        if (an != null) {
                            paramParserObj = args[i];
                            break;
                        }
                    }
                }

                if (paramParserObj != null) {
                    sb.append("：").append(paramParserObj.toString());
                }
                map.put("ip", ip);
                map.put("methodName", methodName);
                map.put("operation", operation);
                map.put("content", sb.toString());
                map.put("state", ret.getCode());
                map.put("logType", logType);
                map.put("exceLevel", exceLevel);
                map.put("createUser", orgIdString);
                map.put("costTime", costTime);
                map.put("createTime", new Date());
                map.put("orgId", orgId);
                try {
                    executorService.submit(new Callable<Object>() {
                        @Override
                        public Object call() throws Exception {
//                            String paramsJson  = HttpClientUtil.paseMapToJsonString(map);
//                            HttpClientUtil.sendHttpPostJson(config.getGateWayUrl()+config.getSaveLogUrl(), paramsJson, null);
                            throw new RuntimeException("exception in call~");
                        }
                    });
                } catch (Exception e2) {
                    LOG.error("调用线程  保存日志失败 save log error");
                }
            }
        }
        return ret;
    }

}
