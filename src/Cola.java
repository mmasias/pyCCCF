public class Cola {
    private List<Cliente> clientes;
    private int personasEnCola;

    public Cola() {
        clientes = new List<Cliente>();
        personasEnCola=0;
    }

    public void addCliente(Cliente cliente) {
        clientes.insert(cliente, -1);
        personasEnCola++;
    }

    public Cliente removeCliente() {
        Cliente saliente = clientes.getFirst().getData();
        clientes.removeFirst();
        personasEnCola--;
        return saliente;
    }

    public boolean tienePersonas() {
        return !clientes.isEmpty();
    }

    @Override
    public String toString() {
        return "En cola hay " + personasEnCola + " personas.";
    }    
}
