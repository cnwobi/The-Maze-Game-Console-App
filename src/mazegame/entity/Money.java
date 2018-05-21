package mazegame.entity;

public class Money {
	 private double total;

     public Money() {
         total = 0;
     }

     public Money(double total) {
         this.total = total;
     }

     public void Add(double amount) {
         total += amount;
     }

     public boolean subtract(double amount) {
         if (amount > total)
             return false;
         total -= amount;
         return true;
     }

     public double getWeight() {
         return total/100;
     }

     public String toString() {
         if (total < 1)
             return "No gold pieces";
         if (total == 1)
             return "One gold piece";
         return "There are " + total + " gold pieces";
     }

    public double getTotal() {
        return total;
    }
}
