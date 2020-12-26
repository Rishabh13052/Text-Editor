import java.awt.*; 
import javax.swing.*; 
import java.io.*; 
import java.awt.event.*; 
import javax.swing.text.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager; 
public class editor extends JFrame {
	
	JTextPane t;
	JFrame f;
	JPanel p1,p2;
	JMenuBar m;
	JButton btn;
	UndoManager un = new UndoManager();
	editor(){
		
		p1=new JPanel();
    	p2=new JPanel();
    	f= new JFrame("NotePad+++");
		t=new JTextPane();
		m=new JMenuBar();
		JMenu m1=new JMenu("File");
		
		Font bigFont = new Font( "Serif", Font.BOLD, 16 );
        Font littleFont = new Font( "Monospaced", Font.BOLD, 14 );
        
		m1.setMnemonic(KeyEvent.VK_F);
		m1.setFont(bigFont);
		
		JMenu m2=new JMenu("Edit");
		m2.setMnemonic(KeyEvent.VK_E);
		m2.setFont(bigFont);
		
		JMenu m5=new JMenu("Action");
		m5.setMnemonic(KeyEvent.VK_A);
		m5.setFont(bigFont);
		
		JMenu m3=new JMenu("Help");
		m3.setMnemonic(KeyEvent.VK_H);
		m3.setFont(bigFont);
		
		JMenu m4=new JMenu("Format");
		m4.setMnemonic(KeyEvent.VK_F);
		m4.setFont(bigFont);
		
		
		JMenu m6=new JMenu("FontStyle");
		JMenu m7=new JMenu("FontName");
		JMenuItem m8=new JMenuItem("Theme");
		m6.setFont(littleFont);
		m7.setFont(littleFont);
		m8.setFont(littleFont);
		
		btn=new JButton();
		btn.setBackground(Color.magenta);
		//btn.setLabel("Close");
		 f.setJMenuBar(m);  
         f.setSize(1000,1000);  
        // m.setBackground(Color.cyan);
         
         
         f.setVisible(true);
         m.add(m1);
		 m.add(m2);
		 m.add(m5);
		 m.add(m4);
		 m.add(m3);
		 //m.add(btn);
		 
		 m1.setForeground(Color.red);
		 
		 m1.setSize(10,10);
		 
		 
		 
		JMenuItem mitem1=new JMenuItem("New");
		mitem1.setFont(littleFont);
		JMenuItem mitem2= new JMenuItem("Open");
		mitem2.setFont(littleFont);
		JMenuItem mitem3= new JMenuItem("Save");
		mitem3.setFont(littleFont);
		JMenuItem mitem11= new JMenuItem("Print");
		mitem11.setFont(littleFont);
		JMenuItem mitem12= new JMenuItem("Exit");
		mitem12.setFont(littleFont);
		JMenuItem mitem4= new JMenuItem("Cut");
		mitem4.setFont(littleFont);
		JMenuItem mitem5= new JMenuItem("Copy");
		mitem5.setFont(littleFont);
		JMenuItem mitem6= new JMenuItem("Paste");
		mitem6.setFont(littleFont);
		JMenuItem mitem7= new JMenuItem("View_Help");
		mitem7.setFont(littleFont);
		JMenuItem mitem8= new JMenuItem("About");
		mitem8.setFont(littleFont);
		JMenuItem mitem9= new JMenuItem("Undo");
		mitem9.setFont(littleFont);
		JMenuItem mitem10= new JMenuItem("Redo");
		mitem10.setFont(littleFont);
		JMenuItem mitem13= new JMenuItem("Plain");
		Font plainFont = new Font( "Monospaced", Font.PLAIN, 14 );
		mitem13.setFont(plainFont);
		
		JMenuItem mitem14= new JMenuItem("Bold");
		mitem14.setFont(littleFont);
		
		JMenuItem mitem15= new JMenuItem("Italic");
		Font italicFont = new Font( "Monospaced", Font.ITALIC, 14 );
		mitem15.setFont(italicFont);
		
		JMenuItem mitem16= new JMenuItem("Bold+Italic");
		Font bolditalicFont = new Font( "Monospaced", Font.ITALIC+Font.BOLD, 14 );
		mitem16.setFont(bolditalicFont);
		
		JMenuItem mitem17= new JMenuItem("Arial");
		Font ArialFont = new Font( "Arial", Font.PLAIN, 14 );
		mitem17.setFont(ArialFont);
		
		JMenuItem mitem18= new JMenuItem("Calibri");
		Font CalibriFont = new Font( "Calibri", Font.PLAIN, 14 );
		mitem18.setFont(CalibriFont);
		
		JMenuItem mitem19= new JMenuItem("Century");
		Font CenturyFont = new Font( "Century", Font.PLAIN, 14 );
		mitem19.setFont(CenturyFont);
		
		JMenuItem mitem20= new JMenuItem("Terminal");
		Font TerminalFont = new Font( "Terminal", Font.PLAIN, 14 );
		mitem19.setFont(TerminalFont);
		
		
		JMenuItem mitem21= new JMenuItem("Default");
		mitem21.setFont(littleFont);
		
		JMenuItem mitem22= new JMenuItem("Secondary");
		mitem22.setFont(littleFont);
		m1.add(mitem1);
		m1.add(mitem2);
		m1.add(mitem3);
		m1.add(mitem11);
		m1.add(mitem12);
		
		m2.add(mitem4);
		m2.add(mitem5);
		m2.add(mitem6);
		
		m3.add(mitem7);
		m3.add(mitem8);    
		
		m5.add(mitem9);
		m5.add(mitem10);

		m4.add(m6);
		m4.add(m7);
		m4.add(m8);
		
		m6.add(mitem13);
		m6.add(mitem14);
		m6.add(mitem15);
		m6.add(mitem16);
		
		m7.add(mitem17);
		m7.add(mitem18);
		m7.add(mitem19);
		m7.add(mitem20);
		
		//m8.add(mitem21);
		//m8.add(mitem22);
		
		f.add(t);
		
		KeyStroke k = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
         	mitem1.setAccelerator(k);
		
		KeyStroke k1 = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
         	mitem3.setAccelerator(k1);
         	
        KeyStroke k2 = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
         	mitem4.setAccelerator(k2);
         	
        KeyStroke k3 = KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK);
         	mitem6.setAccelerator(k3); 
         		
