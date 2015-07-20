package qlfight.qlapi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public enum ServerTeam {

    Playing(0),
    Spectator(3);

    public final int value;
    ServerTeam(int value) {
        this.value = value;
    }

    public static ServerTeam fromValue(int value) {
        if (Playing.value == value) return Playing;
        if (Spectator.value == value) return Spectator;
        return null;
    }

    public class Deserializer extends JsonDeserializer<ServerTeam> {
        @Override
        public ServerTeam deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return ServerTeam.fromValue(p.getIntValue());
        }
    }
}
