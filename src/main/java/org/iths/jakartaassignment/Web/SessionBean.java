package org.iths.jakartaassignment.Web;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
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

    public String logout() {
        loggedInUser = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login?faces-redirect=true";
    }
}