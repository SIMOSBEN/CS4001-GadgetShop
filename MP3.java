public class MP3 extends Gadget {

    private int usedMemory;   // how much music it can hold - USED
    private final int maxMemory;  // TOTAL capacity

    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size); // use gadget info
        this.maxMemory = memory;  // store original max
        this.usedMemory = 0;      //  used space
    }

    public int getAvailableMemory() { 
        return maxMemory - usedMemory; 
    } 
    
    public int getUsedMemory() { 
        return usedMemory; 
    }

    public void downloadMusic(int amount) {   
        if (amount > 0 && amount <= getAvailableMemory()) {     
            usedMemory += amount;
            System.out.println("Downloaded " + amount + "MB");
        } else {
            System.out.println("Not enough memory.");
        }
    }

    public void deleteMusic(int amount) {
        if (amount <= 0) {
        System.out.println("Enter a positive amount.");
        return;
        }

        usedMemory = Math.max(0, usedMemory - amount);
        System.out.println("Deleted " + amount + "MB");
    }   

    @Override
    public void display() {                   
        super.display();
        System.out.println("Available Memory: " + getAvailableMemory() + "MB"); 
    }

    @Override
    public String toString() {                
        return super.toString() + " - Memory: " + getAvailableMemory() + "MB";
    }
}
