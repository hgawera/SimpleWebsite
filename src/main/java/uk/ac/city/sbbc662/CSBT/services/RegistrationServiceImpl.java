package uk.ac.city.sbbc662.CSBT.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.city.sbbc662.CSBT.dao.UserRepository;
import uk.ac.city.sbbc662.CSBT.domain.CollatedUser;
import uk.ac.city.sbbc662.CSBT.domain.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {


    private User currentUser;
    private List<User> user;
    private UserRepository userRepository;

    @Autowired
    public RegistrationServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        currentUser = user;
        userRepository.save(user);
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public int getNumberOfUsers(){
        return (int)userRepository.count();
    }
}
