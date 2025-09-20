package br.edu.infnet.dr3atparte2.service;

import br.edu.infnet.dr3atparte2.client.MensalistaHttpClient;
import br.edu.infnet.dr3atparte2.dto.MensalistaRequestDto;
import br.edu.infnet.dr3atparte2.dto.MensalistaResponseDto;

public class MensalistaClientService {

    private final MensalistaHttpClient httpClient;

    public MensalistaClientService() {
        this.httpClient = new MensalistaHttpClient();
    }

    public MensalistaResponseDto createMensalistaViaApi(MensalistaRequestDto request) {
        return httpClient.createMensalista(request);
    }

    public String getAllMensalistasViaApi() {
        return httpClient.getAllMensalistas();
    }

    public String getMensalistaByMatriculaViaApi(String matricula) {
        return httpClient.getMensalistaByMatricula(matricula);
    }
}
