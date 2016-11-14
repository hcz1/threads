// add imports here
import javax.swing.*; 
import java.lang.*;
import java.awt.*;




 /**
  * CodeWriter holds the current state of a piece of text that is being decoded.
 */
 

public class CodeWriter extends JLabel implements Runnable  {
 
 // data members required here. See JAVADOC.
 private StringBuffer buf;
 private int delay;
 private int id;
 private Accum ref;
 private Thread thread;
 private static int threadNo;
 private StringBuffer b;
/** 
 * Creates a code to be decoded.
 * @param nval initial text to be decoded.
 * @param ndelay Delay in milliseconds before next decode request
 * @param t reference to the accumulator to pass characters to
 */
 
   public CodeWriter(String nval, int ndelay, Accum t) {
	   super(nval);
	   buf=new StringBuffer(nval);
	   delay = ndelay;
	   ref = t;
	   
	  
   }

public void start() {
	// TODO Auto-generated method stub
	thread = new Thread(this);
	thread.start();
	
}

public void run() {

	

	for (int i = 0; i < buf.length(); i++) {
		synchronized((Integer)(threadNo)) {
			char o = buf.charAt(i);

			ref.setAccum(o);
			ref.setText(o + "-->" + ref.decode());
			if (ref.decode() != -1) {
				String y = Integer.toString(ref.decode());
				buf.replace(i, i + 1, y);
				this.setText(buf.toString());
				this.revalidate();
			}else { 
				String y = Integer.toString(ref.decode());
				buf.replace(i, i + 1, y);
				this.setText(buf.toString());
				this.revalidate();
				
				}

			if (ref.decode() > 9 || ref.decode()< 0) {
				i++;
			}
		}
		try {
			thread.sleep(delay);

		} catch (InterruptedException e) {

		}
	}
}

public void stop(){
	thread = null;
	
	
}
} // end class ArrayWriter
