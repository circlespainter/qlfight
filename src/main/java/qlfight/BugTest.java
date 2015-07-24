package qlfight;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.fibers.Suspendable;
import qlfight.managers.PlayerManager;
import qlfight.managers.TourneyManager;
import qlfight.models.Player;
import qlfight.qlapi.GameType;
import qlfight.qlapi.Location;

import java.util.concurrent.ExecutionException;

public class BugTest {

    public static void main(String[] args) {
        try {
            new Fiber<Void>() {
                @Override
                protected Void run() throws SuspendExecution, InterruptedException {
//                    new Test().jo();
                    QlFight app = new QlFight();
                    TourneyManager man = app.registry.tourneyManager();
                    man.collectPlayers(GameType.DUEL, Location.EUROPE);
                    return null;
                }
            }.start().join();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class Test {
        @Suspendable
        public void jo() {
            String[] names = new String[]{"inlakech", "asphexia_", "tz", "russian_ivann", "playbot", "z900", "seen_pl",
                    "hectorr", "nike777", "llllllll", "wzujaz", "egorkez", "bennyhill", "natruxatell", "topest", "diflope",
                    "stinklikesock", "starb", "cbzzz", "will7", "vbart", "puzzzle", "gtwsequence", "lapinousexy", "quzg",
                    "cumulant", "houd", "ltnz", "vetyz", "dissidente", "iller", "sergio", "bluepill", "zendzand",
                    "h34dhunt3r", "critical_error", "icanbeatyou", "drtribe", "athrandir", "demi", "lemma_", "harry_z_tybetu",
                    "andjey_", "fausto_laporte", "lamidex", "tonton_"};

            QlFight app = new QlFight();
            PlayerManager man = app.registry.playerManager();
            for (String name : names) {
                Player player = man.register(name);
                man.initGameType(player, GameType.DUEL);
            }
        }
    }
}
