package qlfight.services;

import co.paralleluniverse.fibers.Suspendable;
import justweb.jetty.client.FiberJettyHttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QlRanksService {

    private static final Pattern P_ELO = Pattern.compile("<span id=\"ctl00_ContentPlaceHolder1_lblPlayerCurrentElo\">(?<elo>\\d+) \\(\\d+\\)</span>");

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final FiberJettyHttpClient http;

    public QlRanksService(FiberJettyHttpClient http) {
        this.http = http;
    }

    /**
     * <span id="ctl00_ContentPlaceHolder1_lblPlayerCurrentElo">1362 (1523)</span>
     * @param playerName
     * @return
     */
    @Suspendable
    public Integer elo(GameType gameType, String playerName) {
        log.info("Requesting elo for player: {}", playerName);
        ContentResponse response = null;
        try {
            response = http.get(String.format("http://www.qlranks.com/%s/player/%s", gameType.urlPiece, playerName));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        String html = response.getContentAsString();
        Matcher matcher = P_ELO.matcher(html);
        Integer elo = null;

        if (matcher.find()) {
            String raw = matcher.group("elo");
            try {
                elo = Integer.parseInt(raw);
                log.info("Parsed elo value: {}", elo);
            }
            catch (NumberFormatException e) {
                log.error("Could not parse elo value: {}", raw);
            }
        }

        return elo;
    }

    public enum GameType {
        DUEL("duel"), CA("ca"), TDM("tdm"), CTF("ctf"), FFA("ffa");

        public final String urlPiece;
        GameType(String urlPiece) {
            this.urlPiece = urlPiece;
        }

        public static GameType fromQl(qlfight.qlapi.GameType gameType) {
            if (qlfight.qlapi.GameType.DUEL == gameType) return DUEL;
            if (qlfight.qlapi.GameType.CA == gameType) return CA;
            if (qlfight.qlapi.GameType.TDM == gameType) return TDM;
            if (qlfight.qlapi.GameType.CTF == gameType) return CTF;
            if (qlfight.qlapi.GameType.FFA == gameType) return FFA;
            return null;
        }
    }
}
