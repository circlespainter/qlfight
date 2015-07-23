package qlfight.qlapi;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public enum Location {

    ALL("ALL"), AFRICA("Africa"), EUROPE("Europe"), ASIA("Asia"), NORTH_AMERICA("North America"),
    SOUTH_AMERICA("South America"), OCEANIA("Oceania");

    public final String value;

    Location(String value) {
        this.value = value;
    }

    public static Location fromValue(String value) {
        if (ALL.value.equals(value)) return ALL;
        if (AFRICA.value.equals(value)) return AFRICA;
        if (EUROPE.value.equals(value)) return EUROPE;
        if (ASIA.value.equals(value)) return ASIA;
        if (NORTH_AMERICA.value.equals(value)) return NORTH_AMERICA;
        if (SOUTH_AMERICA.value.equals(value)) return SOUTH_AMERICA;
        if (OCEANIA.value.equals(value)) return OCEANIA;
        return null;
    }

    public static class Serializer extends JsonSerializer<Location> {
        @Override
        public void serialize(Location location, JsonGenerator gen, SerializerProvider serializers)
                throws IOException, JsonProcessingException {
            gen.writeString(location.value);
        }
    }
}
