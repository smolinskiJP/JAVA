using System;
using System.Windows.Forms;
using System.Drawing;
using System.Collections.Generic;

/*
Trabalho + Graphic User Interface
*/

namespace prova{

    class Cliente {
        private string nome;
        private string email;

        public void setNome(string n){
            this.nome = n;
        }

        public void setEmail(string e){
            this.email = e;
        }    

        public string getNome(){
            return this.nome;
        }

        public string getEmail(){
            return this.email;
        }

    }


    abstract class Comanda {
        private string consumo;
        private double valor;

        public string listarConsumo(){
            return this.consumo;
        }

        public double dez100(){
            return (this.valor / 10.0);
        }

        public double divConta(int numPer){
            return ( (this.valor + this.dez100()) / (numPer * 1.0) );
        }

        public void addConsumo(string prod, double val){
            this.valor += val;
            this.consumo += prod;
            this.consumo += "\n";
        }

        public double getValor(){
            return this.valor;
        }


    }

    class ComandaBebida : Comanda{
        public bool ehComida(){
            return false;
        }
    }

      class ComandaComida : Comanda{
        public bool ehComida(){
            return true;
        }
    }


    class Mesa {
        private int numMesa;
        private string data;
        private bool resev;
        string nomeResev;
        private List<Cliente> clientes;
        private Comanda cmdB;
        private Comanda cmdC;
        private bool vazia;

        public Mesa(){
            this.clientes = new List<Cliente>();
            this.resev = false;
            this.vazia = true;
        }

        public void pedir(bool comi, string prod, double val){
            if(this.vazia == false){
                if(comi == true){
                    this.cmdC.addConsumo(prod, val);
                }
                else{
                    this.cmdB.addConsumo(prod, val);
                }
            }
            else{
                System.Console.WriteLine("Nao ha clientes na mesa");
            }
        }

        public double divConta(){
            double v = cmdC.divConta(clientes.Count) + cmdB.divConta(clientes.Count);
            cmdC = null;
            cmdB = null;
            this.clientes.Clear();
            this.clientes.Clear();
            return v;
        }

        public void addCliente(Cliente cl){
            if(clientes.Count == 0 ) {
                this.cmdB = new ComandaBebida();
                this.cmdC = new ComandaComida();
            }
            this.clientes.Add(cl);
            this.vazia = false;
        }

        public int getNumMesa(){
            return this.numMesa;
        }

        public string getData(){
            return this.data;
        }

        public bool getResev(){
            return this.resev;
        }

        public bool reseva(string d){
            if(this.resev == false){
                return false;
            }
            else{
                if(this.data == d){
                    return true;
                }
                else{
                    return false;
                }
            }
        }

        public int quantCli(){
            return this.clientes.Count;
        }

        public void reservar(string d, string n){
            if(this.resev == false){
                this.resev = true;
                this.data = d;
                this.nomeResev = n;
            }
        }

        public void setNumMesa(int n){
            this.numMesa = n;
        }

        public string showStatus(){
            string ss = "";

            ss += "Mesa num " + numMesa + "\nPossui " + this.quantCli() + " clientes\n";
            if(this.resev == true){
                ss += "Esta reservada para o dia " + this.data + " para " + this.nomeResev;
            }
            else{
                ss += "Nao reservada";
            }
            if(this.clientes.Count != 0){
                //ss += "\nProdutos pedidos:\n\tBEBIDAS:\n";
                ss += this.cmdB.listarConsumo();
                //ss += "\tCOMIDAS:\n";
                ss += this.cmdC.listarConsumo();
                ss += "No valor de " + Convert.ToString( this.cmdC.getValor() +  this.cmdB.getValor() );
            }
            else{
                ss += "\nMesa vazia";
            }
            //MessageBox.Show(ss);
            return ss;
        }

    }

    class Restaurante {
        private string nome;
        private string end;
        private List<Mesa> mesas;

        public Restaurante(string n, string e){
            this.nome = n;
            this.end = e;
            mesas = new List<Mesa>();
            Mesa tmp = new Mesa();
            tmp.setNumMesa(1);
            this.mesas.Add(tmp);
        }

        public Restaurante(){
            mesas = new List<Mesa>();
            Mesa tmp = new Mesa();
            tmp.setNumMesa(1);
            this.mesas.Add(tmp);
        }

        public void setNome(string n){
            this.nome = n;
        }

        public void setEnd(string e){
            this.end = e;
        }

        public string getNome(){
            return this.nome;
        }

        public string getEnd(){
            return this.end;
        }

        public void addMesa(){
            Mesa tmp = new Mesa();
            tmp.setNumMesa(this.quantMesa() + 1);
            this.mesas.Add(tmp);
            MessageBox.Show("Mesa " + this.quantMesa() + " adicionada");
        }

