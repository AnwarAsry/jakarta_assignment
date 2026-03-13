package org.iths.jakartaassignment.Web;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.iths.jakartaassignment.Model.AppUser;

import java.io.Serializable;

@Named
@SessionScoped
@Getter
@Setter
public class SessionBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private AppUser loggedInUser;

    public void logout() {
        loggedInUser = null;
    }
}