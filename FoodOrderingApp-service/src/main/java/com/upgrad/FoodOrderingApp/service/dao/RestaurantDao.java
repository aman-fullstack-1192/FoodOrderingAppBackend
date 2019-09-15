package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.RestaurantEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

//RestaurantDao class provides the database access for all the endpoints under RestaurantController
@Repository
public class RestaurantDao {

    @PersistenceContext
    private EntityManager entityManager;

    // This method is used to fetch all restaurants and return as a list
    public List<RestaurantEntity> restaurantsByRating() {
        try {
            return entityManager.createNamedQuery("getAllRestaurantsByRating", RestaurantEntity.class).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    // This method is used to return restaurant entity object based on UUID
    public RestaurantEntity getRestaurantByUUID(String uuid) {
        try {
            return entityManager.createNamedQuery("restaurantByUUID", RestaurantEntity.class).setParameter("uuid", uuid).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    // This method is used to update restaurant details and also to return restaurant entity object
    public RestaurantEntity updateRestaurantEntity(RestaurantEntity restaurantEntity) {
        return entityManager.merge(restaurantEntity);
    }
}
