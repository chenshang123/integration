package team.sun.integration.modules.base.service.impl;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import team.sun.integration.modules.base.repository.IDao;
import team.sun.integration.modules.base.service.IService;
import team.sun.integration.modules.base.tool.reflect.ReflectionKit;

import java.util.Collection;
import java.util.Optional;

public class ServiceImpl<M extends IDao<T, String>, T> implements IService<T, String> {


    @Autowired
    @SuppressWarnings({"All"})
    protected M dao;

    protected JPAQueryFactory jpaQueryFactory;
    protected Class<?> entityClass = currentModelClass();

    @Autowired
    public void init(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    protected Class<T> currentModelClass() {
        return (Class<T>) ReflectionKit.getSuperClassGenericType(getClass(), 1);
    }


    @Override
    public Optional<T> getById(String s) {
        return dao.findById(s);
    }

    @Override
    public Iterable<T> getByIds(Collection<String> idList) {
        return dao.findAllById(idList);
    }

    @Override
    public Iterable<T> get() {
        return dao.findAll();
    }

    @Override
    public Iterable<T> get(Predicate predicate) {
        return dao.findAll(predicate);
    }

    @Override
    public Iterable<T> get(Predicate predicate, OrderSpecifier<?>... orders) {
        return dao.findAll(predicate, orders);
    }

    @Override
    public T saveOrUpdate(T entity) {
        return dao.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Iterable<T> saveOrUpdateBatch(Collection<T> entities) {
        return dao.saveAll(entities);
    }

    @Override
    public void removeById(String s) {
        dao.deleteById(s);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeByIds(Collection<T> entities) {
        dao.deleteAll(entities);
    }
}
