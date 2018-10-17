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
public class Account {
    private String name;
    private String password;
    private AccountType accountType;
    
    public Account(String name, String password, AccountType accountType){
        this.name = name;
        this.password = password;
        this.accountType = accountType;
    }
    
    public String getName(){
        return name;
    }
    
    public String getPassword(){
        return password;
    }
    
    public AccountType getAccountType(){
        return accountType;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setAccountType(AccountType accountType){
        this.accountType = accountType;
    }    
}
