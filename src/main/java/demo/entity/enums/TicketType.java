package demo.entity.enums;

public enum TicketType {
	GL("General"),
	BL("Billing"),
	SL("Sales"),
	TS("Technical Support");

	private String description;

	TicketType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
