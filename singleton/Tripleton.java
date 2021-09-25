package singleton;

public class Tripleton {
    private static Tripleton[] tripletons = { new Tripleton(0), new Tripleton(1), new Tripleton(2), };
    private int id;

    private Tripleton(int id) {
        System.out.println("id = " + id + " is created.");
        this.id = id;
    }

    public static Tripleton getInstance(int id) {
        return tripletons[id];
    }

    public String ofString() {
        return "Tripleton of id = " + this.id;
    }
}
