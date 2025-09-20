package br.edu.infnet.dr3atparte2.client;

import br.edu.infnet.dr3atparte2.dto.MensalistaRequestDto;
import br.edu.infnet.dr3atparte2.dto.MensalistaResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MensalistaHttpClient {

    private static final String BASE_URL = "http://localhost:8080";
    private final ObjectMapper objectMapper;

    public MensalistaHttpClient() {
        this.objectMapper = new ObjectMapper();
    }

    public MensalistaResponseDto createMensalista(MensalistaRequestDto request) {
        try {
            URL url = new URL(BASE_URL + "/mensalistas");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonRequest = objectMapper.writeValueAsString(request);

            try (OutputStream outputStream = connection.getOutputStream()) {
                byte[] input = jsonRequest.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                String responseBody = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
                return objectMapper.readValue(responseBody, MensalistaResponseDto.class);
            } else {
                System.out.println("Erro na requisição POST /mensalistas. Status: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao fazer requisição: " + e.getMessage());
            return null;
        }
    }

    public String getAllMensalistas() {
        try {
            URL url = new URL(BASE_URL + "/mensalistas");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            int responseCode = connection.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String responseBody = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

                System.out.println("--- ITEM 2 - LISTAGEM DE TODOS OS MENSALISTAS ---");
                System.out.println(responseBody);
                System.out.println("------------");
                
                return responseBody;
            } else {
                System.out.println("Erro na requisição GET /mensalistas. Status: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao fazer requisição GET: " + e.getMessage());
            return null;
        }
    }

    public String getMensalistaByMatricula(String matricula) {
        try {
            URL url = new URL(BASE_URL + "/mensalistas/" + matricula);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            int responseCode = connection.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String responseBody = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

                System.out.println("--- ITEM 3 - BUSCA DE MENSALISTA POR MATRÍCULA ---");
                System.out.println(responseBody);
                System.out.println("------------");
                
                return responseBody;
            } else {
                System.out.println("Erro na requisição GET /mensalistas/{matricula}. Status: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao fazer requisição GET com path param: " + e.getMessage());
            return null;
        }
    }

    public String getStatus() {
        try {
            URL url = new URL(BASE_URL + "/status");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            int responseCode = connection.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String responseBody = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

                System.out.println("--- ITEM 4 - STATUS DO SISTEMA ---");
                System.out.println(responseBody);
                System.out.println("------------");
                
                return responseBody;
            } else {
                System.out.println("Erro na requisição GET /status. Status: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao fazer requisição GET /status: " + e.getMessage());
            return null;
        }
    }
}
