package qlfight.urlmappers;

import co.paralleluniverse.fibers.Suspendable;
import com.fasterxml.jackson.databind.ObjectMapper;
import justweb.urlmapper.RestUrlMapper;
import qlfight.controllers.QlFightController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QlFightUrlMapper extends RestUrlMapper {

    private static final Pattern P_MATCH = Pattern.compile("^/api/matches/(?<id>\\d+)");

    private final QlFightController controller;

    public QlFightUrlMapper(ObjectMapper jackson, QlFightController controller) {
        super(jackson);
        this.controller = controller;
    }

    @Override
    @Suspendable
    public boolean handle(HttpServletRequest request, HttpServletResponse response) {
        final String method = request.getMethod();
        final String path = request.getPathInfo();
        Matcher matcher = null;

        if (method.equals("GET")) {
            if (path.equals("/")) {
                controller.index(response);
                return true;
            }

            if (path.equals("/api/tourneys")) {
                jsonResponse(response, controller.tourneys());
                return true;
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
        }

        return false;
    }
}

