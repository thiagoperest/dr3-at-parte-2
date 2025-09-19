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
                System.out.println("Erro na requisição. Status: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao fazer requisição: " + e.getMessage());
            return null;
        }
    }
}
