// add imports here
import javax.swing.*;
import java.lang.*;
import java.awt.*;

/**
* The accumulator class can only store 1 alphabetic character, which it can convert to its numerical equivalent.
*/

public class Accum extends JLabel {
	// TODO: data members required here. See JAVADOC.	
	private int delay;
	private char holding;
	
	
	/** Argumentless constructor - initialises GUI components */
	public Accum() {
	
	// TODO: Add code here.
	
	delay=0;
	holding = ' ';
	}

	
    /**
     * Argumented constructor - calls argumentless constructor
	 * @param delay time in milliseconds it takes to process a character
     */	
	public Accum(int delay){
	this();
	this.setBorder(BorderFactory.createLineBorder(Color.black, 5));
	this.revalidate();
	this.delay = delay;
	
	
	// TODO: Add code here.
	}
	
	
	// TODO: Add additional methods here. See JAVADOC.
	public int decode(){

	
		
		holding = Character.toUpperCase(holding);
		
		int x=holding;
		 
		
		if(x<91 && x>64){
			x=x-64;
			return x;
			} else if (x<91 && x>96){
				x=x-128;
				return x;
				}else
					return -1;
			
	}
	
	public void setAccum(char val){
		holding = val; 
		
	}

	
	
	
} // end class Accum