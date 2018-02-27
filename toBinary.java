import java.util.LinkedList;
import java.util.Scanner;

public class toBinary {

    //Linked list que guarda a parte inteira binária
    public static LinkedList<Integer> Contas = new LinkedList<Integer>();
    //Linked list que guarda a parte fracionária binária
    public static LinkedList<Integer> ContasFra = new LinkedList<Integer>();

    public static void main(String args[]) {
        // Recebe a STRING com o numero.
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int i = 0;

        // Acha a posição do ponto. 
        int posPonto = num.indexOf(".");
        System.out.println("pos ponto: " + posPonto);

        // Separa a parte inteira da fracionada.
        // Parte Inteira:
        int partInt = Integer.parseInt(num.substring(0, posPonto));

        // Parte Fracionada:
        String partFraS = num.substring(posPonto + 1, num.length());
        double partFra = Double.parseDouble(partFraS);

        // Transforma a parte após o ponto em fração.
        while (i < partFraS.length()) {
            partFra = (partFra * 0.1);
            i++;
        }
        System.out.println("Inteiro: " + partInt + "\nFracio: " + partFra + " \nTamnho da parte Fra: " + partFraS.length());
        CalculaBinInt(partInt);
        boolean controle = CalculaBinFra(partFra); // verifica se há parte fracionada.
        // Imprime parte binaria fracionada
        if (controle) {
            for (int a : Contas) {
                System.out.printf("%d", a);

            }
            System.out.printf(".");
            for (int a : ContasFra) {
                System.out.printf("%d", a);

            }
        // Imprime parte binária inteira    
        } else {
            for (int a : Contas) {
                System.out.printf("%d", a);

            }
        }
        System.out.println("");

    }

    // Trasforma parte Inteira decimal em binaria:
    public static void CalculaBinInt(int num) {
        while (num != 1) {
            int resto = num % 2;
            num = num / 2;

            Contas.addFirst(resto);
        }
        Contas.addFirst(num);

    }

    // Trasforma parte Fracionada decimal em binaria:
    // Obs: Sem inclusão de dizima binária.
    public static boolean CalculaBinFra(double num) {
        if (num == 0) {
            return false;
        }
        double n = num * 2;
        while (n != 0) {
            if (n >= 1) {
                ContasFra.addFirst(1);
                n = n - 1;

            } else {
                ContasFra.addFirst(0);

            }
            n = n * 2;

        }
        return true;
    }
}

