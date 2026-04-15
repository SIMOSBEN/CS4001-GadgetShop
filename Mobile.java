public class Mobile extends Gadget {
    private int credit;  // how many minutes for calls

    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight, size);
        this.credit = credit;
    }

    public int getCredit() { return credit; }  //  how much credit

    public void addCredit(int amount) {       // add minutes
        if (amount > 0) {
            credit += amount;
        } else {
            System.out.println("Enter positive amount.");
        }
    }

    public void makeCall(String number, int duration) {  // try to call
        if (duration <= credit) {                         // if enough credit
            credit -= duration;
            System.out.println("Calling " + number + " for " + duration + " minutes.");
        } else {                                         // not enough credit
            System.out.println("Insufficient credit.");
        }
    }

    @Override
    public void display() {                               // show mobile info
        super.display();
        System.out.println("Remaining Credit: " + credit + " minutes");
    }

    @Override
    public String toString() {
        return super.toString() + ", Credit: " + credit + " minutes";
    }
}