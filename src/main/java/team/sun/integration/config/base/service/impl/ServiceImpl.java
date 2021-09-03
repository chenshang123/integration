package team.sun.integration.config.base.service.impl;

import com.blazebit.persistence.CriteriaBuilderFactory;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import team.sun.integration.config.base.repository.IDao;
import team.sun.integration.config.base.service.IService;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Optional;

public class ServiceImpl<M extends IDao<T, String>, T> implements IService<T, String> {


    @Autowired
    @SuppressWarnings({"All"})
    protected M dao;

    protected JPAQueryFactory jpaQueryFactory;
    protected CriteriaBuilderFactory criteriaBuilderFactory;
    protected EntityManager entityManager;

    @Autowired
    public void init(JPAQueryFactory jpaQueryFactory, CriteriaBuilderFactory criteriaBuilderFactory, EntityManager entityManager) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.criteriaBuilderFactory = criteriaBuilderFactory;
        this.entityManager = entityManager;
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
    public void removeAllByIds(Collection<String> entities) {
        dao.deleteAllById(entities);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeByIds(Collection<T> entities) {
        dao.deleteAll(entities);
    }
}
