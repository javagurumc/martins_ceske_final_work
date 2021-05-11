package lv.lu.martins.ceske.finalwork.repository;

import lv.lu.martins.ceske.finalwork.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Repository
public class ProductOrmRepository implements Repository<Product> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Long save(Product entity) {
        this.entityManager.persist(entity);
        return entity.getId();
    }

    @Override
    public List<Product> findAll() {
        CriteriaQuery<Product> criteriaQuery = this.entityManager.getCriteriaBuilder().createQuery(Product.class);
        criteriaQuery.from(Product.class);
        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Product findById(Long id) {
        return this.entityManager.find(Product.class, id);
    }

    @Override
    public void delete(Long id) {
        Product productEntity = findById(id);
        this.entityManager.remove(productEntity);
    }
}
