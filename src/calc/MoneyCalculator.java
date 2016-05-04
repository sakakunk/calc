
package calc;

import java.util.ArrayList;
import java.util.List;


/**
 * name: Bálint Ádám
 * email: sakakunk@gmail.com
 * tel: 06/30 8740728
 */

public class MoneyCalculator {
    
    private int payable;
    private int paid;
    private int change;
    private final Integer[] banknotes = {20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5};
    private final List<Integer> banknoteQuantities;

    public MoneyCalculator(int payable, int paid) {
        this.payable = round(payable);
        this.paid = round(paid);
        this.change = this.paid - this.payable;
        banknoteQuantities = new ArrayList<>();
        initQuantities();
    }
    //rounds the given money to 0 or 5
    private int round(int money){
        return money%5 == 0 ||  money%5 == 1 ||  money%5 == 2 ? money-money%5 : money+(5-(money%5));
    }
    
    //clears the banknote quantities: every element of the list is set to zero
    private void clearBankNoteQuantities(){
        for(int i=0;i<banknoteQuantities.size();++i){
            banknoteQuantities.set(i, 0);
        }
    }
    
    public int getPayable() {
        return payable;
    }
    //saves a new value to the payable money and recalculates the change
    public void setPayable(int payable) {
        this.payable = round(payable);
        this.change = this.paid - this.payable;
    }

    public int getPaid() {
        return paid;
    }
    //saves a new value to the paid money and recalculates the change
    public void setPaid(int paid) {
        this.paid = round(paid);
        this.change = this.paid - this.payable;
    }

    public int getChange() {
        return change;
    }
    //calculates the banknotes based on the current change: the banknotes are strored in a List
    public void calculateChange(){
        clearBankNoteQuantities();
        if(change<0){
            System.out.println("It seems you do not have enough money! The payable (" + payable + ") is more than the paid money ("  + paid+  ")!"); 
            
        }else{
            int remaining=change;
            for(int i=0;i<banknotes.length;++i){
                while(remaining>=banknotes[i]){
                    banknoteQuantities.set(i, banknoteQuantities.get(i)+1);
                    remaining-=banknotes[i];
                }
            }
        }
    }
    
    //returns a readable string of the MoneyCalculator object
    //if the change is negative, it gives no information about the banknotes
    @Override
    public String toString() {
        String result="";
        result+= "payable=" + payable + ", paid=" + paid + ", change=" + change+ "\nBanknote - Quantity\n";
        if(change>=0){
            for(int i=0;i<banknotes.length;++i){
                result += banknotes[i] + " - " + banknoteQuantities.get(i) +"\n";
            }
        }
        return result;
    }
    //adds zeros to an empty list
    //lenght of the List is based on the quantity of different possible banknotes
    private void initQuantities() {
       for(int i=0;i<banknotes.length;++i){
            banknoteQuantities.add(0);
        }
    }
}
