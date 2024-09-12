import java.util.Scanner;

public class PalindromeChecker {

    // Verifica se uma substring é um palíndromo
    public static boolean isPalindrome(String str, int left, int right) {
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê a string de entrada
        String input = scanner.next();
        int length = input.length();

        // Verifica se a string completa é um palíndromo
        if (!isPalindrome(input, 0, length - 1)) {
            System.out.println(length);
        } 
        // Verifica se removendo um caractere de cada extremidade ainda seria palíndromo
        else if (!isPalindrome(input, 0, length - 2) || !isPalindrome(input, 1, length - 1)) {
            System.out.println(length - 1);
        } 
        // Se já é um palíndromo perfeito
        else {
            System.out.println("0");
        }

        scanner.close(); // Fecha o scanner após o uso
    }
}
