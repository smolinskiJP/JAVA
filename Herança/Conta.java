package Java.Herança;

public class Conta {

    protected double saldo;

    public double sacar(double valor){
        this.saldo -= valor;
        System.out.println("Seu saldo é: " + this.saldo);
        return valor;
    }

    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Seu saldo é: " + this.saldo);
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void atualiza(double taxa){
        this.saldo += this.saldo * taxa;
        System.out.println("Novo saldo é: " + this.saldo);
    }
}