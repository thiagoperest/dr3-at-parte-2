package br.edu.infnet.dr3atparte2.controller;

import br.edu.infnet.dr3atparte2.dto.MensalistaRequestDto;
import br.edu.infnet.dr3atparte2.dto.MensalistaResponseDto;
import br.edu.infnet.dr3atparte2.service.MensalistaClientService;
import io.javalin.http.Context;

public class MensalistaClientController {

    private static final MensalistaClientService mensalistaClientService = new MensalistaClientService();

    public static void createMensalistaViaApi(Context ctx) {
        MensalistaRequestDto request = ctx.bodyAsClass(MensalistaRequestDto.class);
        MensalistaResponseDto response = mensalistaClientService.createMensalistaViaApi(request);
        
        if (response != null) {
            ctx.status(201).json(response);
        } else {
            ctx.status(500).json("{\"error\": \"Erro ao comunicar com API externa\"}");
        }
    }

    public static void getAllMensalistasViaApi(Context ctx) {
        String response = mensalistaClientService.getAllMensalistasViaApi();
        
        if (response != null) {
            ctx.status(200).result(response).header("Content-Type", "application/json");
        } else {
            ctx.status(500).json("{\"error\": \"Erro ao comunicar com API externa\"}");
        }
    }

    public static void getMensalistaByMatriculaViaApi(Context ctx) {
        String matricula = ctx.pathParam("matricula");
        String response = mensalistaClientService.getMensalistaByMatriculaViaApi(matricula);
        
        if (response != null) {
            ctx.status(200).result(response).header("Content-Type", "application/json");
        } else {
            ctx.status(500).json("{\"error\": \"Erro ao comunicar com API externa\"}");
        }
    }
}
