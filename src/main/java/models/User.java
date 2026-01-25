package models;

import app.AppContext;
import utils.Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {

    private User() {}
    private static User instance;
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }

        return instance;
    }

    private String username;
    private Role role;
    private boolean loggedIn = false;

    private List<LoginListener> loginListeners = new ArrayList<>();
    public void addLoginListener(LoginListener l) {
        loginListeners.add(l);
    }
    public void removeLoginListener(LoginListener l) {
        loginListeners.remove(l);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setLoggedIn() throws SQLException {
        this.loggedIn = true;
        AppContext.performConnection(Utils.getProperty(getRole().getPrivilege()+"_USER"), Utils.getProperty(getRole().getPrivilege()+"_PASS"));

        for (LoginListener l : loginListeners)
            l.onLoggedIn();
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public interface LoginListener {
        void onLoggedIn();
    }
}
