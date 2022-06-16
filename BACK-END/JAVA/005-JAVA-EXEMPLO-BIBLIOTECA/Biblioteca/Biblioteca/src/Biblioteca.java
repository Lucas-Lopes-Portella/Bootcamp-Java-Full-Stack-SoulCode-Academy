public class Biblioteca {
    public static void main(String[] args) {
        LivroFisico lf1 = new LivroFisico("O senhor das moscas",2);

        System.out.println(lf1.verificarDisponibilidade());
        lf1.emprestarLivro();
        System.out.println(lf1.getQuantidade());
        lf1.emprestarLivro();
        System.out.println(lf1.verificarDisponibilidade());
        System.out.println(lf1.getQuantidade());
        lf1.emprestarLivro();
        Ebook le1 = new Ebook("Nome do livro");
        System.out.println(le1.verificarDisponibilidade());
        le1.emprestarLivro();
        le1.emprestarLivro();
        System.out.println(le1.verificarDisponibilidade());
    }
}
