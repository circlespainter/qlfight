package qlfight;

import qlfight.daos.PlayerDao;
import qlfight.daos.TourneyDao;
import qlfight.managers.PlayerManager;
import qlfight.managers.QlFightController;
import qlfight.managers.TourneyManager;
import qlfight.qlapi.QlApiService;
import qlfight.services.QlRanksService;
import qlfight.urlmappers.QlFightUrlMapper;

public class Registry extends justweb.Registry {

    private QlFightUrlMapper urlMapper;

    private QlApiService qlApiService;
    private QlRanksService qlRanksService;

    private QlFightController qlFightController;
    private PlayerManager playerManager;
    private TourneyManager tourneyManager;

    private PlayerDao playerDao;
    private TourneyDao tourneyDao;

    public Registry(justweb.Settings settings) {
        super(settings);
    }

    @Override
    public QlFightUrlMapper urlMapper() {
        if (urlMapper == null) {
            urlMapper = new QlFightUrlMapper(jacksonMapper(), qlFightController(), tourneyManager(),
                    qlApiService(), playerManager(), tourneyDao(), playerDao());
        }

        return urlMapper;
    }

    public QlApiService qlApiService() {
        if (qlApiService == null) {
            qlApiService = new QlApiService(fiberJettyHttpClient(), jacksonMapper());
        }

        return qlApiService;
    }

    public QlRanksService qlRanksService() {
        if (qlRanksService == null) {
            qlRanksService = new QlRanksService(fiberJettyHttpClient());
        }

        return qlRanksService;
    }

    public QlFightController qlFightController() {
        if (qlFightController == null) {
            qlFightController = new QlFightController(qlApiService());
        }

        return qlFightController;
    }

    public PlayerManager playerManager() {
        if (playerManager == null) {
            playerManager = new PlayerManager(playerDao(), qlRanksService());
        }

        return playerManager;
    }

    public TourneyManager tourneyManager() {
        if (tourneyManager == null) {
            tourneyManager = new TourneyManager(qlApiService(), playerManager(), tourneyDao(), playerDao());
        }

        return tourneyManager;
    }

    public PlayerDao playerDao() {
        if (playerDao == null) {
            playerDao = new PlayerDao(mongoService());
        }

        return playerDao;
    }

    public TourneyDao tourneyDao() {
        if (tourneyDao == null) {
            tourneyDao = new TourneyDao(mongoService());
        }

        return tourneyDao;
    }

}
