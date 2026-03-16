package org.iths.jakartaassignment.Web;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.iths.jakartaassignment.Model.AppUser;
import org.iths.jakartaassignment.Service.AppUserService;

@Named
@RequestScoped
@Getter
@Setter
public class LoginBean {
    private String username;
    private String password;
    private String errorMessage;

    @Inject
    private AppUserService appUserService;
    @Inject
    private SessionBean sessionBean;

    public String login() {
        AppUser user = appUserService.login(username, password);
        if (user != null) {
            sessionBean.setLoggedInUser(user);
            return "/appuser.xhtml?faces-redirect=true";
        } else {
            errorMessage = "Could not find user";
            username = "";
            password = "";
            return null;
        }
    }
}
