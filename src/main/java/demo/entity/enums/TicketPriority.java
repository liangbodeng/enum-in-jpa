package demo.entity.enums;

public enum TicketPriority {
	NM("NM", "Normal"),
	UG("UG", "Urgent");

	private String id;
	private String description;

	TicketPriority(String id, String description) {
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
}
