package io.github.fabiosanta.passwordmanager.service;

import io.github.fabiosanta.passwordmanager.model.Credential;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CredentialServiceTest {

    @Test
    void startsEmpty() {
        CredentialService service = new CredentialService();

        assertTrue(service.findAll().isEmpty());
    }

    @Test
    void addedCredentialAppearsInList() {
        CredentialService service = new CredentialService();
        Credential credential =
            new Credential("Forum", "fabio", "password-finta");

        service.add(credential);

        List<Credential> result = service.findAll();

        assertEquals(1, result.size());
        assertEquals(credential.getId(), result.get(0).getId());
    }

    @Test
    void rejectsNullCredential() {
        CredentialService service = new CredentialService();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.add(null)
        );

        assertTrue(service.findAll().isEmpty());
    }

    @Test
    void returnedListCannotBeUsedToRemoveCredentials() {
        CredentialService service = new CredentialService();
        service.add(
            new Credential("Forum", "fabio", "password-finta")
        );

        List<Credential> result = service.findAll();

        assertThrows(
            UnsupportedOperationException.class,
            () -> result.clear()
        );

        assertEquals(1, service.findAll().size());
    }
}