package demo.dao;

import demo.entity.enums.TicketSourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketSourceDao extends JpaRepository<TicketSourceEntity, String> {
}
