/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.pm20161.modelo;

/**
 *
 * @author Thiago Passos
 */
public class HttpResponse {
    private String responseBody;
    private int responseCode;

    public HttpResponse(int responseCode, String responseBody) {
        this.responseBody = responseBody;
        this.responseCode = responseCode;
    }

    public HttpResponse(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public int getResponseCode() {
        return responseCode;
    }
    
}
