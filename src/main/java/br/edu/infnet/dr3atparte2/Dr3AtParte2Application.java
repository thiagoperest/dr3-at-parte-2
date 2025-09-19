package br.edu.infnet.dr3atparte2;

import br.edu.infnet.dr3atparte2.config.RouteConfig;
import io.javalin.Javalin;

public class Dr3AtParte2Application {

    private static final int PORT = 8081;

    public static void main(String[] args) {
        // Configuração do Javalin
        Javalin app = Javalin.create(config -> {
            config.showJavalinBanner = false;
            config.bundledPlugins.enableDevLogging();
        });

        // Configuração das rotas
        RouteConfig.configureRoutes(app);

        // Inicialização do servidor
        app.start(PORT);

        System.out.println("Servidor Javalin iniciado na porta: " + PORT);
        System.out.println("Endpoints Rubrica 3 - Cliente HTTP:");
        System.out.println("Item 1: http://localhost:" + PORT + "/mensalistas (POST)");
        System.out.println("Item 2: http://localhost:" + PORT + "/mensalistas");
    }
}
