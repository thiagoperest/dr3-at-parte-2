package br.edu.infnet.dr3atparte2.config;

import br.edu.infnet.dr3atparte2.controller.MensalistaClientController;
import io.javalin.Javalin;

public class RouteConfig {

    public static void configureRoutes(Javalin app) {
        // Rubrica 3, item 1 -> Cliente para criar mensalista via API externa
        app.post("/mensalistas", MensalistaClientController::createMensalistaViaApi);
        
        // Rubrica 3, item 2 -> Cliente para listar mensalistas via API externa
        app.get("/mensalistas", MensalistaClientController::getAllMensalistasViaApi);
        
        // Rubrica 3, item 3 -> Cliente para buscar mensalista por matrícula via API externa
        app.get("/mensalistas/{matricula}", MensalistaClientController::getMensalistaByMatriculaViaApi);
        
        // Rubrica 3, item 4 -> Cliente para obter status do sistema via API externa
        app.get("/status", MensalistaClientController::getStatusViaApi);
    }
}
