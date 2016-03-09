package demo.entity.enums;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ticket_source")
public class TicketSourceEntity {
	@Id
	@Length(min = 2, max = 2)
	private String id;
	@Length(max = 256)
	private String description;

	public TicketSourceEntity() {
	}

	public TicketSourceEntity(String id, String description) {
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
