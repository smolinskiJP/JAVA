package Java.Instapet;

public class InstaPet {

    private int numUsuarios = 0;
    private int maxUsuarios = 1;
    private Usuário[] usuarios = new Usuário[maxUsuarios];

    //funcao de print
    public void mostra(){
        System.out.println("Instapet");
        for (int i = 0; i < this.numUsuarios; i++){
            System.out.println("Usuario " + (i + 1));
            this.usuarios[i].mostra();
        }
    }

    //funcao para cadastrar foto
    public void cadastra_foto(String email, String url, String desc){
        int indiceUser = identifica_usuario(email);
        if (indiceUser < 0){
            System.out.println("Usuario inválido");
        } else {
            this.usuarios[indiceUser].cadastra_foto(url, desc);
        }
    }

    public int identifica_usuario(String email){
        //identifica qual o usuario que tem esse email
        for (int i = 0; i < this.numUsuarios; i++){
            if (this.usuarios[i].getEmail() == email){
                return i;
            }
        }
        //caso não exista nenhum usuario com esse email
        return -1;
    }

    //funcao para checar se o vetor de usuarios chegou ao fim
    public void checaTamanho(){
        if (this.numUsuarios >=  this.maxUsuarios){
            this.maxUsuarios += this.maxUsuarios;
            Usuário[] tmp = new Usuário[this.maxUsuarios];
            for (int i = 0; i < this.numUsuarios; i++){
                tmp[i] = this.usuarios[i];
            }
            this.usuarios = tmp;
        }
    }

    //funcao para cadastrar um usuario
    public void cadastra_usuario(String nome, String email){
        checaTamanho();
        for (int i = 0; i < this.numUsuarios; i++){
            if (this.usuarios[i].getEmail() == email) {
                System.out.println("Email já cadastrado");
                return;
            }
        }
        this.usuarios[this.numUsuarios] = new Usuário();
        this.usuarios[this.numUsuarios].setNome(nome);
        this.usuarios[this.numUsuarios].setEmail(email);
        this.numUsuarios++;
    }

    //funcao q retorna a quantidade de fotos de um determinado user
    public int qnt_pets(String email){
        int indiceUser = identifica_usuario(email);
        if (indiceUser < 0){
            System.out.println("Usuario inválido");
            return -1;
        } else {
            return this.usuarios[indiceUser].qnt_petsU();
        }
    }

    //funcao q retorna a quantidade de users
    public int qnt_usuarios(){
        return this.usuarios[0].qnt_usuariosU();
    }

    //funcao q retorna o vetor de fotos de um user
    public Fotos[] listar_pets(String email){
        int indiceUser = identifica_usuario(email);
        if (indiceUser < 0){
            System.out.println("Usuario inválido");
            return null;
        } else {
            return this.usuarios[indiceUser].getFotos();
        }
    }

    //funcao q retorna o vetor de users
    public Usuário[] listar_usuario(){
        return this.usuarios;
    }

    //funcao q altera a descricao da foto n de um user
    public void altera_descricao(String email, int n, String desc){
        int indiceUser = identifica_usuario(email);
        if (indiceUser < 0){
            System.out.println("Usuario inválido");
        } else {
            this.usuarios[indiceUser].altera_descricao(n, desc);
        }
    }
}