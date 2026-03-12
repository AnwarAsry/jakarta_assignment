package org.iths.jakartaassignment.Web;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.iths.jakartaassignment.Model.AppUser;
import org.iths.jakartaassignment.Repository.AppUserRepository;
import org.iths.jakartaassignment.Service.AppUserService;

import java.io.Serializable;

@Named
@RequestScoped
@Getter
@Setter
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    @Inject
    private AppUserService appUserService;
    @Inject
    private AppUserRepository appUserRepositoryImp;

    public String login() {
        AppUser user = appUserService.login(username, password);
        if (user != null) {
            return "";
        } else {
            return null;
        }
    }
}
