public class PessoaNaoExisteException extends Exception{

    public PessoaNaoExisteException() {
        super("Esse personagem não existe");
    }
}
