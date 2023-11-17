
class Cliente {
    private final int numItems;
    private int tiempoAtencion;

    public Cliente(int numItems) {
        this.numItems = numItems;
        this.tiempoAtencion = 0;
    }

    public int getNumItems() {
        return numItems;
    }

    public void avanzarTiempo() {
        tiempoAtencion++;
    }

    public boolean estaAtendido() {
        return tiempoAtencion == numItems;
    }
}