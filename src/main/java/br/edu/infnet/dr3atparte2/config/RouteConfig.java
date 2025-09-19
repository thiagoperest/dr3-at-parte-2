package br.edu.infnet.dr3atparte2.config;

import br.edu.infnet.dr3atparte2.controller.MensalistaClientController;
import io.javalin.Javalin;

public class RouteConfig {

    public static void configureRoutes(Javalin app) {
        // Rubrica 3, item 1 -> Cliente para criar mensalista via API externa
        app.post("/mensalistas", MensalistaClientController::createMensalistaViaApi);
    }
}
