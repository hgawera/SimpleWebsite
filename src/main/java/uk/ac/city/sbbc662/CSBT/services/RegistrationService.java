package uk.ac.city.sbbc662.CSBT.services;

import uk.ac.city.sbbc662.CSBT.domain.User;

import java.util.List;

public interface RegistrationService {
    List<User> getUsers();
    void addUser(User user);
    User getCurrentUser();
    int getNumberOfUsers();
}
