/*******************************************************************
*   AccountManager.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package Model;

import DataLoader.XMLDataLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class which manages the master list of Accounts
 * 
 */
public class AccountManager {
    private static AccountManager instance;
    private List<Account> accounts;
    
    private AccountManager(){
        accounts = (ArrayList<Account>)XMLDataLoader.get().loadData("MasterAccountList.xml");
        if (accounts != null){
            accounts.sort(null);
        } else {
            accounts = new ArrayList();
        }
    }
    
    public static AccountManager get(){
        if(instance == null){
            instance = new AccountManager();
        }
        return instance;
    }
    
    public List<Account> getItems(){
        return accounts;
    }
    
    public void add(Account account){
        accounts.add(account);
    }
    
    public boolean accountExists(String userName){
        for(Account account : accounts)
        {
            if (account.getName().equalsIgnoreCase(userName)){
                return true;
            }
        }
        return false;
    }
    
    public Account validateAccount(String userName, String password){
        for(Account account : accounts)
        {
            if (account.getName().equalsIgnoreCase(userName)){
                if (account.getPassword().equals(password)){
                    return account;
                }
                return null;
            }
        }
        return null;
    }
}
