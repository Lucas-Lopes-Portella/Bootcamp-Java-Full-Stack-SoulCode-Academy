class EstruturaCondicao{
    public static void main(String[]args){

        //if
        boolean condicao = false;

        if(condicao){
            System.out.println("A condição está verdadeira.");
        } else {
            System.out.println("A condição está falsa.");
        }


        //operador ternario
        int nota = 80;
        int falta = 4;

        if(nota>=70 && falta<5){
            System.out.println("Aluno aprovado!");
        } else if (nota>=60){
            System.out.println("Aluno em recuperação!");
        } else {
             System.out.println("Aluno reprovado!");
        }

        //operador ternário
        String resultado = "";
        resultado = (nota>=70) ? "Aprovado":"Reprovado";
        System.out.println(resultado);

        int posicao = 1;
        switch(posicao){
            case 1: 
                System.out.println("Você chegou em primeiro lugar");
                break;
            case 2: 
                System.out.print("Você chegou em segundo lugar");
                break;
            case 3: 
                System.out.print("Você chegou em terceiro lugar");
                break;
            case 4: case 5: case 6:
                System.out.print("Você ganhou uma menção honrosa");
                break;
            default:
                 System.out.print("Obrigado por participar");
        }

        

    }
}