package qlfight.qlapi;

public class MatchId {

    public final String publicId;
    public final String gameType;
    public final String oldEid;

    private final String url;

    public MatchId(String publicId, String gameType, String oldEid) {
        this.publicId = publicId;
        this.gameType = gameType;
        this.oldEid = oldEid;

        this.url = publicId + "/" + gameType + (oldEid != null ? ("/" + oldEid) : "");
    }

    public MatchId(String publicId, GameType gameType, String oldEid) {
        this(publicId, gameType.name, oldEid);
    }

    public String url() {
        return url;
    }
}
