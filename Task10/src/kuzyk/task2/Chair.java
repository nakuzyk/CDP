package kuzyk.task2;

/**
 * The type Chair.
 */
public class Chair extends Goods{
    private boolean isNew;
    static private int count = 0;
    static private double commonCost = 0;

    /**
     * Instantiates a new Chair.
     */
    public Chair() {
        this.setCost(10);
        this.setName("wodoo");
        this.setNew(true);
        count++;
        commonCost += 10;
    }

    /**
     * Instantiates a new Chair.
     *
     * @param cost  the cost
     * @param name  the name
     * @param isNew the is new
     */
    public Chair(double cost, String name, boolean isNew){
        this.setCost(cost);
        this.setName(name);
        this.setNew(isNew);
        count++;
        commonCost += cost;
    }

    /**
     * Set new.
     *
     * @param isNew the is new
     */
    public void setNew(boolean isNew){
        this.isNew = isNew;
    }

    /**
     * Get new boolean.
     *
     * @return the boolean
     */
    public boolean getNew(){
        return isNew;
    }
}
