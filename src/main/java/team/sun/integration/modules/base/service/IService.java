package team.sun.integration.modules.base.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.modules.base.model.vo.PageRet;

import java.util.Collection;
import java.util.Optional;

public interface IService<T, ID> {

    Optional<T> getById(ID id);

    Iterable<T> getByIds(Collection<ID> idList);

    Iterable<T> get();

    Iterable<T> get(Predicate predicate);

    Iterable<T> get(Predicate predicate, OrderSpecifier<?>... orders);

    T saveOrUpdate(T entity);

    Iterable<T> saveOrUpdateBatch(Collection<T> entities);

    void removeById(ID id);

    void removeByIds(Collection<T> entities);

}
