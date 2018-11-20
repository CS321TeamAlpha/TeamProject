/*******************************************************************
*   CurrencyField.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package GUI;

import javafx.scene.control.TextField;

/**
 * A modified javafx TextField to properly handle currency
 * 
 */
public class CurrencyField extends TextField{
    @Override
    public void replaceText(int start, int end, String text){
        if (validate(text))
        {
            super.replaceText(start, end, text);
        }
    }
    
    /**
     * Modified replaceSelection method which validates that the new text
     * is in a proper format before replacing the old text
     * @param text the newly entered text
     */
    @Override
    public void replaceSelection(String text)
    {
        if(validate(text))
        {
            super.replaceSelection(text);
        }
    }
    
    /**
     * Validates the entered String is properly formated for the
     * currency style
     * @param text the text to validate
     * @return true if the String is the proper format, false otherwise
     */
    private boolean validate(String text)
    {
        return text.matches("[$]?[0-9]{0,3}([.][0-9]{0,2})?");
    }
    
    /**
     * Returns the contents of the field as a double
     * @return a double representation of the currency amount
     */
    public double getValue(){
        return Double.parseDouble(getText());
    }
    
    /**
     * Translates the supplied double value to a properly formatted
     * String, and stores it in the field
     * @param value the double to convert
     */
    public void setValue(double value){
        setText(String.format("$%3.2f", value));
    }
}
