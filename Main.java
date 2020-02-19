package mytupledemo;


public class Main {

    public static void main (String [] args) {
        ObjectTuple [] otVector = {
                new ObjectTuple ("Santiago Bernabéu", 125000),
                new ObjectTuple ("Camp Nou", 159000),
                new ObjectTuple ("Old Trafford", 95000)
        };

        GenericTuple [] gtVector = {
                new GenericTuple<> ("Santiago Bernabéu", 125000),
                new GenericTuple<> ("Camp Nou", 159000),
                new GenericTuple<> ("Old Trafford", 165000.00)
        };

        System.out.println (String.format ("Object\n\tEstadio con mayor capacidad: %s", estadioMayorCapacidad (otVector)));
        System.out.println (String.format ("Generic\n\tEstadio con mayor capacidad: %s\n", estadioMayorCapacidadGeneric (gtVector)));
        
        GenericTuple point1, point2;
        point1 = new GenericTuple <>("Santiago Bernabeu","125000");
        point2 = new GenericTuple <>("Santiago Bernabeu","125000");
        
        System.out.println(Utilities.Compara(point1,point2));
        
        
        point1 = new GenericTuple <>("Santiago Bernabeu","125000");
        point2 = new GenericTuple <>("Camp Nou", 159000);
        
        System.out.println(Utilities.Compara(point1,point2));
    }

    public static String estadioMayorCapacidad (ObjectTuple [] estadios) {
        int foo = -1;
        String result = "";

        for (int i = 0; i < estadios.length; i++) {
            int bar = (int) estadios [i].getSecond (); //casting from object to int
            if (bar > foo) {
                result = estadios [i].getFirst ().toString ();
                foo = (int) estadios [i].getSecond ();
            }
        }

        return result;
    }

    public static String estadioMayorCapacidadGeneric (GenericTuple [] estadios) {
        int foo = -1;
        String result = "";

        for (int i = 0; i < estadios.length; i++) {
            int bar = getIntegerPart ((Number) estadios [i].getValue ());
            if (bar > foo) {
                result = estadios [i].getKey ().toString ();
                foo = getIntegerPart ((Number) estadios [i].getValue ());
            }
        }

        return result;
    }

    static int getIntegerPart (Number n) {
        return n.intValue ();
    }
}