package demo.entity.enums;

public enum TicketSource {
	IN("Internal"),
	EX("External");

	private String description;

	TicketSource(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
