class CentroComercial {

    double probabilidadLlegada;
    double horaApertura, horaCierre;
    boolean estaAbierto;
    double hora;
    final double UN_MINUTO = 1 / 60;
    final int COMPRA_MINIMA = 5;
    final int COMPRA_MAXIMA = 15;
    Cajas cajas;
    Cola cola;

    CentroComercial() {
        probabilidadLlegada = 0.6;
        horaApertura = 9;
        horaCierre = 21;
        hora = horaApertura;
        estaAbierto = hora >= horaApertura ? true : false;
    }

    public void funciona() {
        while (estaAbierto) {
            boolean llegaAlguien = Math.random() < probabilidadLlegada ? true : false;
            if (llegaAlguien) {
                Cliente cliente = new Cliente(COMPRA_MINIMA, COMPRA_MAXIMA); 
                cola.llegada(cliente);
            }
            if (cola.hayGente() && cajas.hayLibre()) {
                cajas.recibe(cola.sacarCliente());
            }
            estaAbierto = hora <= horaCierre ? true : false;
            hora = hora + UN_MINUTO;
        }
    }
}
