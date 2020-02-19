package mytupledemo;

public class Utilities {
    
    public static <T> boolean Compara (T item1, T item2){
        return ((GenericTuple) item1).getKey() == ((GenericTuple) item2).getKey() &&
                ((GenericTuple) item1).getValue()== ((GenericTuple) item2).getValue();
    }
}
