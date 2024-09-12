import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champion = null;  // Inicialmente, nenhum campeão
        int i = 1;  // Contador de palavras

        // Enquanto houver palavras na entrada
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();  // Lê a próxima palavra

            if (StdRandom.bernoulli(1.0 / i)) {
                champion = word;
            }
            i++;  // Incrementa o contador de palavras
        }

        // Exibe a palavra campeã
        if (champion != null) {
            StdOut.println(champion);
        }
    }
}
