package team.sun.integration.config.date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (localDateTime == null) {
            throw new IOException("OffsetDateTime argument is null.");
        }
        jsonGenerator.writeString(DateTimeFormatter.RFC_1123_DATE_TIME.format(OffsetDateTime.of(localDateTime, ZoneOffset.UTC)));
    }
}
