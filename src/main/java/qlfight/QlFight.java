package qlfight;

import justweb.Application;

public class QlFight extends Application<Settings, Registry> {
    @Override
    public String name() {
        return "qlfight";
    }

    @Override
    protected Settings newSettings() {
        return new Settings(this);
    }

    @Override
    protected Registry newRegistry() {
        return new Registry(this);
    }

    public static void main(String[] args) {
        QlFight app = new QlFight();
        app.run();
    }
}
