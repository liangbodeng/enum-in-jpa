package demo.dao;

import demo.entity.enums.TicketStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketStatusDao extends JpaRepository<TicketStatusEntity, Integer> {
}
