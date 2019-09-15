package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CategoryEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

//CategoryDao class provides the database access to all the endpoints under CategoryController
@Repository
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    // This method is used to return the category based on the Category UUID
    public CategoryEntity getCategoryByUuid(String uuid) {
        try {
            return entityManager.createNamedQuery("categoryByUuid", CategoryEntity.class).setParameter("uuid", uuid).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
