package team.sun.integration.config.date;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间格式
 * 解析/转换
 */
@Configuration
public class DateFormatConfig {

    /**
     * 自定义Bean
     * @return
     */
    @Bean
    @Primary
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder
                .serializerByType(LocalDateTime.class, new OffsetDateTimeSerializer())
                .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.RFC_1123_DATE_TIME));
    }
}
