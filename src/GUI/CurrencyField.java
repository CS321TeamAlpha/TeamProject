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
    
    @Override
    public void replaceSelection(String text)
    {
        if(validate(text))
        {
            super.replaceSelection(text);
        }
    }
    
    private boolean validate(String text)
    {
        return text.matches("[$]?[0-9]{0,3}([.][0-9]{0,2})?");
    }
    
    public double getValue(){
        return Double.parseDouble(getText());
    }
    
    public void setValue(double value){
        setText(String.format("$%3.2f", value));
    }
}
