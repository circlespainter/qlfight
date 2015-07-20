package qlfight.qlapi;

import co.paralleluniverse.fibers.Suspendable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import justweb.AppException;
import justweb.jetty.client.FiberJettyHttpClient;
import org.eclipse.jetty.client.api.ContentResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QlApiService {

    private static final Pattern P_MATCH_IDS = Pattern.compile("<div class=\"areaMapC\" id=\"(?<id>[\\w\\-]+)\">");

    private final FiberJettyHttpClient http;
    private final ObjectMapper jackson;

    public QlApiService(FiberJettyHttpClient http, ObjectMapper jackson) {
        this.http = http;
        this.jackson = jackson;
    }

    @Suspendable
    public ServerList serverList(ServerListFilter filter) throws InterruptedException, ExecutionException, TimeoutException {
        byte[] bytes;
        try {
            bytes = jackson.writeValueAsBytes(filter);
        } catch (JsonProcessingException e) {
            throw new AppException(e);
        }

        String base64 = Base64.getEncoder().encodeToString(bytes);
        ContentResponse response = http.get("http://www.quakelive.com/browser/list?filter=" + base64);
        byte[] content = response.getContent(); // TODO: byte copies, try to avoid

        ServerList serverList;
        try {
            serverList = jackson.readValue(content, ServerList.class);
        } catch (IOException e) {
            throw new AppException(e);
        }

        return serverList;
    }

    @Suspendable
    public ServerDetails[] serverDetails(Integer... ids) throws InterruptedException, ExecutionException, TimeoutException {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Integer id : ids) {
            if (first)
                first = false;
            else
                sb.append(",");
            sb.append(id);
        }

        ContentResponse response = http.get("http://www.quakelive.com/browser/details?ids=" + sb.toString());
        byte[] content = response.getContent();

        ServerDetails[] details;
        try {
            details = jackson.readValue(content, ServerDetails[].class);
        } catch (IOException e) {
            throw new AppException(e);
        }

        return details;
    }

    /**
     * <div class="areaMapC" id="duel_8c31da06-2d6b-11e5-9129-0242ac11001c_1">
     *     <div class="areaMap" style="background-image: url(http://cdn.quakelive.com/web/2014120201/images/levelshots/sm/campgrounds_v2014120201.0.jpg); position: relative">
     *         <img src="http://cdn.quakelive.com/web/2014120201/images/gametypes/xsm/duel_v2014120201.0.png" width="16" height="16" style="position: absolute; left: 1px; bottom: 1px;" />
     *         <div class="matches_won_icon"></div>
     *     </div>
     *     <span class="fl">11:39</span><span class="fr">Win</span><div class="cl"></div>
     * </div>

     * @param playerName
     * @param date
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    @Suspendable
    public List<MatchId> matchesByWeek(String playerName, String date) throws InterruptedException, ExecutionException, TimeoutException {
        ContentResponse response = http.get("http://www.quakelive.com/profile/matches_by_week/" + playerName + '/' + date);
        String html = response.getContentAsString();
        Matcher matcher = P_MATCH_IDS.matcher(html);

        List<MatchId> ids = new ArrayList<>();
        while (matcher.find()) {
            String rawId = matcher.group("id");
            String[] split = rawId.split("_");
            if (split.length >= 2) {
                final String gameType = split[0];
                final String publicId = split[1];
                final String oldEid = (split.length >= 3 ? split[2] : "");

                MatchId id = new MatchId(publicId, gameType, oldEid);
                ids.add(id);
            }
        }

        return ids;
    }

    @Suspendable
    public String matchDetails(MatchId id) throws InterruptedException, ExecutionException, TimeoutException {
        return http.get("http://www.quakelive.com/stats/matchdetails/" + id.url()).getContentAsString();
    }

}