        KeyStroke k4 = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
         	mitem2.setAccelerator(k4);
         	
        KeyStroke k5 = KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);
         	mitem11.setAccelerator(k5); 	 			 	
		
		KeyStroke k6 = KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
         	mitem9.setAccelerator(k6); 	
         		
        KeyStroke k7 = KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK);
         	mitem10.setAccelerator(k7); 
         		
        KeyStroke k8 = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
         	mitem5.setAccelerator(k8); 	
         		  				 		
		
		mitem7.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    				JOptionPane.showMessageDialog(f, "the user cancelled the operation"); 

    			} 
    		});
		
		mitem8.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    				JOptionPane.showMessageDialog(f, "This editor has developed by XYZ.This product is Licensed under XYZ"); 

    			} 
    		});
		
		mitem12.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    				dispose();
    			
    				System.exit(0);
    				//f.setVisible(false);
    			} 
    		});
    	mitem4.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.cut();
    			} 
    		});
    	mitem5.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.copy();
    			} 
    		});
    		
    	mitem2.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			JFileChooser j = new JFileChooser("f:"); 
   
            int r = j.showOpenDialog(null); 
  
            
            if (r == JFileChooser.APPROVE_OPTION) { 
                 
                File fi = new File(j.getSelectedFile().getAbsolutePath()); 
  
                try { 
                   
                    String s1 = "", sl = ""; 
  
                    FileReader fr = new FileReader(fi); 
   
                    BufferedReader br = new BufferedReader(fr); 
                     sl = br.readLine(); 
                    while ((s1 = br.readLine()) != null) { 
                        sl = sl + "\n" + s1; 
                    } 
                    t.setText(sl); 
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(f, evt.getMessage()); 
                } 
            } 
            
            else
                JOptionPane.showMessageDialog(f, "the user cancelled the operation"); 
        } 
    			 
    		});			
		
		mitem6.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.paste();
    			} 
    		});
    	
    	mitem3.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			JFileChooser j = new JFileChooser("f:"); 
   				int r = j.showSaveDialog(null); 
            	 	if (r == JFileChooser.APPROVE_OPTION) { 
   
                	File fi = new File(j.getSelectedFile().getAbsolutePath()); 
  
                try { 
       
                    FileWriter wr = new FileWriter(fi, false); 
   
                    BufferedWriter w = new BufferedWriter(wr); 
  
                    w.write(t.getText()); 
  
                    w.flush(); 
                    w.close(); 
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(f, evt.getMessage()); 
                } 
            } 
    			} 
    		});	
 		
 		mitem11.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			try {  
                t.print(); 
            } 
            catch (Exception evt) { 
                JOptionPane.showMessageDialog(f, evt.getMessage()); 
            }
    			} 
    		});
 		   		
    	mitem1.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.setText("");
    			//Container contentPane = JFrame.getContentPane();
    			//contentPane.add( new MyPanel());
    			} 
    		});
    		
    	t.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				un.addEdit(e.getEdit());
			}
		});
    		
    	mitem9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					un.undo();
				} catch (Exception ex) {
				}
			}
		});		
		
		mitem10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					un.redo();
				} catch (Exception ex) {
				}
			}
		});
		
		/*mitem21.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.setForeground(new Color(10, 10, 20)); 
         		t.setBackground(new Color(250, 250, 250));	
         
    			} 
    		});
    		*/
    	m8.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			//t.setBackground(new Color(10, 10, 20)); 
         		//t.setForeground(new Color(250, 250, 250));	
         		Color c = JColorChooser.showDialog(t, "ColorChooserDemo", null);
            		t.setBackground(c);
    			} 
    		});	
    		
    	
		mitem13.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.setFont(new Font("Calibri",Font.PLAIN, 14));
    			} 
    		});
    	
    	mitem14.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.setFont(new Font("Calibri", Font.BOLD, 14));	
         
    			} 
    		});
    		
    	mitem15.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.setFont(new Font("Calibri", Font.ITALIC, 14));	
         
    			} 
    		});
    		
    	mitem16.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
         
    			} 
    		});
    		
    	mitem17.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.setFont(new Font("Arial", Font.BOLD, 14));	
         
    			} 
    		});
    		
    	mitem18.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.setFont(new Font("Calibri", Font.BOLD, 14));
         
    			} 
    		});
    		
    	mitem19.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.setFont(new Font("Century", Font.BOLD, 14));	
         
    			} 
    		});
    		
    	mitem20.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent ae)
    			{
    			t.setFont(new Font("Terminal", Font.BOLD, 14));
    			} 
    		});
    		
    										
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//dispose();	
		}
	
	}