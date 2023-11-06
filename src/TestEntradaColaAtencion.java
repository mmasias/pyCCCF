class TestEntradaColaAtencion {

    public static void main(String[] args) {
    
        Cola cola = new Cola();

        CentroDeAtencion cajas = new CentroDeAtencion(cola);

        cola.addCliente(new Cliente(5, 15,"Pepito"));
        cola.addCliente(new Cliente(5, 15,"Juanito"));
        cola.addCliente(new Cliente(5, 15,"Anita"));
        cola.addCliente(new Cliente(5, 15,"Tarzan"));
        cola.addCliente(new Cliente(5, 15,"Jane"));

        while(cola.tienePersonas()){
            cajas.atiende();
        }
    }
}
