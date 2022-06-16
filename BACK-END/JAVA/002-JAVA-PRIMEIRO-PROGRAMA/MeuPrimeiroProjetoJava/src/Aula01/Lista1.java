package Aula01;
import java.util.Scanner;

public class Lista1 {
    public static void main (String[] args){
        Scanner leitor = new Scanner(System.in);
         System.out.println("Olá Mundo!!");

        //declarar arrays
        int[] numeros = new int[5];
        int[] numeros2 = {1,2,3,4,5};
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;

        for(short i = 0; i<numeros.length;i++){
            System.out.println(numeros[i]);
        }

        char[] gabarito = {'a','e','b','c','e'};
        char[] respostas = new char[5];
        int nota = 0;

        for(int pos = 0; pos<gabarito.length; pos++){
            System.out.println("Digite a resposta da pergunta " + (pos+1)+":");
            respostas[pos] = leitor.next().charAt(0);
        }
        for(int pos = 0; pos<respostas.length; pos++){
            if(gabarito[pos]==respostas[pos]){
                nota++;
            }

        }

        System.out.println("Você acertou " + nota + " perguntas");

        String[] palavras = {"casa", "papel", "mercado", "cachorro"};
        for (String elemento:palavras){ //for of
            System.out.println(elemento);

        }

    }
}