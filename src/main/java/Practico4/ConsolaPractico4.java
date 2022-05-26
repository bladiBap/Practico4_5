package Practico4;

public class ConsolaPractico4 {
    public static void main(String[] args) {
        Ventana4 v = new Ventana4();

        Persona p1 = new Persona("a","aa","aaa", 75,4,"asd");
        Persona p2 = new Persona("b","bb","bbb", 12,48,"abb");
        Persona p3 = new Persona("c","cc","ccc", 75,4,"ccccccc");
        Persona p4 = new Persona("d","dd","ddd", 75,4,"dddddd");
        Persona p5 = new Persona("e","ee","eee", 75,4,"eeeeee");

        Tren trensito = new Tren();
        trensito.insertar(p1);
        trensito.insertar(p2);
        trensito.insertar(p3);
        trensito.insertar(p4);
        trensito.insertar(p5);

        System.out.println(trensito);
    }
}
