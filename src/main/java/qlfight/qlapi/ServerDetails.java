package qlfight.qlapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.Instant;

public class ServerDetails extends Server {

    public final Integer ecode;
    public final Integer levelStartTime;
    public final ServerPlayer[] players;
    public final Integer roundTimeLimit;
    public final String mapTitle;
    public final String scoreLimit;
    public final String gameTypeTitle;
    public final Integer blueScore;
    public final Integer redScore;
    public final GameState gameState;
    public final Integer fragLimit;
    public final Integer captureLimit;
    public final Integer timeLimit;
    public final Integer roundLimit;

    public ServerDetails(
            @JsonProperty("num_players") Integer numPlayers,
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
            @JsonProperty("g_instagib") Boolean instagib,
            @JsonProperty("ECODE") Integer ecode,
            @JsonProperty("g_levelstarttime") Integer levelStartTime,
            @JsonProperty("byNames") ServerPlayer[] players,
            @JsonProperty("roundtimelimit") Integer roundTimeLimit,
            @JsonProperty("map_title") String mapTitle,
            @JsonProperty("scorelimit") String scoreLimit,
            @JsonProperty("game_type_title") String gameTypeTitle,
            @JsonProperty("g_bluescore") Integer blueScore,
            @JsonProperty("g_redscore") Integer redScore,
            @JsonProperty("g_gamestate") @JsonDeserialize(using=GameState.Deserializer.class) GameState gameState,
            @JsonProperty("fraglimit") Integer fragLimit,
            @JsonProperty("capturelimit") Integer captureLimit,
            @JsonProperty("timelimit") Integer timeLimit,
            @JsonProperty("roundlimit") Integer roundLimit) {
        super(numPlayers, map, publicId, ruleset, locationId, gameType, needPass, teamSize, owner, ranked, hostName,
                skillDelta, customSettings, premium, hostAddress, maxClients, numClients, instagib);
        this.ecode = ecode;
        this.levelStartTime = levelStartTime;
        this.players = players;
        this.roundTimeLimit = roundTimeLimit;
        this.mapTitle = mapTitle;
        this.scoreLimit = scoreLimit;
        this.gameTypeTitle = gameTypeTitle;
        this.blueScore = blueScore;
        this.redScore = redScore;
        this.gameState = gameState;
        this.fragLimit = fragLimit;
        this.captureLimit = captureLimit;
        this.timeLimit = timeLimit;
        this.roundLimit = roundLimit;
    }

    public String[] nonSpectatingPlayerNames() {
        String[] names = new String[players.length];
        for (int i = 0; 0 < players.length; i++) {
            ServerPlayer player = players[i];

            if (player.team != ServerTeam.Spectator)
                names[i] = player.name;
        }
        return names;
    }

    public Instant levelStartTime() {
        return Instant.ofEpochSecond(levelStartTime);
    }
}
