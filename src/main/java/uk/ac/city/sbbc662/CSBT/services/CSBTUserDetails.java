package uk.ac.city.sbbc662.CSBT.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.city.sbbc662.CSBT.dao.HistoryRepository;
import uk.ac.city.sbbc662.CSBT.dao.UserRepository;
import uk.ac.city.sbbc662.CSBT.domain.LoginHistory;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class CSBTUserDetails implements UserDetailsService {

    private UserRepository userRepository;

    private HistoryRepository historyRepository;

    @Autowired
    public CSBTUserDetails(UserRepository userRepository, HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        uk.ac.city.sbbc662.CSBT.domain.User csbtUser = userRepository.findById(s).orElseThrow(()-> new UsernameNotFoundException("No matching user."));
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setEmail(csbtUser.getEmail());
        loginHistory.setTime(LocalDateTime.now());
        historyRepository.save(loginHistory);
        return null;
    }

    }

