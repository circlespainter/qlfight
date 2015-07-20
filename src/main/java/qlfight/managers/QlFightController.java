package qlfight.managers;

import co.paralleluniverse.fibers.Suspendable;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import justweb.AppException;
import qlfight.qlapi.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class QlFightController {

    private final QlApiService ql;
    private final String indexHtml;

    public QlFightController(QlApiService ql) {
        this.ql = ql;

        try {
            indexHtml = Files.toString(new File("src/main/resources/html/index.html"), Charsets.UTF_8);
        } catch (IOException e) {
            throw new AppException(e);
        }
    }

    public void index(HttpServletResponse response) {
        try {
            response.getWriter().write(indexHtml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Suspendable
    public ServerList tourneys() {
        ServerListFilter filter = new ServerListFilter(GameType.DUEL);
        filter.filters.state = GameState.IN_PROGRESS;

        ServerList list = null;
        try {
            list = ql.serverList(filter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Suspendable
    public ServerDetails[] server(Integer serverId) {
        ServerDetails[] details = null;
        try {
            details = ql.serverDetails(serverId, 804192);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return details;
    }

    @Suspendable
    public Object matches(String id) {
        Object ids = null;
        try {
            ids = ql.matchesByWeek("Taake", "2015-07-20");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return ids;
    }

    @Suspendable
    public Object match() {
        String details = null;
        try {
            details = ql.matchDetails(new MatchId("2d9d94fe-2e32-11e5-9129-0242ac11001c", GameType.DUEL, "1"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return details;
    }

}
