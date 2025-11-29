package br.com.ifba;

import br.com.ifba.curso.view.TelaInicial;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication //Anotação indica que essa é a classe principal da aplicação do springBoot
public class Prg03springApplication {

    public static void main(String[] args) {
        SpringApplication springapplication = new SpringApplication(Prg03springApplication.class);
        
        springapplication.setHeadless(false);//setHeadless(false) indica que será usada uma interface gráfica
        ConfigurableApplicationContext context = springapplication.run(args);

        //executa a criação da interface gráfica 
        java.awt.EventQueue.invokeLater(() -> {
            context.getBean(TelaInicial.class).setVisible(true);
        });
    }
}
