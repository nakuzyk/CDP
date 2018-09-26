package kuzyk.task2;

/**
 * The type Table.
 */
class Table extends Goods{
        private String material;
        static private int count = 0;
        static private double commonCost = 0;

    /**
     * Instantiates a new Table.
     */
    public Table() {
            this.setCost(15);
            this.setName("wodoo");
            this.setMaterial("Oak");
            count++;
            commonCost += 15;
        }

    /**
     * Instantiates a new Table.
     *
     * @param cost     the cost
     * @param name     the name
     * @param material the material
     */
    public Table(int cost, String name, String material){
            this.setCost(cost);
            this.setName(name);
            this.setMaterial(material);
            count++;
            commonCost += cost;
        }

    /**
     * Set material.
     *
     * @param material the material
     */
    public void setMaterial(String material){
            this.material = material;
        }

    /**
     * Get material string.
     *
     * @return the string
     */
    public String getMaterial(){
            return material;
        }
    }
