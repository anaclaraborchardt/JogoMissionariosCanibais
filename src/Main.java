import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Jogador jogador = new Jogador("ana");
    static Jogo jogo = new Jogo();

    public static void main(String[] args) {
        int opcao;
        int cont = 0;

        do {
            inicio();

            System.out.println("""
                    Deseja colocar mais alguma peça
                    1-SIM
                    2-NÃO
                    3-SAIR""");
            opcao = sc.nextInt();
            cont ++;

            switch(opcao){
                case 2 -> confirmaRodada();
                case 3 -> System.exit(0);
            }

        }while(opcao!=3 || cont!=2);
        valida();
    }

    private static void inicio(){
        int indice;
        System.out.println(jogador.getPersonagens());
        System.out.println("================ " + jogador.getPecasLevar() + " ===================");
        System.out.println(jogador.getPecasDepois());
        System.out.println(jogador.isDireitaEsquerda());

        System.out.println("""
                    Escolha uma peça para colocar no barco: 
                    """);
        indice = sc.nextInt();

        try {
            jogo.procuraPersonagem(indice);
            adicionaLista(indice);
        } catch (PessoaNaoExisteException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void confirmaRodada(){
        System.out.println("""
                    Deseja realmente levar essas peças?
                    1-SIM
                    2-NÃO""");
        int opcao = sc.nextInt();

        switch(opcao){
            case 1:
                valida();
                if(jogador.isDireitaEsquerda()) {
                    jogador.setDireitaEsquerda(false);
                }else{
                    jogador.setDireitaEsquerda(true);
                }
                break;
            case 2:
                trocaPeca();
                break;
        }
    }

    private static void adicionaLista(int indice){
        if(jogador.isDireitaEsquerda()) {
            jogo.verificaPecaDE(indice);
            jogador.getPecasLevar().add(jogador.getPersonagens().get(indice));
            jogador.getPersonagens().remove(jogador.getPersonagens().get(indice));
            jogador.getPecasDepois().add(jogador.getPersonagens().get(indice));

        }else{
            jogo.verificaPecaED(indice);
            jogador.getPecasLevar().add(jogador.getPecasDepois().get(indice));
            jogador.getPersonagens().add(jogador.getPecasDepois().get(indice));
            jogador.getPecasDepois().remove(jogador.getPecasDepois().get(indice));

        }
    }

    private static void valida(){
            if(jogo.verificaLados()) {
                if(jogo.defineGanhador()){
                    System.out.println("Parabéns! Você venceu!");
                    System.exit(0);
                }
                System.out.println("Continua");
        }else{
            System.out.println("Jogo acabou");
            System.exit(0);
        }
        jogador.getPecasLevar().clear();
    }

    private static void trocaPeca(){
        System.out.println("Qual peça deseja trocar? " + jogador.getPecasLevar());
        int indice = sc.nextInt();

        try{
            jogo.procuraNoBarco(indice);
            System.out.println("Deseja trocar por qual peça?");
            int indice2 = sc.nextInt();
            jogador.getPecasLevar().remove(indice);
            if(jogador.isDireitaEsquerda()) {
                jogador.getPecasLevar().add(jogador.getPersonagens().get(indice2));
            }else{
                jogador.getPecasLevar().add(jogador.getPecasDepois().get(indice2));
            }

        }catch(PecaForaDoBarcoException exception){
            System.out.println(exception.getMessage());
        }
    }
}

