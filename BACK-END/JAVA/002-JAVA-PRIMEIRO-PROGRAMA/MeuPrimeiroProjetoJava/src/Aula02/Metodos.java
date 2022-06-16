package Aula02;

public class Metodos {
    public static void main(String[]args){
        impressao();
        mensagem("com parametro");
        System.out.println("Parâmetro e retorno: " + dobro( 2 ) );

        System.out.println("sobrecarca 01: " + calc(1,2));
        System.out.println("sobrecarca 02: " + calc(1.5,2.3));
        System.out.println("sobrecarca 03: " + calc(1,2,3));
        System.out.println("sobrecarca 04: " + calc(1,2,5,8));

        double[]notas = {9.5,6.8,5.4,7.0, 6.6,7.1};
        System.out.println("A média das notas é: " + calc(notas));
        System.out.printf("%s%n%.2f","A média das notas é: " , calc(notas));
    }

    //métodos sem retorno e sem parâmetros
    public static void impressao(){
        System.out.println("sem parametro");
    }

    //métodos sem retorno mas com parâmetros
    public static void mensagem(String msg){
        System.out.println(msg);
    }

    //método com retorno e com parâmetro
    public static int dobro(int valor){
        return valor * 2;

    }

    //sobrecarga de métodos --> métodos com mesmo nome porém com assinatura, parametros diferentes
    public static int calc(int num1, int num2){
        return num1 + num2;
    }
    public static double calc(double num1, double num2){
        return num1 + num2;
    }

    public static int calc(int num1, int num2, int num3){
        return num1+num2+num3;
    }
    public static int calc(int ...a){
        return a.length;
    }

    public static double calc(double[] numeros){
        double soma = 0;
        for(double n:numeros){
            soma += n;
        }
        return soma/numeros.length;
    }

}
