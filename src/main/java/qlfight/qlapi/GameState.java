package qlfight.qlapi;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public enum GameState {

    ANY("any"), IN_PROGRESS("IN_PROGRESS"), POPULATED("POPULATED"), PRE_GAME("PRE_GAME"), EMPTY("EMPTY");

    public final String value;

    GameState(String value) {
        this.value = value;
    }

    public static GameState fromValue(String value) {
        if (ANY.value.equals(value)) return ANY;
        if (IN_PROGRESS.value.equals(value)) return IN_PROGRESS;
        if (POPULATED.value.equals(value)) return POPULATED;
        if (PRE_GAME.value.equals(value)) return PRE_GAME;
        if (EMPTY.value.equals(value)) return EMPTY;
        return null;
    }

    public static class Serializer extends JsonSerializer<GameState> {
        @Override
        public void serialize(GameState gameState, JsonGenerator gen, SerializerProvider serializers)
                throws IOException, JsonProcessingException {
            gen.writeString(gameState.value);
        }
    }

    public static class Deserializer extends JsonDeserializer<GameState> {
        @Override
        public GameState deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return fromValue(p.getText());
        }
    }

}
