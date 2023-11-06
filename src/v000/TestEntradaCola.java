package v000;
class TestEntradaCola {
    public static void main(String[] args) {

        Cola cola = new Cola();

        cola.addCliente(new Cliente(5, 15, "A"));
        cola.addCliente(new Cliente(5, 15, "B"));
        cola.addCliente(new Cliente(5, 15, "C"));
        cola.addCliente(new Cliente(5, 15, "D"));
        cola.addCliente(new Cliente(5, 15, "E"));

        System.out.println(cola.removeCliente().toString());

        Cliente otroCliente = cola.removeCliente();
        System.out.println(otroCliente.toString());
    }
}
