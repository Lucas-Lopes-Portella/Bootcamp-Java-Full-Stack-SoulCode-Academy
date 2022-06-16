import java.util.InputMismatchException;
import java.util.Scanner;
public class PrincipalExcecao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=2;
        System.out.println("Digite um número: ");
        try{
             num = sc.nextInt();
            System.out.println("O número informado é: " + num);
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e){
            System.out.println("Erro: você não digitou um número válido. " + e.getMessage());
        } catch (Exception e){
            System.out.println("Erro: você não digitou um número válido");
        } finally {
            System.out.println("Obrigatoriamente você passa por aqui.");
        }


    }
}
