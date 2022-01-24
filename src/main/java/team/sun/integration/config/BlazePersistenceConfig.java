package team.sun.integration.config;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.spi.CriteriaBuilderConfiguration;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


//扫描 @Controller、@Service 注解
@ComponentScan(basePackages = {"team.sun.integration.modules.**.controller", "team.sun.integration.modules.**.service"})
//扫描 @Repository 注解
@EnableJpaRepositories(basePackages = "team.sun.integration.modules.**.repository")
//扫描 @Entity 注解
@EntityScan(basePackages = "team.sun.integration.modules.**.model.entity")
@Configuration
public class BlazePersistenceConfig {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy(false)
    public CriteriaBuilderFactory createCriteriaBuilderFactory() {
        CriteriaBuilderConfiguration config = Criteria.getDefault();
        // do some configuration
//        config.getProperties().setProperty(ConfigurationProperties.QUERY_PLAN_CACHE_ENABLED, "false");
        return config.createCriteriaBuilderFactory(entityManagerFactory);
    }

    /**
     * 让Spring管理JPAQueryFactory
     */
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}
