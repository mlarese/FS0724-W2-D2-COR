package epicode.it.ex1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> duplicati = new ArrayList<>();
        Set<String> words = new HashSet<>();

        System.out.println("Inserire il numero di elementi");
        int numElementi = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numElementi; i++) {
            System.out.println("Inserisci una parola");
            String word = scanner.nextLine();

            // il metodo add di un set restituisce true se lo aggiunge e false se non lo fa, cosa che
            // succede quando l'elemento è già nella lista
            if(!words.add(word)) {
                System.out.println("Parola duplicata");
                duplicati.add(word);
            }


        }
        // ciclo le parole duplicate e le levo se esistono dal set words
        for (int i = 0; i < duplicati.size() ; i++) {
            String parola = duplicati.get(i);

            words.remove(parola);
        }

        // altra soluzione alla rimozione dei duplicati
        // words.removeAll(duplicati);

        // stampa i duplicati esercizio 1 punto 1
        System.out.println( duplicati);

        // stampa il numero di parole distinte esercizio 1 punto 2
        System.out.println(words.size());

        // stampa l'elenco delle parole distinte esercizio 1 punto 3
        System.out.println(words);

    }
}
