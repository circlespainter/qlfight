package qlfight.qlapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServerList {

    public final Integer lfgRequests;
    public final Integer matchesPlayed;
    public final Server[] servers;

    public ServerList(@JsonProperty("lfg_requests") Integer lfgRequests,
                      @JsonProperty("matches_played") Integer matchesPlayed,
                      @JsonProperty("servers") Server[] servers) {
        this.lfgRequests = lfgRequests;
        this.matchesPlayed = matchesPlayed;
        this.servers = servers;
    }
}
