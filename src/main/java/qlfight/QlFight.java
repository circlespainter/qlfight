package qlfight;

import justweb.Application;
import justweb.Registry;
import justweb.Settings;

public class QlFight extends Application {
    @Override
    protected Settings newSettings() {
        return new qlfight.Settings();
    }

    @Override
    protected Registry newRegistry(Settings settings) {
        return new qlfight.Registry(settings);
    }

    public static void main(String[] args) {
        QlFight app = new QlFight();
        app.run();
    }
}
