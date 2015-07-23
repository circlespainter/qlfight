package qlfight.managers;

import co.paralleluniverse.fibers.Suspendable;
import justweb.AppException;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qlfight.daos.PlayerDao;
import qlfight.models.Player;
import qlfight.models.PlayerGameType;
import qlfight.qlapi.GameType;
import qlfight.services.QlRanksService;

public class PlayerManager {

    public static final int INITIAL_ELO = 1200;

    private final PlayerDao dao;
    private final QlRanksService qlRanks;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public PlayerManager(PlayerDao dao, QlRanksService qlRanks) {
        this.dao = dao;
        this.qlRanks = qlRanks;
    }

    @Suspendable
    public Player register(String name) {
        Player player = dao.byName(name);
        if (player != null)
            throw new AppException(String.format("Player '%s' is already registered.", name));

        player = new Player(ObjectId.get(), name);
        dao.insert(player);
        return player;
    }

    @Suspendable
    public Player initGameType(Player player, GameType gameType) {
        log.info("Initializing game type '{}' for player: {}", gameType.name, player);
        if (player.gameType(gameType) != null) {
            log.info("Game type already initialized, exiting.");
            return player;
        }

        int elo = INITIAL_ELO;

        QlRanksService.GameType ranksGameType = QlRanksService.GameType.fromQl(gameType);
        if (ranksGameType != null) {
            elo = qlRanks.elo(ranksGameType, player.name);
        }
        else {
            log.info("No QlRanks elo available for game type: {}", gameType.name);
        }

        PlayerGameType playerGameType = new PlayerGameType(gameType);
        playerGameType.elo(elo);
        player.gameTypes.add(playerGameType);
        dao.addGameType(player, playerGameType);
        return player;
    }

}
