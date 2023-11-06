import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class CentroComercial {

    double probabilidadLlegada;
    double horaApertura, horaCierre;
    boolean estaAbierto;
    double hora;
    final double UN_MINUTO = 1.0 / 60.0;
    final int COMPRA_MINIMA = 5;
    final int COMPRA_MAXIMA = 15;
    CentroDeAtencion cajas;
    Cola cola;

    CentroComercial() {
        probabilidadLlegada = 0.6;
        horaApertura = 9;
        horaCierre = 21;
        hora = horaApertura;
        estaAbierto = hora >= horaApertura ? true : false;
        cola = new Cola();
        cajas = new CentroDeAtencion(cola, 10);
    }

    public void funciona() {
        while (estaAbierto) {
            boolean llegaAlguien = Math.random() < probabilidadLlegada ? true : false;
            if (llegaAlguien) {
                String minutoYSegundoActuales = LocalTime.now().format(DateTimeFormatter.ofPattern("mm:ss"));
                Cliente cliente = new Cliente(COMPRA_MINIMA, COMPRA_MAXIMA, "unNombre " + minutoYSegundoActuales); 
                cola.addCliente(cliente);
            }
            if (cola.tienePersonas()) {
                cajas.atiende();
            }
            estaAbierto = hora <= horaCierre ? true : false;
            hora = hora + UN_MINUTO;
            System.out.println(hora);
            System.out.println(cola.toString());
        }
    }

    public static void main(String[] args) {
        new CentroComercial().funciona();
    }

}
