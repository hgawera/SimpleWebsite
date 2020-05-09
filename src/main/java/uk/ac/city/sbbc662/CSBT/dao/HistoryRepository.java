package uk.ac.city.sbbc662.CSBT.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.city.sbbc662.CSBT.domain.LoginHistory;

@Repository
public interface HistoryRepository extends JpaRepository<LoginHistory, String> {
}
