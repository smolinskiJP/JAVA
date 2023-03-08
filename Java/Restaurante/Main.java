package Java.Restaurante;

public class Main {
    public static void main(String[] args) {
        Restaurante buchinho = new Restaurante("Buchinho Cheio", "Coltec - UFMG");
        Mesa m1 = new Mesa();
        Mesa m2 = new Mesa();
        Mesa m3 = new Mesa();

        buchinho.addMesa(m1);
        buchinho.addMesa(m2);
        buchinho.addMesa(m3);
        buchinho.reservar(1, "aniversario do alex");
        buchinho.reservar(2, "dia das criancas");

        Cliente c1 = new Cliente("Alex", "afbtorres@teiacoltec");
        Cliente c2 = new Cliente("Vivi", "vivi@teiacoltec");
        Cliente c3 = new Cliente("Honda", "hh@teiacoltec");
        Cliente c4 = new Cliente("Thales", "6969@teiacoltec");
        Cliente c5 = new Cliente("SMOLINHA", "1450@teiacoltec");
        Cliente c6 = new Cliente("Vacilão", "1566@teiacoltec");

        buchinho.addClienteReserva(c1, 1);
        buchinho.addClienteReserva(c2, 1);
        buchinho.addClienteReserva(c3, 2);
        buchinho.addClienteReserva(c4);
        buchinho.addClienteReserva(c5);
        buchinho.addClienteReserva(c6);

        buchinho.printaMesas();
        System.out.println();

        buchinho.fazerPedido(0, 60, "MegaPorção de fritas ");
        buchinho.fazerPedido(0, 90, "Vinho da melhor qualidade ");
        buchinho.fazerPedido(1, 60, "Frutos do mar");
        buchinho.fazerPedido(2, 1000, "Bebida envelhecida por 500 anos em barril de carvalho escuro da noruega");
        System.out.println();

        buchinho.encerrar(0);
        buchinho.encerrar(1);
        buchinho.encerrar(2);
    }
}