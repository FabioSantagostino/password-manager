package io.github.fabiosanta.passwordmanager.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CredentialTest {

    @Test
    void preservesPasswordExactly() {
        String password = "  password-finta  ";

        Credential credential =
            new Credential("Forum", "fabio", password);

        assertEquals(password, credential.getPassword());
    }

    @Test
    void rejectsNullTitle() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Credential(null, "fabio", "password-finta")
        );
    }

    @Test
    void rejectsBlankTitle() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Credential("   ", "fabio", "password-finta")
        );
    }

    @Test
    void rejectsEmptyPassword() {
        assertThrows(
            IllegalArgumentException.class, 
            () -> new Credential("Forum", "fabio", "")
        );
    }
}