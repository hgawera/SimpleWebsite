package uk.ac.city.sbbc662.CSBT.services;
import uk.ac.city.sbbc662.CSBT.domain.CollatedUser;

public interface ProfileService {

    CollatedUser getProfile(String email);
}
