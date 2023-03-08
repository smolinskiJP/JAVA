package Java.Herança;

public class Main {
    public static void main(String[] args) {
        
        Conta c1 = new Conta();
        ContaCorrente c2 = new ContaCorrente();
        ContaPoupanca c3 = new ContaPoupanca();

        c1.depositar(1000);
        c2.depositar(1000);
        c3.depositar(1000);
        System.out.println();

        Banco b = new Banco();
        b.adicionaConta(c1);
        b.adicionaConta(c2);
        b.adicionaConta(c3);
        System.out.println("TOTAL DO BANCO: " + b.Relatorio(0.09));
    }
}