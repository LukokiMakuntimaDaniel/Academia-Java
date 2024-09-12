package Estruturas.lukoki.ao;

import Excessoes.erroDeCoonsumo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consumo {
    private final HttpClient client;

    public Consumo() {
        this.client = HttpClient.newHttpClient();
    }

    public String consumindoApi(String link){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link)).build();
        try {
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode()==200){
                return  response.body();
            }else{
                return null;
            }
        } catch (IOException | InterruptedException e) {
            throw new erroDeCoonsumo("Erro ao consumir");
        }
    }

    public PegarEndecoViaApi converterEmGson(String response){
        try {
            Gson gson = new Gson();
            return gson.fromJson(response,PegarEndecoViaApi.class);
        }catch (Exception e){
            return  null;
        }
    }


}
