import java.util.LinkedList;
import java.util.Scanner;

public class toBinary {
    //Linked list que guarda a parte inteira binária

    public static LinkedList<Integer> Contas = new LinkedList<Integer>();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String num = sc.nextLine();
        //char[] nums = new char[num.length()];
        int posPonto = num.indexOf(".");
        System.out.println("pos ponto: " + posPonto);
        int partInt = Integer.parseInt(num.substring(0, posPonto));
        System.out.println("Inteiro: " + partInt);
        CalculaBinInt(partInt);
        
        for (int a : Contas) {
            System.out.printf("%d", a);
            
        }
        System.out.println("");

    }

    public static void CalculaBinInt(int num) {
         while(num != 1){
             int resto = num%2;
             num = num/2;
             
             
             Contas.addFirst(resto);
         }  
         Contas.addFirst(num);

    }
}
