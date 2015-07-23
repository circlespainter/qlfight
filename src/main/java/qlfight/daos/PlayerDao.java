package qlfight.daos;

import co.paralleluniverse.fibers.Suspendable;
import com.mongodb.client.model.Projections;
import justweb.dao.Dao;
import justweb.services.MongoService;
import org.bson.Document;
import org.bson.types.ObjectId;
import qlfight.models.Player;
import qlfight.models.PlayerGameType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerDao extends Dao<Player> {

    public PlayerDao(MongoService mongo) {
        super(mongo);
    }

    @Override
    public String collection() {
        return "player";
    }

    @Override
    public Player fromMongoDoc(Document doc) {
        return Player.fromMongoDoc(doc);
    }

    @Suspendable
    public List<Player> byNames(Collection<String> playerNames) {
        Document filter = new Document(Player.JP_NAME, new Document("$in", playerNames));
        return fromMongoList(mongo.find(collection(), filter));
    }

    @Suspendable
    public Player byName(String name) {
        return fromMongoDoc(mongo.findOne(collection(), new Document(Player.JP_NAME, name)));
    }

    @Suspendable
    public List<String> namesById(Collection<ObjectId> playerIds) {
        Document filter = new Document(Player.JP_ID, new Document("$in", playerIds));
        List<Document> result = mongo.find(collection(), filter, Projections.include(Player.JP_NAME));

        List<String> names = new ArrayList<>(result.size());
        for (Document doc : result)
            names.add(doc.getString("name"));

        return names;
    }

    @Suspendable
    public void addGameType(Player player, PlayerGameType gameType) {
        update(player, new Document("$push", new Document(Player.JP_GAME_TYPES, gameType.toMongoDoc())));
    }
}
