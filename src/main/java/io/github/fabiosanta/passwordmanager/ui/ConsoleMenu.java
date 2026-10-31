package io.github.fabiosanta.passwordmanager.ui;

import io.github.fabiosanta.passwordmanager.model.Credential;
import io.github.fabiosanta.passwordmanager.service.CredentialService;

import java.util.List;
import java.util.Scanner;

public final class ConsoleMenu {

    private final CredentialService service;
    private final Scanner scanner;

    public ConsoleMenu(CredentialService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("Password Manager");
        System.out.println("Usa solo dati inventati.");
        System.out.println(
            "I dati restano in memoria e si perdono alla chiusura."
        );

        while (true) {
            System.out.println();
            System.out.println("1. Aggiungi credenziale");
            System.out.println("2. Mostra elenco");
            System.out.println("0. Esci");

            String choice = readLine("Scelta: ");

            if (choice == null) {
                return;
            }

            switch (choice.strip()) {
                case "1" -> addCredential();
                case "2" -> showCredentials();
                case "0" -> {
                    System.out.println("Programma chiuso.");
                    return;
                }
                default ->
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    private void addCredential() {
        String title = readLine("Titolo: ");
        if (title == null) {
            return;
        }

        String username = readLine("Nome utente: ");
        if (username == null) {
            return;
        }

        String password = readLine("Password dimostrativa (visibile): ");
        if (password == null) {
            return;
        }

        try {
            Credential credential =
                new Credential(title, username, password);

            service.add(credential);

            System.out.println("Credenziale aggiunta.");
        } catch (IllegalArgumentException e) {
            System.out.println("Dati non validi: " + e.getMessage());
        }
    }

    private void showCredentials() {
        List<Credential> credentials = service.findAll();

        if (credentials.isEmpty()) {
            System.out.println("Nessuna credenziale presente.");
            return;
        }

        for (Credential credential : credentials) {
            System.out.println(
                credential.getTitle()
                    + " | "
                    + credential.getUsername()
            );
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);

        if (!scanner.hasNextLine()) {
            System.out.println();
            System.out.println("Input terminato.");
            return null;
        }

        return scanner.nextLine();
    }
}