package team.sun.integration.protocol.hex.scann;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
/*
  注解：协议编号
 */
public @interface ProtocolCode {
    int value();
}
