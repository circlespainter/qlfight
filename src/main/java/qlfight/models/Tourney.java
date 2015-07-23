package qlfight.models;

import justweb.models.Model;
import org.bson.Document;
import org.bson.types.ObjectId;
import qlfight.qlapi.GameType;
import qlfight.qlapi.Location;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tourney extends Model {

    public static final String JP_LOCATION = "location";
    public static final String JP_GAME_TYPE = "gameType";
    public static final String JP_STARTING_TIME = "startingTime";
    public static final String JP_PLAYERS = "players";

    public final Location location;
    public final GameType gameType;
    public final LocalDateTime startingTime;
    public final List<String> players = new ArrayList<>();

    public Tourney(ObjectId id, Location location, GameType gameType, LocalDateTime startingTime) {
        super(id);
        this.location = location;
        this.gameType = gameType;
        this.startingTime = startingTime;
    }

    @Override
    public Document toMongoDoc() {
        Document doc = super.toMongoDoc();
        doc.append(JP_LOCATION, location.value);
        doc.append(JP_GAME_TYPE, gameType.name);
        doc.append(JP_STARTING_TIME, startingTime);
        doc.append(JP_PLAYERS, players);
        return doc;
    }

    public static Tourney fromMongoDoc(Document doc) {
        if (doc == null)
            return null;

        final ObjectId id = doc.getObjectId(JP_ID);
        final Location region = Location.fromValue(doc.getString(JP_LOCATION));
        final GameType gameType = GameType.fromName(doc.getString(JP_GAME_TYPE));
        final LocalDateTime startingTime = (LocalDateTime) doc.get(JP_STARTING_TIME);

        Tourney tourney = new Tourney(id, region, gameType, startingTime);
        return tourney;
    }
}
