package demo.dao;

import demo.entity.enums.TicketTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketTypeDao extends JpaRepository<TicketTypeEntity, Integer> {
}
