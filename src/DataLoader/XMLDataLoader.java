/*******************************************************************
*   FileManager.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package DataLoader;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * A derived DataLoader to handle .xml files.
 * Implemented as a Singleton class
 */
public class XMLDataLoader implements DataLoader {
    private static XMLDataLoader instance;
    
    /**
     * private constructor for Singleton loading
     */
    private XMLDataLoader(){
        
    }
    
    /**
     * static get function to get the Singleton instance
     * @return the sole instance of XMLDataLoader
     */
    public static XMLDataLoader get(){
        if(instance==null){
            instance = new XMLDataLoader();
        }
        return instance;
    }
    
    /**
     * Parses an Object into an XML file
     * @param object The object to save as XML
     * @param filename The name of the file in which to save the object
     */
    @Override
    public void saveData(Object object, String filename){
        XMLEncoder encoder;
        try{
            encoder = new XMLEncoder(new FileOutputStream(filename));
            encoder.writeObject(object);
            encoder.close();
        }
        catch(FileNotFoundException e){
            System.err.println("File '" + filename + "' not found.");
        }
    }
    
    /**
     * Creates an Object from an XML file
     * @param filename The name of the file to from which to create the Object
     * @return A newly instantiated Object containing the data from the file
     */
    @Override
    public Object loadData(String filename){
        XMLDecoder decoder;
        try{
            decoder = new XMLDecoder(new FileInputStream(filename));
            Object object = decoder.readObject();
            decoder.close();
            return object;
        }
        catch(FileNotFoundException e){
            System.err.println("File '" + filename + "' not found.");
            return null;
        }
    }
}
