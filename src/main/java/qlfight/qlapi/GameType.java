package qlfight.qlapi;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public enum GameType {

    FFA(0, "2", "ffa"),
    CA(4, "4", "ca"),
    CTF(5, "3", "ctf"),
    TDM(3, "6", "tdm"),
    DUEL(1, "7", "duel"),
    DOM(10, "15", "dom"),
    ONEFCTF(6, "16", "1f-ctf"),
    AD(11, "18", "ad"),
    FT(9, "5", "ft"),
    HAR(8, "17", "har"),
    RACE(2, "25", "race"),
    RR(12, "19", "rr");

    public final int intValue;
    public final String stringValue;
    public final String name;

    GameType(int intValue, String stringValue, String name) {
        this.intValue = intValue;
        this.stringValue = stringValue;
        this.name = name;
    }

    public static GameType fromIntValue(int value) {
        if (FFA.intValue == value) return FFA;
        if (CA.intValue == value) return CA;
        if (CTF.intValue == value) return CTF;
        if (TDM.intValue == value) return TDM;
        if (DUEL.intValue == value) return DUEL;
        if (DOM.intValue == value) return DOM;
        if (ONEFCTF.intValue == value) return ONEFCTF;
        if (AD.intValue == value) return AD;
        if (FT.intValue == value) return FT;
        if (HAR.intValue == value) return HAR;
        if (RACE.intValue == value) return RACE;
        if (RR.intValue == value) return RR;
        return null;
    }

    public static class IntValuesSerializer extends JsonSerializer<GameType[]> {
        @Override
        public void serialize(GameType[] gameTypes, JsonGenerator gen, SerializerProvider serializers)
                throws IOException, JsonProcessingException {
            gen.writeStartArray();

            for (int i=0; i<gameTypes.length; i++) {
                GameType gameType = gameTypes[i];
                gen.writeNumber(gameType.intValue);
            }

            gen.writeEndArray();
        }
    }

    public static class IntValueSerializer extends JsonSerializer<GameType> {
        @Override
        public void serialize(GameType gameType, JsonGenerator gen, SerializerProvider serializers)
                throws IOException, JsonProcessingException {
            gen.writeString(gameType.stringValue);
        }
    }

    public static class IntValueDeserializer extends JsonDeserializer<GameType> {
        @Override
        public GameType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return GameType.fromIntValue(p.getIntValue());
        }
    }
}
