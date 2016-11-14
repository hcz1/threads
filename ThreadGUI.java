// add imports here
import javax.swing.*; // provides basic window features

 /**
  * This is the main GUI class for visualisation the coding/decoding.
 */
 
 public class ThreadGUI extends JFrame  {
    
	// TODO: data members required here. See JAVADOC.		
	
	/** The shared accumulator/decoder */
	private Accum sharedResource;
	
	/** Contains first thread with its code and current textual value */	
	private CodeWriter thread1;
	
	/** Contains second thread with its code and current textual value */	
	private CodeWriter thread2;

	/*Declaring the JLabels and JButtons*/
	private JLabel msg1;
	private JLabel decoder;
	private JLabel msg2;
	private JButton go;
	
	
    /**
     * Creates new form ThreadGUI
     */
    public ThreadGUI() {
	
		// TODO: Add code here. Hint - initComponents will automatically set your GUI once all data members are present, as well as CodeWriter and Accum are implemented.
		// Remember to add an actionListener to the go button that starts all threads.
	initComponents();
    }


	// TODO: Add additional methods here. See JAVADOC.

	
    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
		String src= JOptionPane.showInputDialog("Enter Word 1");
		String dest= JOptionPane.showInputDialog("Enter Word 2");
	
        msg1 = new javax.swing.JLabel();
        decoder = new javax.swing.JLabel();
        msg2 = new javax.swing.JLabel();

        go = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg1.setText("Message 1");
	
        decoder.setText("Decoder");

        msg2.setText("Message 2");

	    sharedResource = new Accum(10);

		thread1 = new CodeWriter(src,4000, sharedResource);
		thread2 = new CodeWriter(dest,3500, sharedResource);

        thread1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        thread1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thread1.setName(""); // NOI18N

        thread2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        thread2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sharedResource.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sharedResource.setForeground(new java.awt.Color(255, 0, 51));
        sharedResource.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sharedResource.setToolTipText("This accumulator performs the decoding");

        go.setText("Go");
        go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				thread1.start();
				thread2.start();
				go.setEnabled(false);                
            }
        });

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msg1)
                    .addComponent(msg2)
                    .addComponent(decoder))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thread2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(thread1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(sharedResource, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(go)
                .addGap(264, 264, 264))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msg1)
                    .addComponent(thread1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(decoder)
                    .addComponent(sharedResource, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msg2)
                    .addComponent(thread2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(go)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    

	public static void main(String[] args){
		ThreadGUI t = new ThreadGUI();
		t.setVisible(true);
	}


	
	

	
}