package com.example.productmanagementorm.repository;

import com.example.productmanagementorm.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
/*        String sql = "select p from Product p";
        TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);
        return query.getResultList();*/
        Query query = entityManager.createQuery("select p from Product p");
        return query.getResultList();
    }
////        Truyền tham số
////        query.setParameter("name", "%vu%");
    @Override
    @Transactional
    public void add(Product product) {
        entityManager.persist(product);
    }
    @Override
    @Transactional
    public void update(Product product) {
        entityManager.merge(product);
    }

        @Override
        @Transactional
        public void delete(int id) {
        Product product = entityManager.find(Product.class, id);
            entityManager.remove(product);
        }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findByName(String keyWord) {
        Query query = entityManager.createQuery("select p from Product p where p.name like ?1");
        query.setParameter(1, "%" + keyWord + "%");
        return query.getResultList();
    }
}