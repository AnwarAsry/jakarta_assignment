package org.iths.jakartaassignment.Web;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.iths.jakartaassignment.Model.AppUser;
import org.iths.jakartaassignment.Repository.AppUserRepository;
import org.iths.jakartaassignment.Service.AppUserService;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter
public class AppUserBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    @Inject
    private AppUserService appUserService;
    @Inject
    private AppUserRepository appUserRepositoryImp;

    public List<AppUser> getUsers() {
        return appUserService.getAllUsers();
    }

    public void saveUser() {
        appUserService.saveUser(new AppUser(username, password));
        username = "";
        password = "";
    }
}
