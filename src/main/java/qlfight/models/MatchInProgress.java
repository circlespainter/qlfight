package qlfight.models;

import justweb.models.Model;
import org.bson.Document;

public class MatchInProgress extends Model {

    public static final String JP_SERVER_ID = "serverId";
    public static final String JP_LEVEL_START_TIME = "levelStartTime";
    public static final String JP_PLAYER_NAMES = "playerNames";

    public final Integer serverId;
    public final Integer levelStartTime;
    public final String[] playerNames;

    public MatchInProgress(Integer serverId, Integer levelStartTime, String[] playerNames) {
        this.serverId = serverId;
        this.levelStartTime = levelStartTime;
        this.playerNames = playerNames;
    }

    public static MatchInProgress fromMongoDoc(Document doc) {
        final Integer serverId = doc.getInteger(JP_SERVER_ID);
        final Integer levelStartTime = doc.getInteger(JP_LEVEL_START_TIME);
        return new MatchInProgress(serverId, levelStartTime, null);
    }

    @Override
    public Document toMongoDoc() {
        Document doc = super.toMongoDoc();
        doc.append(JP_SERVER_ID, serverId);
        doc.append(JP_LEVEL_START_TIME, levelStartTime);
        doc.append(JP_PLAYER_NAMES, playerNames);
        return doc;
    }
}
