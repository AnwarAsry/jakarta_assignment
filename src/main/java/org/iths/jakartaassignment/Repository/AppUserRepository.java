package org.iths.jakartaassignment.Repository;

import org.iths.jakartaassignment.Model.AppUser;

import java.util.List;

public interface AppUserRepository {
    AppUser save(AppUser user);

    List<AppUser> findAll();
}
