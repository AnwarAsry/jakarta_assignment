package org.iths.jakartaassignment.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.iths.jakartaassignment.Model.AppUser;

import java.util.List;

@ApplicationScoped
public class AppUserRepositoryImpl implements AppUserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public AppUser save(AppUser user) {
        em.persist(user);
        return user;
    }

    @Override
    public List<AppUser> findAll() {
        return em.createQuery("SELECT u FROM AppUser u", AppUser.class)
                .getResultList();
    }
}