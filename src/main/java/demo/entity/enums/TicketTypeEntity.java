package demo.entity.enums;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ticket_type")
public class TicketTypeEntity {
	@Id
	private int id;
	@Length(max = 256)
	private String description;

	public TicketTypeEntity() {
	}

	public TicketTypeEntity(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
