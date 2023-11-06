package v000;

public class Caja {

    private boolean abierta;
    private Cliente cliente;
    private String nombreDeCaja;

    Caja(String nombre) {
        this.abierta = true;
        this.nombreDeCaja = nombre;
    }

    public boolean estaLibre() {
        return abierta;
    }

    public void recibe(Cliente unCliente) {
        abierta = false;
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
            abierta = true;
        }
    }
}
