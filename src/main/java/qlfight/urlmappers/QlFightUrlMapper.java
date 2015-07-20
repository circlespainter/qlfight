package qlfight.urlmappers;

import co.paralleluniverse.fibers.Suspendable;
import com.fasterxml.jackson.databind.ObjectMapper;
import justweb.urlmapper.RestUrlMapper;
import qlfight.controllers.QlFightController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QlFightUrlMapper extends RestUrlMapper {

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

        if (method.equals("GET")) {
            if (path.equals("/")) {
                controller.index(response);
                return true;
            }
            if (path.equals("/api/tourneys")) {
                String content = controller.tourneys();
                jsonResponse(response, content);
                return true;
            }
        }

        return false;
    }
}
