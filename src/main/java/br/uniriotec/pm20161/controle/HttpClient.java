package br.uniriotec.pm20161.controle;

import br.uniriotec.pm20161.modelo.HttpResponse;
import br.uniriotec.pm20161.modelo.Programas;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 *
 * @author Thiago Passos
 */
public class HttpClient {
    private OkHttpClient client;
    private HttpClient instance;

    private HttpClient() {
        this.client = new OkHttpClient();
    }
    
    /**
     * Get only one instance of HttpClient
     */
    public HttpClient getInstance() {
        if (instance == null) {
            instance = new HttpClient();
        }
        return instance;
    }
    
    /**
     * Default method to make get requests 
     */
    private HttpResponse makeGetRequest(String url) throws Exception {
        HttpResponse httpResponse;
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            httpResponse = new HttpResponse(response.code(), response.body().string());
        } else {
            httpResponse = new HttpResponse(response.code());
        }
        
        return httpResponse;
    }
}
