# Password Manager

Progetto didattico in Java per imparare a sviluppare un'applicazione
e approfondire la gestione sicura delle credenziali.

## Stato attuale

Il progetto è nella fase iniziale: il programma mostra un messaggio
di avvio nel terminale. Non gestisce ancora credenziali.

Non utilizzare con password reali.

## Requisiti

- JDK 25
- Maven

## Come eseguire

Dalla cartella del progetto:

```powershell
mvn compile
java -cp target/classes io.github.fabiosanta.passwordmanager.Main
```

## Funzionalità previste

- Gestione di credenziali dimostrative
- Generazione di password casuali
- Archivio cifrato protetto da una password principale
- Interfaccia grafica
- Test e documentazione delle scelte di sicurezza

## Sicurezza prevista — non ancora implementata

Il progetto prevede:

- Argon2id per derivare la chiave dalla password principale, con salt casuale.
- AES-256-GCM per cifrare l’archivio e rilevare alterazioni.
- Gestione dei nonce per evitare il riutilizzo con la stessa chiave.
- Utilizzo di librerie crittografiche esistenti, senza implementare autonomamente gli algoritmi.
- Test per password errate, dati alterati e file danneggiati.

I parametri, le librerie e il formato dell’archivio saranno documentati durante lo sviluppo.

Il progetto è didattico, non è stato sottoposto a una revisione di sicurezza indipendente e non è consigliabile usarlo con credenziali reali.