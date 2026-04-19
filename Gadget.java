public class Gadget {
    private String model;    // gadget name
    private double price;    // gadget price
    private int weight;      // gadget weight
    private String size;     // gadget size

    public Gadget(String model, double price, int weight, String size) { // make new gadget
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    public String getModel() { return model; }  // say model
    public double getPrice() { return price; }  // say price
    public int getWeight() { return weight; }   // say weight
    public String getSize() { return size; }    // say size

    public void display() {                      // show info about gadget
        System.out.println("Model: " + model);
        System.out.println("Price: \u00A3" + price);
        System.out.println("Weight: " + weight + "g");
        System.out.println("Size: " + size);
    }

    @Override
    public String toString() {                   // show gadget in log
        return model + " - \u00A3" + price + " - " + weight + "g - " + size;
    }
}
