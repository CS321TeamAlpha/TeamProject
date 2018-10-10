/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author Bernard
 */
public class Utilities {
    
    public static String intToCurrencyString(int n){
        return String.format("$%3d.%02d", n/100, n%100);
    }
}
