package qlfight.managers;

import co.paralleluniverse.fibers.Suspendable;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qlfight.daos.PlayerDao;
import qlfight.daos.TourneyDao;
import qlfight.models.Player;
import qlfight.qlapi.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class TourneyManager {

    private final QlApiService ql;
    private final PlayerManager playerManager;
    private final TourneyDao tourneyDao;
    private final PlayerDao playerDao;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public TourneyManager(QlApiService ql, PlayerManager playerManager, TourneyDao tourneyDao, PlayerDao playerDao) {
        this.ql = ql;
        this.playerManager = playerManager;
        this.tourneyDao = tourneyDao;
        this.playerDao = playerDao;
    }

    @Suspendable
    public List<Player> collectPlayers(GameType gameType, Location location) {
        ServerList list = null;
        try {
            ServerListFilter filter = new ServerListFilter();
            filter.gameType(gameType);
            filter.filters.location = location;
            filter.filters.state = GameState.POPULATED;
            list = ql.serverList(filter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        Integer[] serverIds = new Integer[list.servers.length];
        for (int i = 0; i < list.servers.length; i++)
            serverIds[i] = list.servers[i].publicId;

        ServerDetails[] allDetails = null;
        try {
            allDetails = ql.serverDetails(serverIds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        Set<String> currentPlayers = new HashSet<>();
        for (ServerDetails details : allDetails) {
            for (ServerPlayer player : details.players) {
                currentPlayers.add(player.name);
            }
        }

        log.info("Current players on servers: {}", Joiner.on(", ").join(currentPlayers));

        List<Player> signedUpPlayers = new ArrayList<>();
        Set<String> signedUpPlayerNames = new HashSet<>(signedUpPlayers.size() + 1, 1);
        for (Player signedUp : signedUpPlayers) {
            signedUpPlayerNames.add(signedUp.name);
        }
        currentPlayers.removeAll(signedUpPlayerNames);

        log.info("Already signed up players: {}", Joiner.on(", ").join(signedUpPlayerNames));

        List<Player> registeredPlayers = playerDao.byNames(currentPlayers);
        for (Player registered : registeredPlayers) {
            currentPlayers.remove(registered.name);
            playerManager.initGameType(registered, gameType);
        }

        for (String unregistered : currentPlayers) {
            Player registered = playerManager.register(unregistered);
            registered = playerManager.initGameType(registered, gameType);
            registeredPlayers.add(registered);
        }

        signedUpPlayers.addAll(registeredPlayers);
        return signedUpPlayers;
    }

}
