/*******************************************************************
*   DataLoader.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package DataLoader;

/**
 * Interface to define the saving and loading of data
 * 
 */
public interface DataLoader {
    
    public Object loadData(String filename);
    
    public void saveData(Object object, String filename);
}
