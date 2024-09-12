import java.util.Scanner;

public class YesChecker {

    // Método que verifica se a string é igual a "yes", ignorando maiúsculas e minúsculas
    public static boolean isEqualToYes(String input) {
        String target = "yes";
        return input.trim().equalsIgnoreCase(target); // Usa equalsIgnoreCase para simplificar
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê o número de testes
        int numberOfTests = scanner.nextInt();
        scanner.nextLine(); // Consumir a linha pendente

        for (int i = 0; i < numberOfTests; i++) {
            String input = scanner.nextLine();

            // Verifica e imprime o resultado
            if (isEqualToYes(input)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close(); // Fecha o scanner após o uso
    }
}
