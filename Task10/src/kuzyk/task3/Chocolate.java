package kuzyk.task3;

/**
 * The type Chocolate.
 */
public class Chocolate extends Confection{
    private String filling;

    /**
     * Instantiates a new Chocolate.
     *
     * @param name    the name
     * @param cost    the cost
     * @param weight  the weight
     * @param type    the type
     * @param filling the filling
     */
    public Chocolate(String name, double cost, double weight, String type, String filling) {
        super(name, cost, weight, type);
    }

    /**
     * Gets filling.
     *
     * @return the filling
     */
    public String getFilling() {
        return filling;
    }

}
