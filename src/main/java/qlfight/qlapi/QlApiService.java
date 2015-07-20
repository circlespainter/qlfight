package qlfight.qlapi;

import co.paralleluniverse.fibers.Suspendable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import justweb.AppException;
import justweb.jetty.client.FiberJettyHttpClient;
import org.eclipse.jetty.client.api.ContentResponse;

import java.util.Base64;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class QlApiService {

    private final FiberJettyHttpClient http;
    private final ObjectMapper jackson;

    public QlApiService(FiberJettyHttpClient http, ObjectMapper jackson) {
        this.http = http;
        this.jackson = jackson;
    }

    @Suspendable
    public String serverList(ServerListFilter filter) {
        byte[] bytes = null;
        try {
            bytes = jackson.writeValueAsBytes(filter);
        } catch (JsonProcessingException e) {
            throw new AppException(e);
        }

        String base64 = Base64.getEncoder().encodeToString(bytes);

        ContentResponse response = null;
        try {
            response = http.get("http://www.quakelive.com/browser/list?filter=" + base64);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return response.getContentAsString();
    }

}
