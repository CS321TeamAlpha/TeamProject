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
        ItemManager im = ItemManager.get();
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
        sm.add(store2);
    }
}
