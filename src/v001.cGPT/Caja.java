class Caja {
    private static int contador = 0;
    private final int id;
    private Cliente cliente;
    private int tiempoSinCola;

    public Caja() {
        this.id = ++contador;
        this.cliente = null;
        this.tiempoSinCola = 0;
    }

    public int getId() {
        return id;
    }

    public boolean estaLibre() {
        return cliente == null;
    }

    public void atenderCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void avanzarTiempo() {
        if (cliente != null) {
            cliente.avanzarTiempo();
            if (cliente.estaAtendido()) {
                cliente = null;
            }
        } else {
            tiempoSinCola++;
        }
    }

    public int getTiempoSinCola() {
        return tiempoSinCola;
    }
}