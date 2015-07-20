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
    @JsonSerialize(using = GameType.IntValuesSerializer.class)
    public GameType[] gameTypes = null;
    public Integer ig = 0;
    @JsonProperty("premium_only")
    public Integer premiumOnly = 0;

    public class Filters {
        public String group = "any";
        @JsonProperty("game_type")
        @JsonSerialize(using = GameType.IntValueSerializer.class)
        public GameType gameType = null;
        public String arena = "any";
        @JsonSerialize(using = GameState.Serializer.class)
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
}
