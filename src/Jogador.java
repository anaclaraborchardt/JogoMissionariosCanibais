import java.util.ArrayList;

public class Jogador {

    private String nome;
    private ArrayList<Pessoa> personagens = new ArrayList<>();
    private ArrayList<Pessoa> pecasLevar = new ArrayList<>();
    private ArrayList<Pessoa> pecasDepois = new ArrayList<>();
    private int indice = 0;
    private int quantidadeMD = 3;
    private int quantidadeME = 0;
    private int quantidadeCD = 3;
    private int quantidadeCE = 0;
    private boolean DireitaEsquerda = true;


    public Jogador(String nome) {
        this.nome = nome;
        for(int i =0; i<3; i++) {
            personagens.add(new Missionario());
        }
        for(int i =0; i<3; i++) {
            personagens.add(new Canibal());
        }
    }

    public ArrayList<Pessoa> getPersonagens() {
        return personagens;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", personagens=" + personagens +
                ", índice " + indice +
                '}';
    }

    public int getQuantidadeMD() {
        return quantidadeMD;
    }

    public void setQuantidadeMD(int quantidadeMD) {
        this.quantidadeMD = quantidadeMD;
    }

    public int getQuantidadeME() {
        return quantidadeME;
    }

    public void setQuantidadeME(int quantidadeME) {
        this.quantidadeME = quantidadeME;
    }

    public int getQuantidadeCD() {
        return quantidadeCD;
    }

    public void setQuantidadeCD(int quantidadeCD) {
        this.quantidadeCD = quantidadeCD;
    }

    public int getQuantidadeCE() {
        return quantidadeCE;
    }

    public void setQuantidadeCE(int quantidadeCE) {
        this.quantidadeCE = quantidadeCE;
    }

    public ArrayList<Pessoa> getPecasLevar() {
        return pecasLevar;
    }

    public ArrayList<Pessoa> getPecasDepois() {
        return pecasDepois;
    }

    public boolean isDireitaEsquerda() {
        return DireitaEsquerda;
    }

    public void setDireitaEsquerda(boolean direitaEsquerda) {
        DireitaEsquerda = direitaEsquerda;
    }

}
