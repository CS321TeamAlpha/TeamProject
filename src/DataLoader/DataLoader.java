/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLoader;

/**
 *
 * @author Bernard
 */
public interface DataLoader {
    
    public Object loadData(String filename);
    
    public void saveData(Object object, String filename);
}
