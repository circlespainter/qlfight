package qlfight.models;

import co.paralleluniverse.fibers.Suspendable;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import justweb.models.Model;
import org.bson.Document;
import org.bson.types.ObjectId;
import qlfight.qlapi.GameType;

import java.util.ArrayList;
import java.util.List;

public class Player extends Model {

    public static final String JP_NAME = "name";
    public static final String JP_GAME_TYPES = "gameTypes";

    public final String name;
    public final List<PlayerGameType> gameTypes = new ArrayList<>();

    public Player(ObjectId id, String name) {
        super(id);
        this.name = name;
    }

    public PlayerGameType gameType(GameType gameType) {
        for (PlayerGameType playerGameType : gameTypes)
            if (playerGameType.gameType == gameType)
                return playerGameType;
        return null;
    }

    @Override
    public Document toMongoDoc() {
        Document doc = super.toMongoDoc();
        doc.append(JP_NAME, name);
        doc.append(JP_GAME_TYPES, gameTypes);
        return doc;
    }

    @Suspendable
    public static Player fromMongoDoc(Document doc) {
        if (doc == null)
            return null;

        Player player = new Player(doc.getObjectId(Player.JP_ID), doc.getString(Player.JP_NAME));

        List<Document> gameTypes = (List<Document>) doc.get(JP_GAME_TYPES);
        for (Document gameTypeDoc : gameTypes)
            player.gameTypes.add(PlayerGameType.fromMongoDoc(gameTypeDoc));

        return player;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Player other = (Player) obj;
        return Objects.equal(id, other.id)
                && Objects.equal(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name);
    }
}
