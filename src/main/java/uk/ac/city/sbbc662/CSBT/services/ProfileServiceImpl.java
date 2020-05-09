package uk.ac.city.sbbc662.CSBT.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.city.sbbc662.CSBT.dao.HistoryRepository;
import uk.ac.city.sbbc662.CSBT.dao.UserRepository;
import uk.ac.city.sbbc662.CSBT.domain.CollatedUser;
import uk.ac.city.sbbc662.CSBT.domain.LoginHistory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService{

    private HistoryRepository historyRepository;
    private UserRepository userRepository;


    @Autowired
    public ProfileServiceImpl(HistoryRepository historyRepository, UserRepository userRepository) {
        this.historyRepository = historyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CollatedUser getProfile(String email) {
        CollatedUser collatedUser = new CollatedUser();
        collatedUser.setUser(userRepository.findById(email).orElseThrow(()-> new UsernameNotFoundException("No matching user found.")));

        List<LoginHistory> history = historyRepository.findAll()
                .stream().filter(loginHistory -> loginHistory.getEmail().equals(email))
                .collect(Collectors.toList());
        collatedUser.setLogins(history);
        return collatedUser;
    }
}
