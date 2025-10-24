package by.vadarod.homework.repository;

import by.vadarod.homework.config.HibernateConnection;
import by.vadarod.homework.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class UserRepository {

    public List<User> findBetweenAge(int startYear, int endYear) {
        EntityManager em = HibernateConnection.getEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.between(root.get("yearOfBirth"), startYear, endYear));
        return em.createQuery(criteriaQuery).getResultList();
    }
}
