package v000;
import java.util.Scanner;

class CentroComercial {

    double probabilidadLlegada;
    double horaApertura, horaCierre;
    boolean estaAbierto;
    double hora;
    final double UN_MINUTO = 1.0 / 60.0;
    final int COMPRA_MINIMA = 5;
    final int COMPRA_MAXIMA = 15;
    final int NUMERO_CAJAS = 7;
    CentroDeAtencion cajas;
    Cola cola;

    CentroComercial() {
        probabilidadLlegada = 0.6;
        horaApertura = 9;
        horaCierre = 21;
        hora = horaApertura;
        estaAbierto = hora >= horaApertura ? true : false;
        cola = new Cola();
        cajas = new CentroDeAtencion(cola, NUMERO_CAJAS);
    }

    public void atiende() {
        while (estaAbierto) {
            boolean llegaAlguien = Math.random() < probabilidadLlegada ? true : false;
            if (llegaAlguien) {
                Cliente cliente = new Cliente(COMPRA_MINIMA, COMPRA_MAXIMA, inventaNombre());
                cola.addCliente(cliente);
            }
            cajas.atiende();
            estaAbierto = hora <= horaCierre ? true : false;
            hora = hora + UN_MINUTO;
            System.out.println(hora);
            System.out.println(cola.toString());
            new Scanner(System.in).nextLine();
        }
    }

    private String inventaNombre() {
        String[] nombres = { "Zarco Aldunate", "Electra Natchios", "Orion Pax", "Magnus Robot Fighter", "Indiana Solo",
                "Carmen Sandiego", "Mario Bros", "Lara Craft", "Tyrion Spacewalker", "Leia Organa", "Apollo Creed",
                "Han Skywalker", "Marty McFly", "Ellen Ripley", "Sarah Connor", "Tony Stark", "Bruce Wayne",
                "Clark Kent", "Peter Parker", "Logan Howlett", "Natasha Romanoff", "Scott Summers", "Jean Grey",
                "Charles Xavier", "Bruce Banner", "Diana Prince", "Arthur Curry", "Barry Allen", "Hal Jordan",
                "Billy Batson", "Stephen Strange", "Wade Wilson", "Matt Murdock", "Jessica Jones", "Luke Cage",
                "Danny Rand", "Frank Castle", "Reed Richards", "Sue Storm", "Johnny Storm", "Ben Grimm",
                "Victor Von Doom", "Groot Rocket", "Gamora Zen", "Drax Destroyer", "Poe Dameron", "Finn Trooper",
                "Rey Skywalker", "Kylo Ren", "Shuri Panther", "Zelda Windrunner", "Max Power", "Indiana Stones",
                "Cosmo Quantum", "Aria Stardust", "Neo Matrix", "Katniss Evergreen", "Sherlock Combs", "Loki Mischief",
                "Dante Inferno", "Vito Corleone", "Anakin Skydancer", "Bruce Vain", "Ellie Sattler", "Korben Dallas",
                "Selina Moon", "Ripley Alien", "Tony Clank", "Peter Parquagh", "Logan Wolverine", "Selene Underworld",
                "Arthur King", "Merlin Wizard", "Gandalf White", "Frodo Baggins", "Aragorn Ranger", "Legolas Greenleaf",
                "Gimli SonofGloin", "Bilbo Baggins", "Sauron Darklord", "Eowyn Shieldmaiden", "Galadriel Lothlorien",
                "Pippin Took", "Merry Brandybuck", "Samwise Gamgee", "Arwen Evenstar", "Boromir Gondor",
                "Faramir Ithilien", "Elrond Halfelven", "Tauriel Woodland", "Thranduil King", "Bard Bowman",
                "Dwalin Dwarf", "Balin Dwarf", "Kili Dwarf", "Fili Dwarf", "Dori Dwarf", "Nori Dwarf", "Ori Dwarf",
                "Bifur Dwarf", "Bofur Dwarf", "Bombur Dwarf", "Thorin Oakenshield", "Azog Defiler", "Bolg SonofAzog",
                "Smaug Dragon", "Tauron Bull", "Celeborn Silver", "Haldir Lórien", "Lurtz Uruk", "Grishnákh Orc",
                "Gollum Precious", "Saruman White", "Radagast Brown", "Gothmog Lieutenant", "Gil-galad Elvenking",
                "Elendil Highking", "Isildur Heir", "Anárion Sunlord", "Círdan Shipwright", "Eärnur Lastking",
                "Ecthelion Lord", "Feanor Spiritoffire", "Fingolfin Highking", "Finrod Faithful", "Glorfindel Golden",
                "Maedhros Tall", "Maglor Singer", "Celebrimbor Silverhand", "Théoden King", "Théodred Prince",
                "Éomer Marshal", "Éowyn Lady", "Gríma Wormtongue", "Háma Guard", "Ioreth Healer", "Imrahil Prince",
                "Denethor Steward", "Beregond Guard", "Damrod Ranger" };
        return nombres[(int) (Math.random() * nombres.length)];
    }

    public static void main(String[] args) {
        new CentroComercial().atiende();
    }

}
