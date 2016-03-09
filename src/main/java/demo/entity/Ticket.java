package demo.entity;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import demo.entity.enums.TicketPriority;
import demo.entity.enums.TicketPriorityConverter;
import demo.entity.enums.TicketPriorityEntity;
import demo.entity.enums.TicketSource;
import demo.entity.enums.TicketSourceEntity;
import demo.entity.enums.TicketStatus;
import demo.entity.enums.TicketStatusConverter;
import demo.entity.enums.TicketStatusEntity;
import demo.entity.enums.TicketType;
import demo.entity.enums.TicketTypeEntity;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// Use converter so we can use customized mapping
	// TicketPriority <-> TicketPriority.getId() as string
	@Convert(converter = TicketPriorityConverter.class)
	private TicketPriority priority;

	// I think usually this is the best approach
	// TicketSource <-> TicketSource.name()
	@Enumerated(EnumType.STRING)
	private TicketSource source;

	// Without converter, we can't map it to custom integers, or types other than string/integer
	// TicketStatus <-> TicketStatus.getId() as integer
	@Convert(converter = TicketStatusConverter.class)
	private TicketStatus status;

	// By default, enum is mapped to their ordinal (integer that is)
	// Fragile, NOT recommended
	// TicketType <-> TicketType.ordinal()
	private TicketType type;

	// The fields below are for foreign key generation only
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "priority", updatable = false, insertable = false)
	private TicketPriorityEntity priorityEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source", updatable = false, insertable = false)
	private TicketSourceEntity sourceEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status", updatable = false, insertable = false)
	private TicketStatusEntity statusEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type", updatable = false, insertable = false)
	private TicketTypeEntity typeEntity;

	public Ticket() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TicketPriority getPriority() {
		return priority;
	}

	public void setPriority(TicketPriority priority) {
		this.priority = priority;
	}

	public TicketSource getSource() {
		return source;
	}

	public void setSource(TicketSource source) {
		this.source = source;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public TicketType getType() {
		return type;
	}

	public void setType(TicketType type) {
		this.type = type;
	}
}
