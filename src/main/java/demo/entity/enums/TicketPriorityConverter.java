package demo.entity.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TicketPriorityConverter implements AttributeConverter<TicketPriority, String> {
	@Override
	public String convertToDatabaseColumn(TicketPriority attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getId();
	}

	@Override
	public TicketPriority convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		for (TicketPriority ticketPriority : TicketPriority.values()) {
			if (ticketPriority.getId().equals(dbData)) {
				return ticketPriority;
			}
		}
		return null;
	}
}
