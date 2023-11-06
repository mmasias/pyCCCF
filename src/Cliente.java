public class Cliente {

    private int packDeItems;

    public Cliente(int compraMinima, int compraMaxima){
        packDeItems = (int)(Math.random()*(compraMaxima-compraMinima)+compraMinima);
    }

}
