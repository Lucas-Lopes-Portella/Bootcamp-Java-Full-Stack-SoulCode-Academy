import com.sun.source.tree.NewArrayTree;

public class Principal {
    public static void main(String[] args) {
//        Conta c1 = new Conta ("Lopes", "123456", "123X",500);
//        Conta c2 = new Conta ("Amanda", "654321", "123X",4500);
//        Conta c3 = new Conta ("Fe", "321456", "123X",2000);
//
//        c1.mostrarDados();
//        c2.mostrarDados();
//        c3.mostrarDados();

        ContaCorrente c1 = new ContaCorrente("Lopes", "123456","123X", 500);
        ContaCorrente c2 = new ContaCorrente ("Amanda", "654321", "123X",4500);
        c1.mostrarDados();
        c2.mostrarDados();

        c1.sacar(400);
        c1.depositar(4400);

        ContaEspecial ce1 = new ContaEspecial("Fe","123579","X123",-200,800);
        ce1.mostrarDados();
        ce1.sacar(300);
        ce1.depositar(600);
    }
}