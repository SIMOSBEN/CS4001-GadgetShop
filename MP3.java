public class MP3 extends Gadget {

    private int usedmemory;   // how much music it can hold - USED
    private final int maxMemory;  // TOTAL capacity
    private int memory;          

    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size); // use gadget info
        this.maxMemory = memory;  // store original max
        this.usedmemory = 0;      //  used space
    }

    public int getAvailableMemory() { 
        return maxMemory - usedmemory; 
    } 
    
    public int getUsedMemory() { 
        return usedmemory; 
    }

    public void downloadMusic(int amount) {   
        if (amount <= getAvailableMemory()) {     
            usedmemory += amount;
            System.out.println("Downloaded " + amount + "MB");
        } else {
            System.out.println("Not enough memory.");
        }
    }

    
    public String downloadMusic() {          
        return "Downloading music to " + getModel();
    }

    public void deleteMusic(int amount) {    
        if (amount > 0) {
            usedmemory = Math.min(usedmemory - amount, maxMemory); 
            System.out.println("Enter a positive amount.");
        }
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
