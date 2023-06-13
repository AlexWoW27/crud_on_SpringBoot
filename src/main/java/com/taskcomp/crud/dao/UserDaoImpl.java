package com.taskcomp.crud.dao;

import com.taskcomp.crud.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setAge(user.getAge());
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void update(Long id,User updateUser) {
        User user = entityManager.find(User.class, id);
        user.setName(updateUser.getName());
        user.setSurname(updateUser.getSurname());
        user.setAge(updateUser.getAge());
        entityManager.merge(user);
    }

    @Override
    public User show(Long id) {
        return entityManager.find(User.class,id);
    }

}
