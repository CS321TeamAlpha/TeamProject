/*******************************************************************
*   Account.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package Model;

/**
 * Representation of a user account
 *
 */
public class Account implements Comparable<Account>{
    private String name;
    private String password;
    private AccountType accountType;
    
    /**
     * Empty Constructor required for XML Serialization
     */
    public Account(){
        
    }
    
    /**
     * Primary Constructor
     * @param name the userName for the new Account
     * @param password the password for the new Account
     * @param accountType enumeration of the Account Type
     */
    public Account(String name, String password, AccountType accountType){
        this.name = name;
        this.password = password;
        this.accountType = accountType;
    }
    
    /**
     * Get function for name
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Get function for password
     * @return password
     */
    public String getPassword(){
        return password;
    }
    
    /**
     * Get function for accountType
     * @return accountType
     */
    public AccountType getAccountType(){
        return accountType;
    }
    
    /**
     * Set function for name
     * @param name The name to set
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Set function for password
     * @param password The password to set
     */
    public void setPassword(String password){
        this.password = password;
    }
    
    /**
     * Set function for accountType
     * @param accountType The accountType to set
     */
    public void setAccountType(AccountType accountType){
        this.accountType = accountType;
    }
    
    /**
     * Overridden toString
     * @return A formatted string containing the Account data
     */
    @Override
    public String toString(){
        String typeString;
        if (accountType == AccountType.MANAGER)
            typeString = "Manager";
        else
            typeString = "User";
        return "Username: " + name + ", Password: " + password + ", Type: " + typeString;
    }
    
    /**
     * Overridden compareTo
     * @param o Account to compare to current Account
     * @return -1, 0, or 1 based off of standard compare
     */
    @Override
    public int compareTo(Account o) {
        return name.compareTo(o.getName());
    }
}
