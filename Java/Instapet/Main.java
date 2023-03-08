package Java.Instapet;

public class Main {
    //classe main
    public static void main(String[] args) {
        InstaPet instapet = new InstaPet();

        //cadastro de 2 usuarios e 3 fotos
        instapet.cadastra_usuario("Leonardo", "2021951566@teiacoltec.org");
        instapet.cadastra_usuario("João Pedro", "2021951450@teiacoltec.org");
        instapet.cadastra_foto("2021951450@teiacoltec.org", "https://mail.google.com", "Meu pet virtual");
        instapet.cadastra_foto("2021951566@teiacoltec.org", "https://www.coltec.ufmg.br/coltec-ufmg/", "Meu gatinho chamado grêmio");
        instapet.cadastra_foto("2021951450@teiacoltec.org", "https://instagram.com", "Meu cachorrinho");

        //erros
        instapet.cadastra_foto("EMAIL INVALIDO TESTE", "https://malware.com", "foto inexistente"); //email não existente
        instapet.altera_descricao("2021951450@teiacoltec.org", 10, "FOTO INEXISTENTE"); //numero de foto (10) não existe
        instapet.cadastra_usuario("EMAIL JA CADASTRADO TESTE", "2021951450@teiacoltec.org"); //email ja foi usado por outro usuario (como o email é a "chave de acesso" resolvi criar esse erro)

        //print do instapet
        instapet.mostra();

        System.out.println("-----------------------------------------------------------------");
        //alterar descricao de foto
        instapet.altera_descricao("2021951450@teiacoltec.org", 1, "Hoje ele completou 1 aninho, o tempo voa");
        instapet.mostra();


        System.out.println("-----------------------------------------------------------------");
        //mostragem das funcoes de listar e qnt
        Usuário[] listaUsers = instapet.listar_usuario();
        for (int i = 0; i < instapet.qnt_usuarios(); i++) {
            System.out.println(listaUsers[i].getNome());
        }
        Fotos[] galeriaSmola = instapet.listar_pets("2021951450@teiacoltec.org");
        if (galeriaSmola != null){
            for (int i = 0; i < instapet.qnt_pets("2021951450@teiacoltec.org"); i++){
                System.out.println(galeriaSmola[i].getDescricao());
            }
        }
        System.out.println(instapet.qnt_pets("2021951566@teiacoltec.org") + " " + instapet.qnt_usuarios());
    } 
}