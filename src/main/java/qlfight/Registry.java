package qlfight;

import qlfight.managers.QlFightController;
import qlfight.qlapi.QlApiService;
import qlfight.urlmappers.QlFightUrlMapper;

public class Registry extends justweb.Registry {

    private QlApiService qlApiService;
    private QlFightUrlMapper urlMapper;
    private QlFightController qlFightController;

    public Registry(justweb.Settings settings) {
        super(settings);
    }

    @Override
    public QlFightUrlMapper urlMapper() {
        if (urlMapper == null) {
            urlMapper = new QlFightUrlMapper(jacksonMapper(), qlFightController());
        }

        return urlMapper;
    }

    public QlApiService qlApiService() {
        if (qlApiService == null) {
            qlApiService = new QlApiService(fiberJettyHttpClient(), jacksonMapper());
        }

        return qlApiService;
    }

    public QlFightController qlFightController() {
        if (qlFightController == null) {
            qlFightController = new QlFightController(qlApiService());
        }

        return qlFightController;
    }

}
