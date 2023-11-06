public class Cliente {

    private int packDeItems;
    private String nombreCliente;

    public Cliente(int compraMinima, int compraMaxima, String nombre) {
        packDeItems = (int) (Math.random() * (compraMaxima - compraMinima) + compraMinima);
        nombreCliente = nombre;
    }

    public void entregaProducto() {
        packDeItems--;
    }

    public boolean tieneProductos() {
        return packDeItems > 0;
    }

    @Override
    public String toString() {
        return "Atendiendo a " + nombreCliente + ". Le quedan : " + packDeItems;
    }
}
