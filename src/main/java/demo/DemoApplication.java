package demo;

import javax.annotation.PostConstruct;

import demo.dao.TicketDao;
import demo.dao.TicketPriorityDao;
import demo.dao.TicketSourceDao;
import demo.dao.TicketStatusDao;
import demo.dao.TicketTypeDao;
import demo.entity.Ticket;
import demo.entity.enums.TicketPriority;
import demo.entity.enums.TicketPriorityEntity;
import demo.entity.enums.TicketSource;
import demo.entity.enums.TicketSourceEntity;
import demo.entity.enums.TicketStatus;
import demo.entity.enums.TicketStatusEntity;
import demo.entity.enums.TicketType;
import demo.entity.enums.TicketTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private TicketPriorityDao ticketPriorityDao;

	@Autowired
	private TicketSourceDao ticketSourceDao;

	@Autowired
	private TicketStatusDao ticketStatusDao;

	@Autowired
	private TicketTypeDao ticketTypeDao;

	@PostConstruct
	public void insertTicket() {
		for (TicketPriority ticketPriority: TicketPriority.values()) {
			ticketPriorityDao.save(new TicketPriorityEntity(ticketPriority.getId(), ticketPriority.getDescription()));
		}
		for (TicketStatus ticketStatus: TicketStatus.values()) {
			ticketStatusDao.save(new TicketStatusEntity(ticketStatus.getId(), ticketStatus.getDescription()));
		}
		for (TicketSource ticketSource : TicketSource.values()) {
			ticketSourceDao.save(new TicketSourceEntity(ticketSource.name(), ticketSource.getDescription()));
		}
		for (TicketType ticketType : TicketType.values()) {
			ticketTypeDao.save(new TicketTypeEntity(ticketType.ordinal(), ticketType.getDescription()));
		}

		Ticket ticket = new Ticket();
		ticket.setPriority(TicketPriority.NM);
		ticket.setSource(TicketSource.EX);
		ticket.setStatus(TicketStatus.RS);
		ticket.setType(TicketType.SL);
		ticketDao.save(ticket);
	}
}
