package io.github.fabiosanta.passwordmanager.model;
import java.util.UUID;
public final class Credential {

    private final UUID id;
    private final String title;
    private final String username;
    private final String password;

    public Credential(String title, String username, String password) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                "Il titolo non può essere vuoto."
            );
        }

        if (username == null) {
            throw new IllegalArgumentException(
                "Il nome utente non può essere null."
            );
        }

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException(
                "La password non può essere vuota."
            );
        }

        this.id = UUID.randomUUID();
        this.title = title;
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}