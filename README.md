# How to use enum fields in JPA entity

## What is this?

This is a demo of how to use enum fields in JPA entity. There are 3 approaches taken.

### @Enumerated(EnumType.ORDINAL)

- This is the default mapping. Fragile, NOT recommended.
- You can't switch the order of the enum values without potentially damaging the data.
- The mapping is E <-> E.ordinal()

### @Enumerated(EnumType.STRING)

- IMHO, this is usually the best approach. Simple, Flexible.
- The mapping is E <-> E.name()

### Use a Converter that implements AttributeConverter<E, FieldType>

- This is the most flexible way, and definitely not simple.
- You can map it to pretty much any type of DB field.
- The mapping is E <- converter -> FieldType

## Tech Stack

- Spring Boot
- Spring Data JPA
- Spring Web

## How to run it

- Run the command: gradle clean build bootRun
- Open following URL in a browser: http://localhost:8080/h2-console
- Change the JDBC URL to: jdbc:h2:mem:testdb
- Click Connect to log in, and then examine the single row in the Ticket table

## Notes

- It's always a good idea to have a table for each Enum type, so foreign key can be created to reference it.
- It's not easy to directly use an Enum type as a JPA entity mapping to a table.
- We can create a separate entity class, and then use a private field without property accessors to reference it.
- I have a preference for the mapping of Enum <-> 2-char string.
