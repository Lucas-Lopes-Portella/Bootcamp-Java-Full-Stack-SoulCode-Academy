public class AloMundo {
    public static void main (String[]args){
        //prints
        System.out.println("Alô mundo!!");
        byte idade = 40;
        System.out.println(idade);
        System.out.println("texto");
        System.out.printf("%s%n", "Exemplo de print com printf");

        //operadores aritméticos
        // + - * / %
        short num1 = 5;
        short num2 = 2;
        short num3 = 5%2;

       /* 
       long x = 10;
       short y = x;
       System.out.println(y); 
       // erro, pois a variável short cabe dentro do long, porém a variável long não cabe dentro do short
       */
        //forma correta de fazer (casting): 
        long x = 10;
       short y = (short) x;
       System.out.println(y); 
        double doub = 2.0d;
       System.out.printf("%.1f",doub);
    }
}
