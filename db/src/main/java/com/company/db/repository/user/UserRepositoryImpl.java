package com.company.db.repository.user;

import com.company.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;

@Repository
public class UserRepositoryImpl
        extends SimpleJpaRepository<User, Long>
        implements UserRepository {

    private EntityManager entityManager;

    @Override
    public User findByUsername(String username) throws Exception {
        Query query = queryByOneEqualsCriteria("username", username);
        return (User) query.getSingleResult();
    }

    @Override
    public User findByEmailAddress(String emailAddress) throws Exception {
        Query query = queryByOneEqualsCriteria("emailAddress", emailAddress);
        return (User) query.getSingleResult();
    }

    @Override
    public Boolean usernameIsExists(String username) {
        Query query = queryByOneEqualsCriteria("username", username);
        return !query.getResultList().isEmpty();
    }

    @Override
    public Boolean emailIsExists(String emailAddress) {
          Query query = queryByOneEqualsCriteria("emailAddress", emailAddress);
          return !query.getResultList().isEmpty();
    }

    private Query queryByOneEqualsCriteria(final String criteria, final String parameter){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> from = userCriteriaQuery.from(User.class);
        Expression<String> path = from.get(criteria);
        Predicate condition = criteriaBuilder.like(path, parameter);
        userCriteriaQuery.where(condition);
        return entityManager.createQuery(userCriteriaQuery);
    }

    @Autowired
    public UserRepositoryImpl(@Qualifier("userClass") Class<User> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
    }

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}