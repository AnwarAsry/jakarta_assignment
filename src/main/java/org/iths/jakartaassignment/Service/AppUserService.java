package org.iths.jakartaassignment.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.iths.jakartaassignment.Model.AppUser;
import org.iths.jakartaassignment.Repository.AppUserRepository;

import java.util.List;

@ApplicationScoped
public class AppUserService {
    private AppUserRepository appUserRepository;

    public AppUserService() {
    }

    @Inject
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Transactional
    public AppUser saveUser(AppUser user) {
        return appUserRepository.save(user);
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    // login method
    public AppUser login(String username, String password) {
        return appUserRepository.findByUsernameAndPassword(username, password);
    }
}
