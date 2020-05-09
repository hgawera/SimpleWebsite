package uk.ac.city.sbbc662.CSBT.domain;

import java.util.List;

public class CollatedUser {

    private List<LoginHistory> logins;
    private User user;

    public List<LoginHistory> getLogins() {
        return logins;
    }

    public void setLogins(List<LoginHistory> logins) {
        this.logins = logins;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }
}
