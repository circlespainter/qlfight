package qlfight.daos;

import co.paralleluniverse.fibers.Suspendable;
import justweb.dao.Dao;
import justweb.services.MongoService;
import org.bson.Document;
import qlfight.models.Player;
import qlfight.models.Tourney;

import java.util.ArrayList;
import java.util.List;

public class TourneyDao extends Dao<Tourney> {
    public TourneyDao(MongoService mongo) {
        super(mongo);
    }

    @Override
    public String collection() {
        return "tourney";
    }

    @Override
    public Tourney fromMongoDoc(Document doc) {
        return Tourney.fromMongoDoc(doc);
    }

    @Suspendable
    public void addPlayers(Tourney tourney, List<Player> players) {
        List<String> playerNames = new ArrayList<>(players.size());
        for (Player player : players)
            playerNames.add(player.name);
        update(tourney, new Document("$push", new Document(Tourney.JP_PLAYERS, playerNames)));
    }

}
