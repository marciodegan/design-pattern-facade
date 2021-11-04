package shopexample.http;

import shopexample.http.HttpAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Map;

public class HttpAdapterImplHtmlURLConnection implements HttpAdapter {

    private static HttpURLConnection connection;

    @Override
    public void post(String url, Map<String, Object> dados) {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL urlDaApi = new URL(url);
            connection = (HttpURLConnection) urlDaApi.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());

        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar requisição HTTP");
        } finally {
            connection.disconnect();
        }
    }
}
