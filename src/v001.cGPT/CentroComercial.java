import java.util.Random;

class CentroComercial {
    private final int horaApertura;
    private final int horaCierre;
    private final int probabilidadLlegada;
    private final int numCajas;
    private final int minItems;
    private final int maxItems;
    private final Caja[] cajas;
    private final List<Cliente> cola;
    private int tiempo;
    private int numPersonasAtendidas;
    private int numItemsVendidos;

    public CentroComercial(int horaApertura, int horaCierre, int probabilidadLlegada, int numCajas, int minItems, int maxItems) {
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.probabilidadLlegada = probabilidadLlegada;
        this.numCajas = numCajas;
        this.minItems = minItems;
        this.maxItems = maxItems;
        this.cajas = new Caja[numCajas];
        this.cola = new List<>();
        this.tiempo = horaApertura * 60;
        this.numPersonasAtendidas = 0;
        this.numItemsVendidos = 0;

        // Crear cajas
        for (int i = 0; i < numCajas; i++) {
            cajas[i] = new Caja();
        }
    }

    public void simularJornada() {
        Random random = new Random();

        while (tiempo < horaCierre * 60) {
            // Llegada de personas
            if (random.nextInt(100) < probabilidadLlegada) {
                int numItems = random.nextInt(maxItems - minItems + 1) + minItems;
                Cliente cliente = new Cliente(numItems);
                cola.insert(cliente, -1);
                System.out.println("Llegó un cliente con " + numItems + " items a las " + obtenerHora(tiempo));
            }

            // Atender clientes en cajas
            for (Caja caja : cajas) {
                if (caja.estaLibre() && !cola.isEmpty()) {
                    Cliente cliente = cola.getFirst().getData();
                    cola.remove(0);
                    caja.atenderCliente(cliente);
                    numPersonasAtendidas++;
                    numItemsVendidos += cliente.getNumItems();
                    System.out.println("El cliente con " + cliente.getNumItems() + " items fue atendido en la caja " + caja.getId() + " a las " + obtenerHora(tiempo));
                }
            }

            // Avanzar tiempo
            tiempo++;

            // Avanzar tiempo de las cajas
            for (Caja caja : cajas) {
                caja.avanzarTiempo();
            }

            // Mostrar estado de la cola y las cajas
            System.out.println("En cola hay " + cola.size() + " personas");
            for (Caja caja : cajas) {
                System.out.println("La caja " + caja.getId() + " está " + (caja.estaLibre() ? "libre" : "ocupada"));
            }
        }
    }

    public void mostrarResumen() {
        int tiempoSinCola = 0;
        int numPersonasEnCola = cola.size();
        System.out.println("Número de personas que estaban en cola al finalizar el día: " + numPersonasEnCola);
        System.out.println("Número de personas atendidas durante el día: " + numPersonasAtendidas);
        System.out.println("Número de items vendidos en el día: " + numItemsVendidos);
        for (Caja caja : cajas) {
            tiempoSinCola += caja.getTiempoSinCola();
        }
        System.out.println("Número de minutos en que no hubo nadie en cola: " + tiempoSinCola);
    }

    private String obtenerHora(int minutos) {
        int hora = minutos / 60;
        int minuto = minutos % 60;
        return String.format("%02d:%02d", hora, minuto);
    }
}