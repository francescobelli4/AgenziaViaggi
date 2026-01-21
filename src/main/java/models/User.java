package models;

public class User {

    private String username;
    private Role role;
    private boolean loggedIn = false;

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
