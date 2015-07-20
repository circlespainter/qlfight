package qlfight.qlapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Server {

    public final Integer numPlayers;
    public final String map;
    public final Integer publicId;
    public final String ruleset;
    public final Integer locationId;
    public final GameType gameType;
    public final Boolean needPass;
    public final Integer teamSize;
    public final String owner;
    public final Boolean ranked;
    public final String hostName;
    public final Integer skillDelta;
    public final String customSettings;
    public final Boolean premium;
    public final String hostAddress;
    public final Integer maxClients;
    public final Integer numClients;
    public final Boolean instagib;

    public Server(@JsonProperty("num_players") Integer numPlayers,
                  @JsonProperty("map") String map,
                  @JsonProperty("public_id") Integer publicId,
                  @JsonProperty("ruleset") String ruleset,
                  @JsonProperty("location_id") Integer locationId,
                  @JsonProperty("game_type") @JsonDeserialize(using=GameType.IntValueDeserializer.class) GameType gameType,
                  @JsonProperty("g_needpass") Boolean needPass,
                  @JsonProperty("teamsize") Integer teamSize,
                  @JsonProperty("owner") String owner,
                  @JsonProperty("ranked") Boolean ranked,
                  @JsonProperty("host_name") String hostName,
                  @JsonProperty("skillDelta") Integer skillDelta,
                  @JsonProperty("g_customSettings") String customSettings,
                  @JsonProperty("premium") Boolean premium,
                  @JsonProperty("host_address") String hostAddress,
                  @JsonProperty("max_clients") Integer maxClients,
                  @JsonProperty("num_clients") Integer numClients,
                  @JsonProperty("g_instagib") Boolean instagib) {
        this.numPlayers = numPlayers;
        this.map = map;
        this.publicId = publicId;
        this.ruleset = ruleset;
        this.locationId = locationId;
        this.gameType = gameType;
        this.needPass = needPass;
        this.teamSize = teamSize;
        this.owner = owner;
        this.ranked = ranked;
        this.hostName = hostName;
        this.skillDelta = skillDelta;
        this.customSettings = customSettings;
        this.premium = premium;
        this.hostAddress = hostAddress;
        this.maxClients = maxClients;
        this.numClients = numClients;
        this.instagib = instagib;
    }
}
