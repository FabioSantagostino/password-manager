package io.github.fabiosanta.passwordmanager;

import io.github.fabiosanta.passwordmanager.service.CredentialService;
import io.github.fabiosanta.passwordmanager.ui.ConsoleMenu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CredentialService service = new CredentialService();

        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleMenu menu = new ConsoleMenu(service, scanner);
            menu.run();
        }
    }
}