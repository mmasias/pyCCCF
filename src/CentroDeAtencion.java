public class CentroDeAtencion {

    private Cola miCola;
    private Caja cajas[];

    CentroDeAtencion(Cola cola, int numeroCajas) {
        miCola = cola;
        cajas = new Caja[numeroCajas];
        for (int caja=0;caja<numeroCajas; caja++){
            cajas[caja] = new Caja(""+caja);
        }
    }

    public void atiende() {
        if (miCola.tienePersonas() & hayCajaLibre()) {
            Cliente unCliente = miCola.removeCliente();
            pasoACaja(unCliente);
        }
        queAtiendanLasCajas();
    }

    private void queAtiendanLasCajas() {
        for(int unaCaja=0;unaCaja<cajas.length;unaCaja++){
            if (!cajas[unaCaja].estaLibre()){
                cajas[unaCaja].atiende();
            }
        }
    }

    private void pasoACaja(Cliente unCliente) {
        Caja unaCajaLibre = dimeCajaLibre(cajas);
        unaCajaLibre.recibe(unCliente);
    }

    private Caja dimeCajaLibre(Caja[] cajas){
        for(int unaCaja=0;unaCaja<cajas.length;unaCaja++){
            if (cajas[unaCaja].estaLibre()){
                return cajas[unaCaja];
            }
        }
        return null;
    }

    private boolean hayCajaLibre(){
        for(int unaCaja=0;unaCaja<cajas.length;unaCaja++){
            if (cajas[unaCaja].estaLibre()){
                return true;
            }
        }
        return false;        
    }
}
