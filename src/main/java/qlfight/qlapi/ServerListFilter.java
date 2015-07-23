package qlfight.qlapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ServerListFilter {

    public ServerListFilter() {
    }

    public GameType[] gameTypes() {
        return gameTypes;
    }

    public void gameType(GameType gameType) {
        gameTypes = new GameType[] { gameType };
        filters.gameType = gameType;
    }

    public Filters filters = new Filters();
    @JsonProperty("arena_type")
    public String arenaType = "";
    public String[] players = new String[]{};
    @JsonProperty("game_types")
    @JsonSerialize(using = GameType.IntValuesSerializer.class)
    private GameType[] gameTypes;
    public Integer ig = 0;
    @JsonProperty("premium_only")
    public Integer premiumOnly = 0;

    public class Filters {
        public String group = "any";
        @JsonProperty("game_type")
        @JsonSerialize(using = GameType.IntValueSerializer.class)
        private GameType gameType = null;
        public String arena = "any";
        @JsonSerialize(using = GameState.Serializer.class)
        public GameState state = GameState.ANY;
        public String difficulty = "any";
        @JsonSerialize(using = Location.Serializer.class)
        public Location location = Location.ALL;
        @JsonProperty("private")
        public String private_ = "0";
        @JsonProperty("invitation_only")
        public Integer invitationOnly = 0;
        public String ranked = "any";
        @JsonProperty("premium_only")
        public Integer premiumOnly = 0;

        public GameType gameType() {
            return filters.gameType;
        }
    }
}
