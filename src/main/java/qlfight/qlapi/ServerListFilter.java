package qlfight.qlapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

public class ServerListFilter {

    public ServerListFilter(GameType gameType) {
        gameTypes = new GameType[]{gameType};
        filters.gameType = gameType;
    }

    public Filters filters = new Filters();
    @JsonProperty("arena_type")
    public String arenaType = "";
    public String[] players = new String[]{};
    @JsonProperty("game_types")
    @JsonSerialize(using = GameTypesSerializer.class)
    public GameType[] gameTypes = null;
    public Integer ig = 0;
    @JsonProperty("premium_only")
    public Integer premiumOnly = 0;

    public class Filters {
        public String group = "any";
        @JsonProperty("game_type")
        @JsonSerialize(using = GameTypeSerializer.class)
        public GameType gameType = null;
        public String arena = "any";
        @JsonSerialize(using = GameStateSerializer.class)
        public GameState state = GameState.ANY;
        public String difficulty = "any";
        @JsonSerialize(using = LocationSerializer.class)
        public Location location = Location.ALL;
        @JsonProperty("private")
        public String private_ = "0";
        @JsonProperty("invitation_only")
        public Integer invitationOnly = 0;
        public String ranked = "any";
        @JsonProperty("premium_only")
        public Integer premiumOnly = 0;
    }

    public enum Location {
        ALL("ALL"), AFRICA("Africa"), EUROPE("Europe"), ASIA("Asia"), NORTH_AMERICA("North America"),
        SOUTH_AMERICA("South America"), OCEANIA("Oceania");

        public final String value;

        Location(String value) {
            this.value = value;
        }
    }

    public static class LocationSerializer extends JsonSerializer<ServerListFilter.Location> {
        @Override
        public void serialize(ServerListFilter.Location location, JsonGenerator gen, SerializerProvider serializers)
                throws IOException, JsonProcessingException {
            gen.writeString(location.value);
        }
    }

    public enum GameType {
        FFA(0, "2"), CA(4, "4"), CTF(5, "3"), TDM(3, "6"), DUEL(1, "7"), DOM(10, "15"), ONEFCTF(6, "16"), AD(11, "18"),
        FT(9, "5"), HAR(8, "17"), RACE(2, "25"), RR(12, "19");

        public final int outerValue;
        public final String innerValue;

        GameType(int outerValue, String innerValue) {
            this.outerValue = outerValue;
            this.innerValue = innerValue;
        }
    }

    public static class GameTypesSerializer extends JsonSerializer<GameType[]> {
        @Override
        public void serialize(GameType[] gameTypes, JsonGenerator gen, SerializerProvider serializers)
                throws IOException, JsonProcessingException {
            gen.writeStartArray();

            for (int i=0; i<gameTypes.length; i++) {
                GameType gameType = gameTypes[i];
                gen.writeNumber(gameType.outerValue);
            }

            gen.writeEndArray();
        }
    }

    public static class GameTypeSerializer extends JsonSerializer<ServerListFilter.GameType> {
        @Override
        public void serialize(ServerListFilter.GameType gameType, JsonGenerator gen, SerializerProvider serializers)
                throws IOException, JsonProcessingException {
            gen.writeString(gameType.innerValue);
        }
    }

    public enum GameState {
        ANY("any"), IN_PROGRESS("IN_PROGRESS");

        public final String value;

        GameState(String value) {
            this.value = value;
        }
    }

    public static class GameStateSerializer extends JsonSerializer<GameState> {
        @Override
        public void serialize(ServerListFilter.GameState gameState, JsonGenerator gen, SerializerProvider serializers)
                throws IOException, JsonProcessingException {
            gen.writeString(gameState.value);
        }
    }
}
