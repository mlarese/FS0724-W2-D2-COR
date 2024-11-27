package epicode.it.ex3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    // Dichiarazione di una mappa statica per la rubrica (nome -> numero).
    // Viene usata una HashMap perché consente un accesso rapido ai dati tramite le chiavi (O(1)).
    private static final Map<String, String> rubrica = new HashMap<>();

    public static void main(String[] args) {
        // 1. Aggiunta di contatti iniziali alla rubrica.
        // Questi dati sono un esempio per testare i metodi della classe.
        aggiungiContatto("Mauro", "99999999");
        aggiungiContatto("Roby", "666666666");
        aggiungiContatto("Carlo", "7777777");
        aggiungiContatto("Andrea", "555555");

        // 2. Stampa del numero totale di contatti.
        // Utile per verificare che l'aggiunta abbia funzionato.
        System.out.println("La rubrica contiene " + rubrica.size() + " nominativi");

        // 3. Test del metodo cancellaNumeroByNome con un nome esistente.
        // Verifichiamo che un contatto venga effettivamente rimosso dalla rubrica.
        System.out.println("############# cancellaNumeroByNome esistente");
        cancellaNumeroByNome("Roby");
        System.out.println("La rubrica contiene " + rubrica.size() + " nominativi");

        // 4. Test del metodo cancellaNumeroByNome con un nome non esistente.
        // Serve per controllare che il programma non vada in errore in caso di input non valido.
        System.out.println("############# cancellaNumeroByNome non esistente");
        cancellaNumeroByNome("Martina");
        System.out.println("La rubrica contiene " + rubrica.size() + " nominativi");

        // 5. Test del metodo cercaPersonaByNumero.
        // Serve a verificare che il programma riesca a trovare il nome associato a un numero.
        System.out.println("############# cercaPersonaByNumero");
        cercaPersonaByNumero("7777777");

        // 6. Test del metodo trovaNumeroByNome.
        // Verifichiamo che il programma restituisca il numero corretto dato un nome.
        System.out.println("############# trovaNumeroByNome");
        trovaNumeroByNome("Andrea");

        // 7. Stampa di tutti i contatti presenti nella rubrica.
        // È un controllo finale per verificare lo stato della rubrica.
        System.out.println("############# Stampa contatti");
        stampaTuttiContatti();
    }

    // Metodo per aggiungere un contatto alla rubrica.
    // Input: nome del contatto e numero di telefono.
    private static void aggiungiContatto(String nome, String numero) {
        // Inseriamo il nome come chiave e il numero come valore nella mappa.
        // La scelta della mappa consente di evitare duplicati: un nome uguale sovrascrive il numero esistente.
        rubrica.put(nome, numero);
    }

    // Metodo per cancellare un contatto tramite il nome.
    // Input: nome del contatto da rimuovere.
    private static void cancellaNumeroByNome(String nome) {
        // Rimuove il contatto se esiste. Se il nome non è presente, il metodo `remove` non genera errori.
        // Questo comportamento è utile per evitare controlli manuali sull'esistenza della chiave.
        rubrica.remove(nome);
    }

    // Metodo per cercare una persona nella rubrica tramite il numero di telefono.
    // Input: numero da cercare.
    private static void cercaPersonaByNumero(String numero) {
        // Cicliamo su tutte le chiavi (nomi) presenti nella rubrica.
        for (String nome : rubrica.keySet()) {
            // Otteniamo il numero associato al nome corrente.
            String numeroAttuale = rubrica.get(nome);
            // Se il numero corrisponde a quello cercato, stampiamo il nome e terminiamo il metodo.
            if (numeroAttuale.equals(numero)) {
                System.out.println(nome);
                return; // Usciamo subito dopo aver trovato il risultato per ottimizzare il tempo di esecuzione.
            }
        }
        // Se il ciclo termina senza trovare il numero, stampiamo un messaggio di errore.
        System.out.println("numero non trovato");
    }

    // Metodo alternativo per cercare una persona tramite numero.
    // Restituisce il nome associato al numero o un messaggio di errore.
    private static String cercaPersonaByNumeroWithReturn(String numero) {
        // Simile al metodo precedente, ma restituisce un valore invece di stampare direttamente.
        for (String nome : rubrica.keySet()) {
            String numeroAttuale = rubrica.get(nome);
            if (numeroAttuale.equals(numero)) {
                return nome; // Restituiamo il nome associato al numero.
            }
        }
        // Restituiamo un messaggio se il numero non è trovato.
        return "numero non trovato";
    }

    // Metodo per trovare il numero di telefono associato a un nome.
    // Input: nome del contatto.
    private static void trovaNumeroByNome(String nome) {
        // Utilizziamo il metodo `get` della mappa per ottenere il numero associato al nome.
        String numeroTrovato = rubrica.get(nome);
        // Se il nome non esiste, `get` restituisce `null`.
        if (numeroTrovato == null) {
            // Stampa un messaggio di errore se il nome non è trovato.
            System.out.println("numero non trovato");
        } else {
            // Stampa il numero se il nome è trovato.
            System.out.println(numeroTrovato);
        }
    }

    // Metodo per stampare tutti i contatti presenti nella rubrica.
    private static void stampaTuttiContatti() {
        // Iteriamo su tutte le chiavi (nomi) presenti nella rubrica.
        for (String nome : rubrica.keySet()) {
            // Recuperiamo il numero associato al nome corrente.
            String numero = rubrica.get(nome);
            // Stampiamo il nome e il numero.
            System.out.println("Nome: " + nome + " numero: " + numero);
        }
    }
}
