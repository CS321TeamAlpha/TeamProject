/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exceptions.ImproperFormatException;
import java.util.Scanner;

/**
 *
 * 
 */
public class Currency {
    private int dollar;
    private int cent;
    
    public Currency(){
        this.dollar = 0;
        this.cent = 0;
    }
    public Currency(int dollar, int cent){
        this.dollar = dollar;
        this.cent = cent;
    }
    
    @Override
    public String toString(){
        return String.format("$%d.%02d", this.dollar, this.cent);
    }
    
    public Currency add(Currency other){
        int newCent = this.cent + other.cent;
        int newDollar = this.dollar + other.dollar + newCent/100;
        newCent %= 100;
        
        return new Currency(newDollar, newCent);
    }
    
    public Currency sub(Currency other){
        int newCent = this.cent - other.cent + 100;
        int newDollar = this.dollar - other.dollar + newCent/100 - 1;
        newCent %= 100;
        
        return new Currency(newDollar, newCent);
    }
    
    public int getValue(){
        return dollar * 100 + cent;
    }
    
    public void setValue(int intValue){
        this.dollar = intValue/100;
        this.cent = intValue%100;
    }
    
//    public static Currency StringToCurrency(String strValue) throws ImproperFormatException{
//        if (!strValue.matches("[$]?[0-9]{0,3}([.][0-9]{0,2})?")){
//            throw new ImproperFormatException(
//                    "Oh, snap... That is not a good format for currency");
//        }
//        Currency newCurrency = new Currency(0,0);
//        Scanner scanner = new Scanner(strValue);
//        scanner.useDelimiter("\\$|\\.");
//        if(scanner.hasNextInt()){
//            newCurrency.dollar = scanner.nextInt();
//        }
//        if(scanner.hasNextInt()){
//            newCurrency.cent = scanner.nextInt();
//        }
//        scanner.close();
//        return newCurrency;
//    }
    
    public void setValue(String strValue) throws ImproperFormatException{
        if (!strValue.matches("[$]?[0-9]{0,3}([.][0-9]{0,2})?")){
            throw new ImproperFormatException(
                    "Oh, snap... That is not a good format for currency");
        }
        Scanner scanner = new Scanner(strValue);
        scanner.useDelimiter("\\$|\\.");

        if(scanner.hasNextInt()){
            this.dollar = scanner.nextInt();
        } else {
            this.dollar = 0;
        }
        if(scanner.hasNextInt()){
            this.cent = scanner.nextInt();
        } else {
            this.cent = 0;
        }
        //}
        scanner.close();
    }
    
    public void setDollar(int dollar){
        this.dollar = dollar;
    }
    
    public void setCent(int cent){
        this.cent = cent;
    }
}
