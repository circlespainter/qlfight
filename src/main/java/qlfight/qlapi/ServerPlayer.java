package qlfight.qlapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ServerPlayer {

    public final String clan;
    public final Integer score;
    public final Integer subLevel;
    public final String name;
    public final ServerTeam team;
    public final String model;
    public final Boolean bot;
    public final Integer rank;

    public ServerPlayer(@JsonProperty("clan") String clan,
                        @JsonProperty("score") Integer score,
                        @JsonProperty("sub_level") Integer subLevel,
                        @JsonProperty("name") String name,
                        @JsonProperty("team") @JsonDeserialize(using=ServerTeam.Deserializer.class) ServerTeam team,
                        @JsonProperty("model") String model,
                        @JsonProperty("bot") Boolean bot,
                        @JsonProperty("rank") Integer rank) {
        this.clan = clan;
        this.score = score;
        this.subLevel = subLevel;
        this.name = name;
        this.team = team;
        this.model = model;
        this.bot = bot;
        this.rank = rank;
    }
}
