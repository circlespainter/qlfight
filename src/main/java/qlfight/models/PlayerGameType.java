package qlfight.models;

import org.bson.Document;
import qlfight.managers.PlayerManager;
import qlfight.qlapi.GameType;

public class PlayerGameType {

    public static final String JP_GAME_TYPE = "gameType";
    public static final String JP_ELO = "elo";

    public final GameType gameType;
    private int elo;

    public PlayerGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public int elo() {
        return elo;
    }

    public void elo(int elo) {
        this.elo = elo;
    }

    public Document toMongoDoc() {
        Document doc = new Document();
        doc.append(JP_GAME_TYPE, gameType.name);
        doc.append(JP_ELO, elo);
        return doc;
    }

    public static PlayerGameType fromMongoDoc(Document doc) {
        final GameType gameType = GameType.fromName(doc.getString(JP_GAME_TYPE));
        final Integer elo = doc.getInteger(JP_ELO, PlayerManager.INITIAL_ELO);

        PlayerGameType playerGameType = new PlayerGameType(gameType);
        playerGameType.elo(elo);
        return playerGameType;
    }

}