        public List<Mesa> getMesas(){
            return this.mesas;
        }

        public int quantMesa(){
            return this.mesas.Count;
        }

        public void showStatus(){
            string ss = "";
			foreach(Mesa i in this.mesas){
				ss += i.showStatus();
                ss += "\n\n";
			}
            MessageBox.Show(ss);
		}

        public void addCli(string n, string e, int m){
            Cliente cl = new Cliente();
            bool a = false;
            cl.setNome(n);
            cl.setEmail(e);
            foreach(Mesa i in this.mesas){
                if(i.getNumMesa() == m && i.getResev() == false){
                    i.addCliente(cl);
                    a = true;
                }
            }
            
            if(a == false){
                MessageBox.Show("Nao foi possivel adicionar cliente na mesa " + m );
            }
            else{
                MessageBox.Show("Cliente Adicionado com sucesso");
            }
        }

         public void resevMesa(string d, string n, int m){
            bool a = false;
            foreach(Mesa i in this.mesas){
                if(i.getNumMesa() == m && i.getResev() == false){
                    i.reservar(d, n);
                    a = true;
                    MessageBox.Show("Mesa Reservada com SUCESSO");
                }
            }
            
            if(a == false){
                MessageBox.Show("Nao foi possivel reservar a mesa " + m);
            }
        }

        public void pedirMesa(bool comi, string p, double val, int m){
            bool a = false;
            foreach(Mesa i in this.mesas){
                if(i.getNumMesa() == m){
                    i.pedir(comi, p, val);
                    a = true;
                }
            }
            
            if(a == false){
                MessageBox.Show("Nao foi possivel pedir para a mesa " + m);
            }
            else{
                MessageBox.Show("Pedido com SUCESSO");
            }
        }

        public void dividir(object sender, EventArgs e, Form nf, int m){
            bool a = false;
            foreach(Mesa i in this.mesas){
                if(i.getNumMesa() == m){
                    MessageBox.Show("Cada um dos " + i.quantCli() + " clientes paga " + i.divConta() + " reais (com os 10%)");
                    a = true;
                }
            }
            
            if(a == false){
                MessageBox.Show("Nao foi possivel acessar mesa " + m);
            }
            nf.Hide();
        }

    }
    public class Gui{
        public static Form f = new Form(); 
        static Restaurante Res = new Restaurante();
        static TextBox tb = new TextBox();

        public static void AddMesa(object sender, EventArgs e){
            Gui.Res.addMesa();
        }

        public static void AC(object sender, EventArgs e, Form tf, string nam, string em, int ms){
            Gui.Res.addCli(nam, em, ms);
            tf.Hide();
        }

        public static void pd(object sender, EventArgs e, Form tf, int mm, string p, double val){
            Gui.Res.pedirMesa(true, p, val, mm);
            tf.Hide();
        }

        public static void Pedir(object s, EventArgs e){
            Form nf = new Form();

            nf.Size = new Size(150, 200);

            Label l1 = new Label();
            l1.Text = "Mesa:";
            l1.Location = new Point(10,0);
            TextBox t1 = new TextBox();
            t1.Location = new Point(10, 20);

            Label l2 = new Label();
            l2.Text = "Pedido:";
            l2.Location = new Point(10, 40);
            TextBox t2 = new TextBox();
            t2.Location = new Point(10, 60);

            Label l3 = new Label();
            l3.Text = "Valor:";
            l3.Location = new Point(10, 80);
            TextBox t3 = new TextBox();
            t3.Location = new Point(10, 100);

            Button bt = new Button();
            bt.Text = "OK";
            bt.Location = new Point(20, 120); 
            bt.Click += (sender, EventArgs) => {pd(sender, EventArgs, nf, Convert.ToInt32(t1.Text), t2.Text, Convert.ToDouble(t3.Text)); };


            nf.Controls.Add(l1);
            nf.Controls.Add(l2);
            nf.Controls.Add(l3);
            
            nf.Controls.Add(t1);
            nf.Controls.Add(t2);
            nf.Controls.Add(t3);

            nf.Controls.Add(bt);

            Application.Run(nf);
        }

