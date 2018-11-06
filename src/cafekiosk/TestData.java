/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafekiosk;

import Model.*;

/**
 *
 * @author Bernard
 */
public class TestData {
    public void generate(){
        /*ItemManager im = ItemManager.get();
        MenuManager mm = MenuManager.get();
        StoreManager sm = StoreManager.get();
        
        ItemOption cream = new ItemOption("Cream", 0.5);
        im.add(cream);
        ItemOption sugar = new ItemOption("Sugar", 0.25);
        im.add(sugar);
        ItemOption honey = new ItemOption("Honey", 0.75);
        im.add(honey);
        
        Item coffee = new Item("Coffee", 5.0);
        im.add(coffee);
        Item tea = new Item("Tea", 2.0);
        im.add(tea);
        
        MenuOption m_cream = new MenuOption(cream);
        MenuOption m_sugar = new MenuOption(sugar);
        MenuOption m_honey = new MenuOption(honey);
        
        MenuItem m_coffee = new MenuItem(coffee);
        m_coffee.addOption(m_cream);
        m_coffee.addOption(m_sugar);
        m_coffee.setDrinkSize(DrinkSize.MEDIUM);
        
        MenuItem m_tea = new MenuItem(tea);
        m_tea.addOption(m_honey);
        m_tea.addOption(m_sugar);
        m_tea.setDrinkSize(DrinkSize.SMALL);
        
        Menu masterMenu = new Menu();
        masterMenu.addItem(m_coffee);
        masterMenu.addItem(m_tea);
        mm.setMenu(masterMenu);
        
        Store store1 = new Store("Store 1");
        Store store2 = new Store("Store 2");
        sm.add(store1);
        sm.add(store2);*/
        
        ////////////////////////////////////////////
                //add item to list of items
                
        ItemManager im = ItemManager.get();
        StoreManager sm = StoreManager.get();
        MenuManager mm = MenuManager.get();
        
        

        
        Item darkRoastCoffee = new Item();
        Item blondeRoastCoffee = new Item();
        Item mediumRoastCoffee = new Item();
        Item mocha = new Item();
        Item latte = new Item();
        Item blackTea = new Item();
        Item greenTea = new Item();
        
        im.add(darkRoastCoffee);
        im.add(blondeRoastCoffee);
        im.add(mediumRoastCoffee);
        im.add(mocha);
        im.add(latte);
        im.add(blackTea);
        im.add(greenTea);
        
        //set name a price of the item
        darkRoastCoffee.setName("Dark Roast Coffee");
        darkRoastCoffee.setPrice(1.95);
        blondeRoastCoffee.setName("Blonde Roast Coffee");
        blondeRoastCoffee.setPrice(1.95);
        mediumRoastCoffee.setName("Medium Roast Coffee");
        mediumRoastCoffee.setPrice(1.95);
        mocha.setName("Mocha");
        mocha.setPrice(3.75);
        latte.setName("Latte");
        latte.setPrice(3.50);
        blackTea.setName("Black Tea");
        blackTea.setPrice(3.00);
        greenTea.setName("Green Tea");
        greenTea.setPrice(3.00);
        
                
                
        //add item as a menu item
        MenuItem m_darkRoastCoffee = new MenuItem(darkRoastCoffee);
        MenuItem m_blondeRoastCoffee = new MenuItem(blondeRoastCoffee);
        MenuItem m_mediumRoastCoffee = new MenuItem(mediumRoastCoffee);
        MenuItem m_mocha = new MenuItem(mocha);
        MenuItem m_latte = new MenuItem(latte);
        MenuItem m_blackTea = new MenuItem(blackTea);
        MenuItem m_greenTea = new MenuItem(greenTea);
        
        //create an item option 
        ItemOption esp = new ItemOption("Espresso", .8);
        ItemOption caramelSyrup = new ItemOption("Caramel Syrup", .6);       
        ItemOption vanillaSyrup = new ItemOption("Vanilla Syrup", .6);
        ItemOption hazelnutSyrup = new ItemOption("Hazelut Syrup", .6);
        ItemOption classicSyrup = new ItemOption("Classic Syrup", .6);
        ItemOption cream = new ItemOption("Cream", 0);
        ItemOption sugar = new ItemOption("Sugar", 0);
        ItemOption whippedCream = new ItemOption("Whip", 0);
        ItemOption iced = new ItemOption("Iced", 0);
        
        im.add(esp);
        im.add(caramelSyrup);
        im.add(hazelnutSyrup);
        im.add(classicSyrup);
        im.add(vanillaSyrup);
        im.add(cream);
        im.add(sugar);
        im.add(whippedCream);
        im.add(iced);
        
        
        //create a menu item option
        MenuOption m_esp = new MenuOption(esp);
        MenuOption m_caramelSyrup = new MenuOption(caramelSyrup);
        MenuOption m_vanillaSyrup = new MenuOption(vanillaSyrup);
        MenuOption m_hazelnutSyrup = new MenuOption(hazelnutSyrup);
        MenuOption m_classicSyrup = new MenuOption(classicSyrup);
        MenuOption m_cream = new MenuOption(cream);
        MenuOption m_sugar = new MenuOption(sugar);
        MenuOption m_whippedCream = new MenuOption(whippedCream);
        MenuOption m_iced = new MenuOption(iced);
        
        
        //assign options to each item
        //this will allow the user to later customize their drinks with these options
        m_darkRoastCoffee.addOption(m_esp);       
        m_darkRoastCoffee.addOption(m_caramelSyrup);
        m_darkRoastCoffee.addOption(m_vanillaSyrup);
        m_darkRoastCoffee.addOption(m_hazelnutSyrup);
        m_darkRoastCoffee.addOption(m_classicSyrup);
        m_darkRoastCoffee.addOption(m_whippedCream);
        m_darkRoastCoffee.addOption(m_cream);
        m_darkRoastCoffee.addOption(m_sugar);
        m_darkRoastCoffee.addOption(m_iced);
        
        m_blondeRoastCoffee.addOption(m_esp);       
        m_blondeRoastCoffee.addOption(m_caramelSyrup);
        m_blondeRoastCoffee.addOption(m_vanillaSyrup);
        m_blondeRoastCoffee.addOption(m_hazelnutSyrup);
        m_blondeRoastCoffee.addOption(m_classicSyrup);
        m_blondeRoastCoffee.addOption(m_whippedCream);
        m_blondeRoastCoffee.addOption(m_cream);
        m_blondeRoastCoffee.addOption(m_sugar);
        m_blondeRoastCoffee.addOption(m_iced);
        
        m_mediumRoastCoffee.addOption(m_esp);       
        m_mediumRoastCoffee.addOption(m_caramelSyrup);
        m_mediumRoastCoffee.addOption(m_vanillaSyrup);
        m_mediumRoastCoffee.addOption(m_hazelnutSyrup);
        m_mediumRoastCoffee.addOption(m_classicSyrup);
        m_mediumRoastCoffee.addOption(m_whippedCream);
        m_mediumRoastCoffee.addOption(m_cream);
        m_mediumRoastCoffee.addOption(m_sugar);
        m_mediumRoastCoffee.addOption(m_iced);
        
        m_mocha.addOption(m_whippedCream);
        m_mocha.addOption(m_iced);
        
        m_latte.addOption(m_whippedCream);
        m_latte.addOption(m_iced);
        
        m_blackTea.addOption(m_classicSyrup);
 
        m_greenTea.addOption(m_classicSyrup);
        
        
        //call the menu manager to add this new menu item to the master menu
        Menu masterMenu = new Menu();

        masterMenu.addItem(m_darkRoastCoffee);
        masterMenu.addItem(m_blondeRoastCoffee);
        masterMenu.addItem(m_mediumRoastCoffee);
        masterMenu.addItem(m_mocha);
        masterMenu.addItem(m_latte);
        masterMenu.addItem(m_greenTea);
        masterMenu.addItem(m_blackTea);
        
        mm.setMenu(masterMenu);
        
        Store store1 = new Store("Store 1");
        Store store2 = new Store("Store 2");
        sm.add(store1);
        sm.add(store2);
    }
}
