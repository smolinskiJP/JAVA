package Java.Herança;

public class ContaPoupanca extends Conta{
    
    @Override
    public void atualiza(double taxa){
        super.atualiza(3 * taxa);
    }
}