package kuzyk.task2;

public class Chair extends Goods{
    private boolean isNew;
    static private int count = 0;
    static private double commonCost = 0;

    public Chair() {
        this.setCost(10);
        this.setName("wodoo");
        this.setNew(true);
        count++;
        commonCost += 10;
    }

    public Chair(double cost, String name, boolean isNew){
        this.setCost(cost);
        this.setName(name);
        this.setNew(isNew);
        count++;
        commonCost += cost;
    }

    public void setNew(boolean isNew){
        this.isNew = isNew;
    }
    public boolean getNew(){
        return isNew;
    }
}
