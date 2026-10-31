package io.github.fabiosanta.passwordmanager.service;

import io.github.fabiosanta.passwordmanager.model.Credential;

import java.util.ArrayList;
import java.util.List;

public final class CredentialService {

    private final List<Credential> credentials = new ArrayList<>();

    public void add(Credential credential) {
        if (credential == null) {
            throw new IllegalArgumentException(
                "La credenziale non può essere null."
            );
        }

        credentials.add(credential);
    }

    public List<Credential> findAll() {
        return List.copyOf(credentials);
    }
}