/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Bernard
 */
public class ImproperFormatException extends RuntimeException {

    /**
     * Creates a new instance of <code>ImproperFormatException</code> without
     * detail message.
     */
    public ImproperFormatException() {
    }

    /**
     * Constructs an instance of <code>ImproperFormatException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ImproperFormatException(String msg) {
        super(msg);
    }
}
