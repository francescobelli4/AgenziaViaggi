package models;

import java.util.Objects;

public enum Role {
    AMMINISTRAZIONE("Amministrazione"),
    BOOKING("Booking");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static Role fromString(String role) {

        for (Role r : Role.values()) {
            if (Objects.equals(r.getRole(), role)) {
                return r;
            }
        }

        return null;
    }
}
