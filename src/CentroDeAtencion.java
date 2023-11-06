public class CentroDeAtencion {

    private Cola miCola;
    private Caja miCaja;

    CentroDeAtencion(Cola cola) {
        miCola = cola;
        miCaja = new Caja();
    }

    public void atiende() {
        if (miCola.tienePersonas() & miCaja.estaLibre()) {
            Cliente unCliente = miCola.removeCliente();
            miCaja.recibe(unCliente);
        }
        miCaja.atiende();
    }
}
