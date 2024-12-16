package request;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class ApiRequest {

    public String sendGetRequest(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = client.execute(request);
        return EntityUtils.toString(response.getEntity());
    }

    //mengambil parameter id
    public String sendGetRequestWithId(String url, int id) throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder(url);
        uriBuilder.setParameter("id", String.valueOf(id));

        HttpGet request = new HttpGet(uriBuilder.build());
        CloseableHttpResponse response = client.execute(request);
        return EntityUtils.toString(response.getEntity());
    }
}
