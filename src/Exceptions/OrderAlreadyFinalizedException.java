/*******************************************************************
*   OrderAlreadyFinalizedException.java
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
 * Unchecked Exception denoting that a date stamped order was processed again
 * 
 */
public class OrderAlreadyFinalizedException extends RuntimeException {

    /**
     * Creates a new instance of <code>OrderAlreadyFinalizedException</code>
     * without detail message.
     */
    public OrderAlreadyFinalizedException() {
    }

    /**
     * Constructs an instance of <code>OrderAlreadyFinalizedException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public OrderAlreadyFinalizedException(String msg) {
        super(msg);
    }
}
