package demo.entity.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TicketStatusConverter implements AttributeConverter<TicketStatus, Integer> {
	@Override
	public Integer convertToDatabaseColumn(TicketStatus attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getId();
	}

	@Override
	public TicketStatus convertToEntityAttribute(Integer dbData) {
		if (dbData == null) {
			return null;
		}
		for (TicketStatus ticketStatus : TicketStatus.values()) {
			if (ticketStatus.getId() == dbData) {
				return ticketStatus;
			}
		}
		return null;
	}
}
