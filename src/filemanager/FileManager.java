/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Bernard
 */
public class FileManager {
    public static void saveObjectToXML(Object object, String filename){
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
    
    public static Object LoadObjectFromXML(String filename){
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
