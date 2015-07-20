package qlfight.controllers;

import co.paralleluniverse.fibers.Suspendable;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import justweb.AppException;
import qlfight.qlapi.QlApiService;
import qlfight.qlapi.ServerListFilter;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

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
    public String tourneys() {
        ServerListFilter filter = new ServerListFilter(ServerListFilter.GameType.DUEL);
        return ql.serverList(filter);
    }

}
