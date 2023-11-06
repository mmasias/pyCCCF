
public class Caja {

    private boolean abierta;
    private Cliente cliente;

    Caja() {
        this.abierta = true;
    }

    public boolean estaLibre() {
        return abierta;
    }

    public void recibe(Cliente unCliente) {
        abierta = false;
        cliente = unCliente;
        System.out.println("Caja Ocupada");
    }

    public void atiende() {
        cliente.entregaProducto();
        System.out.println(cliente.toString());
        despacha();
    }

    private void despacha() {
        if (!cliente.tieneProductos()) {
            cliente = null;
            abierta = true;
            System.out.println("Caja libre");
        }
    }
}
