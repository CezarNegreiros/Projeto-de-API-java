package modelos;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.cert.CertPath;
import java.util.Scanner;

public class meuEndereco {

    private String urlEndereco;
    private String cep;

    public String getCep(){
        return cep;
    }

    public void setCep(String cep){
        this.cep = cep;
    }


    //Método para validar e realizar a consulta do CEP
    public String consultaCep(String CEP) {
        try {
            if (CEP == null || !CEP.matches("[0-9]{8}")) {
                throw new IllegalArgumentException("CEP inválido");
            }
            urlEndereco = "https://viacep.com.br/ws/" + CEP + "/json/"; //"viacep.com.br/ws/69043500/json/";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlEndereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return json;
        } catch (InterruptedException | IOException | IllegalArgumentException e) {
            return e.getMessage();
        }

    }

    //Método para realizar a criação do arquivo com as informações do JSON
    public void arquivoCEP(){
        try {
            FileWriter escrita = new FileWriter("endereco.json");
            escrita.write(consultaCep(getCep()));
            escrita.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
