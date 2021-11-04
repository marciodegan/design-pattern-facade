package shopexample.http;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class HttpAdapterImplHttpClient implements HttpAdapter {

    @Override
    public void post(String url, Map<String, Object> dados) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body) // use body method from HttpResponse class to apply on response received
//                .thenAccept(System.out::println)
                .thenApply(HttpAdapterImplHttpClient::parse)
                .join(); // to see the result in console
    }

    public static String parse(String responseBody) {
        JSONArray albums = new JSONArray(responseBody);
        for (int i = 0; i < albums.length(); i++) {
            JSONObject album = albums.getJSONObject(i);
            int id = album.getInt("id");
            int userId = album.getInt("userId");
            String title = album.getString("title");
            System.out.println(id + " - " + userId + " - " + title);
        }
        return null;
    }


}
