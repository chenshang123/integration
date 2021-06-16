package team.sun;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;

@SpringBootApplication
@EnableCaching
//扫描 @Controller、@Service 注解
@ComponentScan(basePackages = {"team.sun.integration.modules.**.controller", "team.sun.integration.modules.**.service"})
//扫描 @Repository 注解
@EnableJpaRepositories(basePackages = "team.sun.integration.modules.**.repository")
//扫描 @Entity 注解
@EntityScan(basePackages = "team.sun.integration.modules.**.model.entity")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 让Spring管理JPAQueryFactory
     */
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }


}
