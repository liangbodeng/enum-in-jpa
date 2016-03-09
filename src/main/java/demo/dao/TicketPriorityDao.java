package demo.dao;

import demo.entity.enums.TicketPriorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketPriorityDao extends JpaRepository<TicketPriorityEntity, String> {
}
