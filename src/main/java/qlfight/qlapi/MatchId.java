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

    public String url() {
        return url;
    }

    public enum GameType {
        DUEL("duel");

        public final String value;
        GameType(String value) {
            this.value = value;
        }

        public static GameType fromString(String value) {
            if (DUEL.value.equals(value)) return DUEL;
            return null;
        }
    }

}
