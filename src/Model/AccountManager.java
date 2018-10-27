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
import Exceptions.DuplicateItemException;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class which manages the master list of Accounts
 * 
 */
public class AccountManager {
    private static AccountManager instance;
    private List<Account> accounts;
    
    /**
     * private Constructor for Singleton construction
     * @param filename If provided, will attempt to load account data from the
     * supplied file.
     */
    private AccountManager(String filename){
        if (filename != null){
            accounts = (ArrayList<Account>)XMLDataLoader.get().loadData(filename);
        } else {
            accounts = null;
        }
        
        if (accounts != null){
            //accounts.sort(null);
        } else {
            accounts = new ArrayList();
        }
    }
    
    /**
     * Static get function for Singleton access. For the first time call, the
     * supplied filename will be used to attempt a data load. Subsequent calls
     * ignore the argument.
     * @param filename The file to load data from. May be null
     * @return sole instance of AccountManager
     */
    public static AccountManager get(String filename){
        if(instance == null){
            instance = new AccountManager(filename);
        }
        return instance;
    }
    
    /**
     * Static get function for Singleton access. For the first time call using
     * this overloaded method, an empty list will be generated
     * ignore the argument.
     * @return sole instance of AccountManager
     */
    public static AccountManager get(){
        if(instance == null){
            instance = new AccountManager(null);
        }
        return instance;
    }
    
    /**
     * Retrieves the list of Accounts
     * @return list of Accounts
     */
    public List<Account> getItems(){
        return accounts;
    }
    
    /**
     * Adds an account to the list
     * @param account The Account to be added
     */
    public void add(Account account) throws DuplicateItemException{
        if(accounts.contains(account))
            throw new DuplicateItemException();
        accounts.add(account);
    }
    
    /**
     * Searches the existing accounts to determine if that userName is already 
     * in use.
     * @param userName The userName to check for
     * @return true if userName is already in list, false otherwise
     */
    public boolean accountExists(String userName){
        for(Account account : accounts)
        {
            if (account.getName().equalsIgnoreCase(userName)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Takes a userName and password and verifies both that the account exists
     * and that the password is correct.
     * @param userName The userName to check for
     * @param password The password to compare with account
     * @return If the userName and password match, returns the correct Account
     *  returns null otherwise.
     */
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
