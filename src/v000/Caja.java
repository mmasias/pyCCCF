package v000;

public class Caja {

    private boolean libre;
    private Cliente cliente;
    private String nombreDeCaja;

    Caja(String nombre) {
        this.libre = true;
        this.nombreDeCaja = nombre;
    }

    public boolean estaLibre() {
        return libre;
    }

    public void recibe(Cliente unCliente) {
        libre = false;
        cliente = unCliente;
    }

    public void atiende() {
        cliente.entregaProducto();
        System.out.println("Caja [" + nombreDeCaja + "] atendió a " + cliente.toString());
        despacha();
    }

    private void despacha() {
        if (!cliente.tieneProductos()) {
            cliente = null;
            libre = true;
        }
    }
}
