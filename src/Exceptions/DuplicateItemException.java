/*******************************************************************
*   DuplicateItemException.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package Exceptions;

/**
 * Unchecked Exception denoting that a duplicate object was loaded into a 
 * list somewhere.
 * 
 */
public class DuplicateItemException extends RuntimeException {

    /**
     * Creates a new instance of <code>DuplicateItemException</code> without
     * detail message.
     */
    public DuplicateItemException() {
    }

    /**
     * Constructs an instance of <code>DuplicateItemException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DuplicateItemException(String msg) {
        super(msg);
    }
}