        public static void AddCliente(object s, EventArgs e){
            Form nf = new Form();

            nf.Size = new Size(150, 200);

            Label l1 = new Label();
            l1.Text = "Nome:";
            l1.Location = new Point(10,0);
            TextBox t1 = new TextBox();
            t1.Location = new Point(10, 20);

            Label l2 = new Label();
            l2.Text = "Email:";
            l2.Location = new Point(10, 40);
            TextBox t2 = new TextBox();
            t2.Location = new Point(10, 60);

            Label l3 = new Label();
            l3.Text = "Mesa:";
            l3.Location = new Point(10, 80);
            TextBox t3 = new TextBox();
            t3.Location = new Point(10, 100);

            Button bt = new Button();
            bt.Text = "OK";
            bt.Location = new Point(20, 120); 
            bt.Click += (sender, EventArgs) => {AC(sender, EventArgs, nf, t1.Text, t2.Text, Convert.ToInt32(t3.Text)); };


            nf.Controls.Add(l1);
            nf.Controls.Add(l2);
            nf.Controls.Add(l3);
            
            nf.Controls.Add(t1);
            nf.Controls.Add(t2);
            nf.Controls.Add(t3);

            nf.Controls.Add(bt);

            Application.Run(nf);
        }

        public static void RM(object sender, EventArgs e, Form nf, string nome, string data, int mesa){
            Gui.Res.resevMesa(data, nome, mesa);
            nf.Hide();
        }

        public static void ResevMesa(object s, EventArgs e){
            Form nf = new Form();

            nf.Size = new Size(150, 200);

            Label l1 = new Label();
            l1.Text = "Nome:";
            l1.Location = new Point(10,0);
            TextBox t1 = new TextBox();
            t1.Location = new Point(10, 20);

            Label l2 = new Label();
            l2.Text = "Mesa:";
            l2.Location = new Point(10, 40);
            TextBox t2 = new TextBox();
            t2.Location = new Point(10, 60);

            Label l3 = new Label();
            l3.Text = "Data:";
            l3.Location = new Point(10, 80);
            TextBox t3 = new TextBox();
            t3.Location = new Point(10, 100);

            Button bt = new Button();
            bt.Text = "OK";
            bt.Location = new Point(20, 120); 
            bt.Click += (sender, EventArgs) => {RM(sender, EventArgs, nf, t1.Text, t3.Text ,Convert.ToInt32(t2.Text)); };


            nf.Controls.Add(l1);
            nf.Controls.Add(l2);
            nf.Controls.Add(l3);
            
            nf.Controls.Add(t1);
            nf.Controls.Add(t2);
            nf.Controls.Add(t3);

            nf.Controls.Add(bt);

            Application.Run(nf);
        }

        public static void Div(object s, EventArgs e){
            Form nf = new Form();

            nf.Size = new Size(150, 100);

            Label l1 = new Label();
            l1.Text = "Mesa:";
            l1.Location = new Point(10,0);
            TextBox t1 = new TextBox();
            t1.Location = new Point(10, 20);

            Button bt = new Button();
            bt.Text = "OK";
            bt.Location = new Point(20, 40); 
            bt.Click += (sender, EventArgs) => {Gui.Res.dividir(sender, EventArgs, nf, Convert.ToInt32(t1.Text)); };

            nf.Controls.Add(l1);
            nf.Controls.Add(t1);

             nf.Controls.Add(bt);

            Application.Run(nf);

        }

        public static void BtFunc(object sender, EventArgs e){
            int cod = Convert.ToInt32(Gui.tb.Text);
            if(cod == 1){
                AddMesa(sender, e);
            }
            else if(cod == 2){
                AddCliente(sender, e);
            }
            else if(cod == 3){
                Pedir(sender, e);
            }
            else if(cod == 4){
                ResevMesa(sender, e);
            }
            else if(cod == 5){
                Div(sender, e);
            }
            else if(cod == 6){
                Gui.Res.showStatus();
            }
            else if(cod == 0){
                Gui.f.Close();
            }
        }

        static void Main(string[] args)
        {
            Gui.f.Size = new Size(150, 200);

            var lb0 = new Label();
            var lb1 = new Label();
            var lb2 = new Label();
            var lb3 = new Label();
            var bt = new Button();
            
            bt.Click += BtFunc;

            lb0.Text = "1- Add Mesa\n2- Add Cliente";
            lb1.Text = "3- Pedir\n4- Reservar Mesa";
            lb2.Text = "5- Div Conta\n6- Status";
            lb3.Text = "0- Exit";
            lb0.Location = new Point(10, 10);
            lb1.Location= new Point(10, 30);
            lb2.Location = new Point(10, 50);
            lb3.Location = new Point(10, 70);

            var lc = new Label();
            lc.Text = "Cod: ";
            lc.Location = new Point(10, 90); 
            f.Controls.Add(lc);

            f.Controls.Add(lb0);
            f.Controls.Add(lb1);
            f.Controls.Add(lb2);
            f.Controls.Add(lb3);
            tb.Location = new Point(10, 110); 
            f.Controls.Add(tb);
            bt.Location = new Point(20, 135);
            bt.Text = "OK";
            f.Controls.Add(bt);

            Application.Run(f);
        }
    }
}