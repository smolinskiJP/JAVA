package Java.Herança;

public class ContaCorrente extends Conta{
    
    @Override
    public void atualiza(double taxa){
        super.atualiza((2 * taxa));
    }

    @Override
    public void depositar(double valor){
        super.depositar((valor - 0.1));
    }
}