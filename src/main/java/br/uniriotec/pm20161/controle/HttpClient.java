package br.uniriotec.pm20161.controle;

import br.uniriotec.pm20161.modelo.HttpResponse;
import br.uniriotec.pm20161.modelo.Programas;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Thiago Passos
 */
public class HttpClient {
    private OkHttpClient client;
    private HttpClient instance;
    
    private static final String URL_LISTA_PROGRAMAS = "https://s3.amazonaws.com/posgraduacao/programas.xml";
    private static final String URL_PROGRAMAS = "https://s3.amazonaws.com/posgraduacao/{programa}/contents.xml";
    private static final String URL_CURRICULO_PROFESSOR = "https://s3.amazonaws.com/posgraduacao/{programa}/{codProfessor}.zip";

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
    private Response makeGetRequest(String url) throws Exception {
        HttpResponse httpResponse;
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        
        return client.newCall(request).execute();
    }
    
    private String getString(String url) {
        Response response = null;
        
        try {
            response = makeGetRequest(url);
        } catch (Exception e) {}
        
        if (response != null && response.isSuccessful() && response.code() == 200) {
            try {
                return response.body().string();
            } catch (IOException e) {
            }
        } else {
            System.out.println("HttpRequest error" + response.code());
        }
        
        return null;
    }
    
    private File getFile(String url, File file) {
        Response response = null;
        
        try {
            response = makeGetRequest(url);
        } catch (Exception e) {}
        
        if (response != null && response.isSuccessful() && response.code() == 200) {
            try {
                InputStream is = response.body().byteStream();
                BufferedInputStream input = new BufferedInputStream(is);
                OutputStream output = new FileOutputStream(file);
                byte[] data = new byte[1024];
                
                long total = 0;
                int count = 0;
                while((count = input.read(data)) != -1) {
                    total += count;
                    output.write(data, 0, count);
                }
                
                output.flush();
                output.close();
                input.close();
                
                
            } catch (IOException e) {
            }
        } else {
            System.out.println("HttpRequest error" + response.code());
        }
        
        return file;
    }
    
    public String getListaProgramas() {
        return getString(URL_LISTA_PROGRAMAS);
    }
    
    public String getPrograma(String nomePrograma) {
        String url = URL_PROGRAMAS;
        url = url.replace("{programa}", nomePrograma);
        
        return getString(url);
    }
    
    public File getCurriculoProfessor(String nomePrograma, String codProfessor) {
        String url = URL_CURRICULO_PROFESSOR;
        url = url.replace("{programa}", nomePrograma);
        url = url.replace("{codProfessor}", codProfessor);
        
        return getFile(url, new File(codProfessor +".zip"));
    }
}
