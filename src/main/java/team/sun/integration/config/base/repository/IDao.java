package team.sun.integration.config.base.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IDao<T, ID> extends CrudRepository<T, ID>, QuerydslPredicateExecutor<T> {


}
