package demo.entity.enums;

public enum TicketStatus {
	PD(10, "Pending"),
	IP(20, "In Progress"),
	RS(99, "Resolved");

	private int id;
	private String description;

	TicketStatus(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
}
