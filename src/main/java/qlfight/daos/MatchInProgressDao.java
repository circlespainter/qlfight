package qlfight.daos;

import justweb.dao.Dao;
import justweb.services.MongoService;
import org.bson.Document;
import qlfight.models.MatchInProgress;

public class MatchInProgressDao extends Dao<MatchInProgress> {

    protected MatchInProgressDao(MongoService mongo) {
        super(mongo);
    }

    @Override
    public String collection() {
        return "watchList";
    }

    @Override
    public MatchInProgress fromMongoDoc(Document doc) {
        return MatchInProgress.fromMongoDoc(doc);
    }
}
