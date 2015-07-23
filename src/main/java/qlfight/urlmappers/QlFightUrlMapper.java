package qlfight.urlmappers;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.fibers.Suspendable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import justweb.urlmapper.RestUrlMapper;
import org.bson.types.ObjectId;
import qlfight.Registry;
import qlfight.Settings;
import qlfight.daos.PlayerDao;
import qlfight.daos.TourneyDao;
import qlfight.managers.PlayerManager;
import qlfight.managers.QlFightController;
import qlfight.managers.TourneyManager;
import qlfight.models.Player;
import qlfight.models.Tourney;
import qlfight.qlapi.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QlFightUrlMapper extends RestUrlMapper {

    private static final Pattern P_SERVER = Pattern.compile("^/api/server/(?<id>\\d+)");
    private static final Pattern P_MATCH = Pattern.compile("^/api/matches/(?<id>\\d+)");

    private final QlFightController controller;
    private final TourneyManager tourneyManager;
    private final Tourney tourney;
    private final QlApiService ql;
    private final PlayerManager playerManager;
    private final TourneyDao tourneyDao;
    private final PlayerDao playerDao;

    public QlFightUrlMapper(ObjectMapper jackson, QlFightController controller, TourneyManager tourneyManager, QlApiService ql, PlayerManager playerManager, TourneyDao tourneyDao, PlayerDao playerDao) {
        super(jackson);
        this.controller = controller;
        this.tourneyManager = tourneyManager;
        this.ql = ql;
        this.playerManager = playerManager;
        this.tourneyDao = tourneyDao;
        this.playerDao = playerDao;

        tourney = new Tourney(ObjectId.get(), Location.EUROPE, GameType.DUEL, LocalDateTime.now());
    }

    @Override
    @Suspendable
    public boolean handle(HttpServletRequest request, HttpServletResponse response) {
        final String method = request.getMethod();
        final String path = request.getPathInfo();
        Matcher matcher;

        if (method.equals("GET")) {
            if (path.equals("/")) {
                controller.index(response);
                return true;
            }

            if (path.equals("/api/servers")) {
                jsonResponse(response, controller.tourneys());
                return true;
            }

            matcher = P_SERVER.matcher(path);
            if (matcher.find()) {
                String id = matcher.group("id");
                jsonResponse(response, controller.server(Integer.parseInt(id)));
            }

            matcher = P_MATCH.matcher(path);
            if (matcher.find()) {
                String id = matcher.group("id");
                jsonResponse(response, controller.matches(id));
                return true;
            }

            if (path.equals("/api/match")) {
                jsonResponse(response, controller.match());
                return true;
            }

            if (path.equals("/api/tourney")) {
                List<Player> signedUp = tourneyManager.collectPlayers(GameType.DUEL, Location.EUROPE);
                jsonResponse(response, signedUp);
            }
        }

        return false;
    }
}

