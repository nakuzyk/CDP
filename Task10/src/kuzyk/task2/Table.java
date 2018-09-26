package kuzyk.task2;

    class Table extends Goods{
        private String material;
        static private int count = 0;
        static private double commonCost = 0;

        public Table() {
            this.setCost(15);
            this.setName("wodoo");
            this.setMaterial("Oak");
            count++;
            commonCost += 15;
        }

        public Table(int cost, String name, String material){
            this.setCost(cost);
            this.setName(name);
            this.setMaterial(material);
            count++;
            commonCost += cost;
        }

        public void setMaterial(String material){
            this.material = material;
        }
        public String getMaterial(){
            return material;
        }
    }
