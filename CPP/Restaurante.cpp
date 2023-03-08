#include <iostream>
#include <string>
#include <list>

#define SUCESSO 0

using namespace std;

class Cliente {
    private : 
        string nome;
        string email;

    public : 
        void setNome(string n){
            this->nome = n;
        }

        void setEmail(string e){
            this->email = e;
        }    

        string getNome(){
            return this->nome;
        }

        string getEmail(){
            return this->email;
        }

};

class Comanda {
    private : 
        string consumo;
        double valor;

    public : 
        void listarConsumo(){
            cout << this->consumo;
        }

        double dez100(){
            return (this->valor / 10.0);
        }

        double divConta(int numPer){
            return ( this->valor / (numPer * 1.0) );
        }

        void addConsumo(string prod, double val){
            this->valor += val;
            this->consumo += prod;
            this->consumo += "\n";
        }
        double getValor(){
            return this->valor;
        }

};

class Mesa {
    private : 
        int numMesa;
        string data;
        bool resev;
        string nomeResev;
        list<Cliente *> clientes;
        Comanda * cmd;
        bool vazia;

    public : Mesa(){
        this->cmd = new Comanda();
        this->resev = false;
        this->vazia = true;
    }
 
        void pedir(string prod, double val){
            this->cmd->addConsumo(prod, val);
        }

        double divConta(){
            return cmd->divConta(clientes.size());
        }

        void addCliente(Cliente * cl){
            this->clientes.push_back(cl);
            this->vazia = false;
        }

        int getNumMesa(){
            return this->numMesa;
        }

        string getData(){
            return this->data;
        }

        bool getResev(){
            return this->resev;
        }

        bool reseva(string d, string n){
            if(this->resev == 0){
                return false;
            }
            else{
                if(this->data == d && this->nomeResev == n){
                    return true;
                }
                else{
                    return false;
                }
            }
        }

        int quantCli(){
            return this->clientes.size();
        }

        void reservar(string d, string n){
            if(this->resev == false){
                this->resev = true;
                this->data = d;
                this->nomeResev = n;
            }
        }
        
        void setNumMesa(int n){
        	this->numMesa = n;
        }
        
        void showStatus(){
            cout << "Mesa num " << numMesa << "\n" << "Possui " << this->quantCli() << " clientes" << "\n";
            if(this->resev == true){
                cout << "Esta reservada para o dia " << this->data << " para " << this->nomeResev << "\n";
            }
            else{
                cout << "Nao esta reservada" << "\n";
            }
            cout << "Produtos pedidos: " << "\n";
            this->cmd->listarConsumo();
            cout << "No valor de " << this->cmd->getValor() << "\n";
        }

};

class Restaurante {
    private : 
        string nome;
        string end;
        list<Mesa *> mesas;

    public : 
        Restaurante(string n, string e){
            this->nome = n;
            this->end = e;
            Mesa * tmp = new Mesa();
            tmp->setNumMesa(1);
            this->mesas.push_back(tmp);
        }

        Restaurante(){
            Mesa * tmp = new Mesa();
            tmp->setNumMesa(1);
            this->mesas.push_back(tmp);
        }

        void setNome(string n){
            this->nome = n;
        }

        void setEnd(string e){
            this->end = e;
        }

        string getNome(){
            return this->nome;
        }

        string getEnd(){
            return this->end;
        }

        void addMesa(){
            Mesa * tmp = new Mesa();
            tmp->setNumMesa(this->quantMesa() + 1);
            this->mesas.push_back(tmp);
            cout << "Mesa " << this->quantMesa() << " foi adicionada." <<"\n";
        }

        list<Mesa *> getMesas(){
            return this->mesas;
        }

        int quantMesa(){
            return this->mesas.size();
        }
		
		void showStatus(){
			for(Mesa * i: this->mesas){
				i->showStatus();
				cout << "\n";
			}
		}

        void addCli(string n, string e, int m){
            Cliente * cl = new Cliente();
            bool a = false;
            cl->setNome(n);
            cl->setEmail(e);
            for(Mesa * i : this->mesas){
                if(i->getNumMesa() == m && i->getResev() == false){
                    i->addCliente(cl);
                    a = true;
                }
            }
            
            if(a == false){
                cout << "Nao foi possivel adicionar cliente na mesa " << m << "\n";
            }
        }

        void resevMesa(string d, string n, int m){
            bool a = false;
            for(Mesa * i : this->mesas){
                if(i->getNumMesa() == m && i->getResev() == false){
                    i->reservar(d, n);
                    a = true;
                }
            }
            
            if(a == false){
                cout << "Nao foi possivel reservar a mesa " << m << "\n";
            }
        }

        void pedirMesa(string p, double val, int m){
            bool a = false;
            for(Mesa * i : this->mesas){
                if(i->getNumMesa() == m){
                    i->pedir(p, val);
                    a = true;
                }
            }
            
            if(a == false){
                cout << "Nao foi possivel pedir para a mesa " << m << "\n";
            }
        }
        void dividir(int m){
            bool a = false;
            for(Mesa * i : this->mesas){
                if(i->getNumMesa() == m){
                    cout << "Cada um dos " << i->quantCli() << " clientes paga " << i->divConta() << " reais\n";
                    a = true;
                }
            }
            
            if(a == false){
                cout << "Nao foi possivel acessar mesa " << m << "\n";
            }
        }

};

int main(){

    Restaurante * alex = new Restaurante("Cozinha do Alex", "rua a");
    int in = 1, m, v;
    string nome, email, data;

    cout << alex->getNome() << "\t" << alex->getEnd() << "\n"; 
    
    while(in != 0){
        cout << "1- Add Mesa\n2- Add Cliente\n3- Pedir\n4- Reservar Mesa\n5- Div Conta\n6- Status\n0- Exit\n";
        cin >> in;
        if(in == 1){
            alex->addMesa();
        }
        else if(in == 2){
            cout << "Nome do cliente: ";
            cin >> nome;
            cout << "Email do cliente: ";
            cin >> email;
            cout << "Mesa: ";
            cin >> m;
            alex->addCli(nome, email, m);
        }
        else if(in == 3){
            cout << "Mesa: ";
            cin >> m;
            cout << "Produto: ";
            cin >> nome;
            cout << "Valor: ";
            cin >> v;
            alex->pedirMesa(nome, v, m);
        }
        else if(in == 4){
            cout << "Mesa: ";
            cin >> m;
            cout << "Nome: ";
            cin >> nome;
            cout << "Data: ";
            cin >> data;
            alex->resevMesa(data, nome, m);
        }
        else if(in == 5){
            cout << "Mesa: ";
            cin >> m;
            alex->dividir(m);
        }
        else if(in == 6){
            alex->showStatus();
        }

    }

    return SUCESSO;
}