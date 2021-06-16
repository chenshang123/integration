package team.sun.integration.common.exception;

import java.util.Iterator;
import java.util.Set;

import team.sun.integration.modules.base.model.vo.Ret;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandle {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandle.class);

    /**
     @Resource private LogService logService;
     @Resource private RoleService roleService;
     */
    /**
     * 身份验证异常

     @ExceptionHandler({AuthenticationException.class, AuthException.class})
     public ApiResult authenticationException(Exception e) {
     if (e instanceof UnknownAccountException || e instanceof IncorrectCredentialsException) {
     return ApiResult.fail("用户名或密码错误");
     } else if (e instanceof LockedAccountException || e instanceof ExcessiveAttemptsException) {
     return ApiResult.fail("超过了尝试登录的次数，您的账户已经被锁定。");
     } else if (e instanceof DisabledAccountException) {
     return ApiResult.fail("用户被禁用");
     } else if (e instanceof ConcurrentAccessException) {
     return ApiResult.fail("用户已登录,不允许多地登录");
     } else if (e instanceof AuthException) {
     return ApiResult.fail(e.getMessage());
     } else {
     log.error("登录失败,未知错误", e);
     return ApiResult.fail("登录失败,联系管理员");
     }
     }*/

    /**
     * 授权验证异常

     @ExceptionHandler(AuthorizationException.class) public ApiResult authorizationException(AuthorizationException e) {
     if (e instanceof UnauthenticatedException) {
     return ApiResult.fail("没有登录");
     }

     User user = WebUtils.user();
     //请求的IP
     String ip = IpUtils.getRequestIp(WebUtils.request());
     LocalDateTime localDateTime = LocalDateTime.now();
     String opera = "越权访问";
     StringBuffer content = new StringBuffer();
     try {
     content.append("【").append(user.getUsername()).append("】").append(opera);
     content.append("： “").append(user.getUsername()).append("” ").append(DateUtils.formatDateTime(localDateTime, DatePattern.DATETIME))
     .append(" 在IP地址为<").append(ip).append(">的客户端进行 “").append(opera).append("” 操作失败");
     } catch (Exception e1) {
     e1.printStackTrace();
     }

     Log log = new Log(ip, opera, content.toString(), false, 2, ErrorType.CRITICAL.getValue(), user.getUsername(), new Date());
     logService.insert(log);
     sendErrorMsg(log);
     return ApiResult.fail("没有权限");
     }*/

    /**
     * Hibernate Validator参数校验异常处理
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public Ret<String> bindException(Exception e) {
        BindingResult bindingResult;
        if (e instanceof BindException) {
            bindingResult = ((BindException) e).getBindingResult();
        } else bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        Iterator<FieldError> iterator = bindingResult.getFieldErrors().iterator();
        if (!iterator.hasNext()) {
            return Ret.fail("[]");
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (true) {
            FieldError fieldError = iterator.next();
            sb.append(fieldError.getField()).append(fieldError.getDefaultMessage());
            if (!iterator.hasNext()) {
                return Ret.fail(sb.append(']').toString());
            }
            sb.append(',').append(' ');
        }
    }

    /**
     * Spring Validator参数校验异常处理
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Ret<String> handler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            String message = constraintViolation.getMessage();
            if (!StringUtils.isEmpty(message)) {
                //直接返回第一个错误信息
                return Ret.fail(message);
            }
        }
        return Ret.fail("参数错误");
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Ret<String> httpMessageNotReadableException() {
        return Ret.fail("传入数据有误");
    }


    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Ret<String> businessException(BusinessException e) {
        log.error("[全局异常] - 业务异常", e);
        return Ret.fail(e.getMessage());
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public Ret<String> nullPointerException(NullPointerException e) {
        log.error("[全局异常] - 空指针异常", e);
        return Ret.fail("空指针异常,请联系管理员");
    }

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Ret<String> runtimeException(RuntimeException e) {
        log.error("[全局异常] - 运行时异常", e);
        return Ret.fail(e.getMessage());
    }


    /**
     * 未知异常
     */
    @ExceptionHandler(Exception.class)
    public Ret<String> exception(Exception e) {
        log.error("[全局异常] - 未知异常", e);
        return Ret.fail(e.getMessage());
    }


}
