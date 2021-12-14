package com.pojo;

import java.util.Objects;

public class Logins {
    private String username;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logins logins = (Logins) o;
        return Objects.equals(username, logins.username) && Objects.equals(password, logins.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "Logins{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Logins(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Logins() {
    }
}
