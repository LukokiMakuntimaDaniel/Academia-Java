import java.util.Scanner;

public class StringComparator {

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        
        // Leitura das strings
        String a = scanner.next();
        String b = scanner.next();
        
        int lengthA = a.length();
        int lengthB = b.length();

        // Comparar o último caractere de ambas as strings
        if (a.charAt(lengthA - 1) != b.charAt(lengthB - 1)) {
            System.out.println(lengthA + lengthB);
        } else {
            lengthA--;
            lengthB--;
            // Comparação de caracteres do final até o início
            while (lengthA >= 0 && lengthB >= 0 && a.charAt(lengthA) == b.charAt(lengthB)) {
                lengthA--;
                lengthB--;
            }
            // Imprime a soma dos tamanhos restantes
            System.out.println((lengthA + 1) + (lengthB + 1));
        }
        
        scanner.close(); // Fecha o scanner
    }

    public static void main(String[] args) {
        // Número de testes
        int t = 1;

        while (t-- > 0) {
            solve();
        }
    }
}
