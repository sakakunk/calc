package calc;

import java.util.Scanner;

/**
 * name: Bálint Ádám
 * email: sakakunk@gmail.com
 * tel: 06/30 8740728
 * 
 */
public class CalcDemo {

    
    public static void main(String[] args) {
        System.out.println("Welcome to the money change calculator!");
        System.out.println("Entered values are rounded to 0 or 5.");
        System.out.println("To exit, enter 0 to the payable or to the paid money!\n\n");
        int exit=1;
        MoneyCalculator mc = new MoneyCalculator(0, 0);
        while (exit!=0) {
            int payable = readIntFromConsole("payable money");
            int paid =readIntFromConsole("paid money");
            if(payable==0 || paid ==0){
                exit=0;
            }else{
                mc.setPayable(payable);
                mc.setPaid(paid);
                mc.calculateChange();
                System.out.println(mc.toString());
            }
        }
    }
    //reads a String from console and returns it
    public static String readFromConsole() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    //reads a String from console, and converts it to integer
    //Handles the following errors: bignumber, any non-digit character
    public static int readIntFromConsole(String text) {
        int result=0;
        boolean onlyDigits = false;
        do {
            System.out.println("Enter the " + text + ":");
            String input = readFromConsole();
            if (input.matches("\\d+")) {
                try{
                    result = Integer.parseInt(input);
                    onlyDigits = true;
                }catch(NumberFormatException e){
                    System.out.println("This number is too big... enter a smaller one!\n");
                }
                
            } else {
                System.out.println("Negative numbers, decimals and non-digit characters are not allowed!\n");
            }
        } while (!onlyDigits);

        return result;
    }

}
