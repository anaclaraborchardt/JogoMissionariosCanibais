public class Jogo {

    public Pessoa procuraPersonagem(int indice) throws PessoaNaoExisteException {
        if(indice > Main.jogador.getPersonagens().size()){
            throw new PessoaNaoExisteException();
        }else {
            for (Pessoa pessoa : Main.jogador.getPersonagens()) {
                if (pessoa == Main.jogador.getPersonagens().get(indice)) {
                    return pessoa;
                }
            }
        }
        throw new PessoaNaoExisteException();
    }

    public Pessoa procuraNoBarco(int indice) throws PecaForaDoBarcoException {
        if(indice > Main.jogador.getPecasLevar().size()){
            throw new PecaForaDoBarcoException();
        }else {
            for (Pessoa pessoaLevar : Main.jogador.getPecasLevar()) {
                if (pessoaLevar == Main.jogador.getPecasLevar().get(indice)) {
                    return pessoaLevar;
                }
            }
        }
        throw new PecaForaDoBarcoException();
    }

    public boolean verificaLados() {
        if(Main.jogador.getQuantidadeMD() >= Main.jogador.getQuantidadeCD() ||
                Main.jogador.getQuantidadeME() >= Main.jogador.getQuantidadeMD()
        ){
            return true;
        }
        return false;
    }

    public void verificaPecaDE (int indice){
        if (Main.jogador.getPersonagens().get(indice) instanceof Missionario) {
            Main.jogador.setQuantidadeMD(Main.jogador.getQuantidadeMD() - 1);
            Main.jogador.setQuantidadeME(Main.jogador.getQuantidadeME() + 1);
        }else {
            Main.jogador.setQuantidadeCD(Main.jogador.getQuantidadeCD() - 1);
            Main.jogador.setQuantidadeCE(Main.jogador.getQuantidadeCE() + 1);
        }
    }

    public void verificaPecaED (int indice){
        if (Main.jogador.getPecasDepois().get(indice) instanceof Missionario) {
            Main.jogador.setQuantidadeMD(Main.jogador.getQuantidadeMD() + 1);
            Main.jogador.setQuantidadeME(Main.jogador.getQuantidadeME() - 1);
        }else {
            Main.jogador.setQuantidadeCD(Main.jogador.getQuantidadeCD() + 1);
            Main.jogador.setQuantidadeCE(Main.jogador.getQuantidadeCE() - 1);
        }
    }

    public boolean defineGanhador(){
        if(Main.jogador.getQuantidadeCE() == 3 &&
                Main.jogador.getQuantidadeME() == 3){
            return true;
        }
        return false;
    }

}
