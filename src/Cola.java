public class Cola {
    private List<Cliente> clientes;

    public Cola() {
        clientes = new List<Cliente>();
    }

    public void addCliente(Cliente cliente) {
        clientes.insert(cliente, -1);
    }

    public Cliente removeCliente() {
        Cliente saliente = clientes.getFirst().getData();
        clientes.removeFirst();
        return saliente;
    }

    public boolean tienePersonas() {
        return !clientes.isEmpty();
    }
}
