package qlfight.managers;

import co.paralleluniverse.fibers.Suspendable;
import qlfight.daos.MatchInProgressDao;
import qlfight.models.MatchInProgress;
import qlfight.qlapi.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class ScheduleManager {

    private final QlApiService ql;
    private final MatchInProgressDao dao;

    public ScheduleManager(QlApiService ql, MatchInProgressDao dao) {
        this.ql = ql;
        this.dao = dao;
    }

    @Suspendable
    public void gatherCurrentPlayers() {
        ServerList list = null;

        try {
            ServerListFilter filter = new ServerListFilter(GameType.DUEL);
            filter.filters.state = GameState.IN_PROGRESS;
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

        Set<MatchInProgress> current = new HashSet<>(allDetails.length, 1);
        for (ServerDetails details : allDetails) {
            MatchInProgress item = new MatchInProgress(details.publicId, details.levelStartTime,
                    details.nonSpectatingPlayerNames());
            current.add(item);
        }

        MatchInProgress[] stored = dao.all();

        List<MatchInProgress> finished = new ArrayList<>();
        for (MatchInProgress storedMatch : stored) {
            if (! current.contains(storedMatch)) {
                finished.add(storedMatch);
            }
        }
    }

}
