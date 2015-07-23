package qlfight.models;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import justweb.models.Model;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

public class MatchInProgress extends Model {

    public static final String JP_SERVER_ID = "serverId";
    public static final String JP_LEVEL_START_TIME = "levelStartTime";
    public static final String JP_PLAYER_NAMES = "playerNames";

    public final Integer serverId;
    public final Integer levelStartTime;
    public final String[] playerNames;

    public MatchInProgress(ObjectId id, Integer serverId, Integer levelStartTime, String[] playerNames) {
        super(id);
        this.serverId = serverId;
        this.levelStartTime = levelStartTime;
        this.playerNames = playerNames;
    }

    public Instant levelStartTime() {
        return Instant.ofEpochSecond(levelStartTime);
    }

    public LocalDateTime levelStartTimeAsDateTime() {
        return LocalDateTime.ofInstant(levelStartTime(), ZoneId.systemDefault());
    }

    public static MatchInProgress fromMongoDoc(Document doc) {
        final ObjectId id = doc.getObjectId(MatchInProgress.JP_ID);
        final Integer serverId = doc.getInteger(JP_SERVER_ID);
        final Integer levelStartTime = doc.getInteger(JP_LEVEL_START_TIME);
        return new MatchInProgress(id, serverId, levelStartTime, null);
    }

    @Override
    public Document toMongoDoc() {
        Document doc = super.toMongoDoc();
        doc.append(JP_SERVER_ID, serverId);
        doc.append(JP_LEVEL_START_TIME, levelStartTime);
        doc.append(JP_PLAYER_NAMES, playerNames);
        return doc;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final MatchInProgress other = (MatchInProgress) obj;
        return Objects.equal(serverId, other.serverId)
                && Objects.equal(levelStartTime, other.levelStartTime)
                && Arrays.deepEquals(playerNames, other.playerNames);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(serverId, levelStartTime, playerNames);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("serverId", serverId)
                .add("levelStartTime", levelStartTime)
                .add("playersNames", playerNames)
                .toString();
    }
}
