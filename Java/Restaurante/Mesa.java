package Java.Restaurante;

import java.util.LinkedList;

public class Mesa {
    private String data;
    private boolean reserv = false;
    private LinkedList<Cliente> clientes = new LinkedList<Cliente>();
    private Comanda comanda;
    private static int maxMesa = 4;

    public boolean reservar(String d){
        if (reserv == true && data.equals(d) == true) return false;
        else {
            this.data = d;
            this.reserv = true;
            return true;
        }
    }

    public void fazerPedido(double valor, String desc){
        this.comanda.addConsumo(desc, valor);
    }

    public void encerrar(){
        System.out.print("Itens pedidos: ");
        this.comanda.listarConsumo();
        System.out.println("Valor total: " + comanda.getValor());
        System.out.println("Valor com 10%: " + comanda.dezPorcento());
        System.out.println("Valor para cada cliente: " + comanda.divConta(clientes.size()));
        this.clientes.clear();
        this.comanda.divConta(clientes.size());
    }

    public void addCliente(Cliente c){
        if (clientes.size() == 0) {
            comanda = new Comanda();
        } else if (clientes.size() >= (maxMesa - 1)){
            this.reserv = true;
            this.data = "CHEIO";
        }
        clientes.add(c);
    }

    public void cancelaReserv(){
        this.reserv = false;
        this.data = null;
    }


    public String getData(){
        return this.data;
    }

    public boolean getReserv(){
        return this.reserv;
    }

    public LinkedList<Cliente> getClientes(){
        return this.clientes;
    }
}