package com.teklive.demo;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.configuration.ProfileManager;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@OpenAPIDefinition(
    info = @Info(title = "Person api",
            description = "This API allows to generate random person",
            version = "1.0",
            contact = @Contact(name = "@amayas", url = "https://twitter.com/amabb21")),
    externalDocs = @ExternalDocumentation(url = "https://github.com/mayes21",
            description = "Person documentation API"))
public class PersonApplication extends Application {
    private static final Logger _log = Logger.getLogger(PersonApplication.class);

    void onStart(@Observes StartupEvent startupEvent) {
        banner();
        _log.info("The application Person is starting with profile [" + ProfileManager.getActiveProfile() + "]");
    }

    void onStop(@Observes ShutdownEvent shutdownEvent) {
        _log.info("The application Person is stopping...");
    }

    private void banner() {
        System.out.println("                                         .---.                                       ");
        System.out.println("               __.....__          .      |   |.--..----.     .----.   __.....__      ");
        System.out.println("           .-''         '.      .'|      |   ||__| \\    \\   /    /.-''         '.    ");
        System.out.println("     .|   /     .-''\"'-.  `.  .'  |      |   |.--.  '   '. /'   //     .-''\"'-.  `.  ");
        System.out.println("   .' |_ /     /________\\   \\ |   |      |   ||  |  |    |'    //     /________\\   \\ ");
        System.out.println(" .'     ||                  | |   | ____ |   ||  |  |    ||    ||                  | ");
        System.out.println("'--.  .-'\\    .-------------' |   | \\ .' |   ||  |  '.   `'   .'\\    .-------------' ");
        System.out.println("   |  |   \\    '-.____...---. |   |/  .  |   ||  |   \\        /  \\    '-.____...---. ");
        System.out.println("   |  |    `.             .'  |    /\\  \\ |   ||__|    \\      /    `.             .'  ");
        System.out.println("   |  '.'    `''-...... -'    |   |  \\  \'---'         '----'       `''-...... -'    ");
        System.out.println("   |   /                      '    \\  \\  \\                                           ");
        System.out.println("   `'-'                      '------'  '---'                                         ");
        System.out.println("                                                                                     ");
    }
}
