public class Main {
    public static void main(String[] args) {
        // Crear centro comercial
        CentroComercial centroComercial = new CentroComercial(9, 21, 60, 4, 5, 15);

        // Simular jornada
        centroComercial.simularJornada();

        // Mostrar resumen
        centroComercial.mostrarResumen();
    }
}