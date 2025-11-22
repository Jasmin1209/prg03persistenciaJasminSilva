package br.com.ifba;

import br.com.ifba.curso.view.TelaInicial;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Prg03springApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Prg03springApplication.class);
        app.setHeadless(false);
        ConfigurableApplicationContext context = app.run(args);

        java.awt.EventQueue.invokeLater(() -> {
            context.getBean(TelaInicial.class).setVisible(true);
        });
    }
}
