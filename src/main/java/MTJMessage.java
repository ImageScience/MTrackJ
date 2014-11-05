import ij.gui.GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MTJMessage extends Dialog implements ActionListener, KeyListener, WindowListener {
	
	private final static Font font = new Font("Dialog",Font.PLAIN,11);
	
	public MTJMessage(final Frame parent, final String title, final String message) {
		
		super(parent,title,true);
		if (message == null) return;
		setLayout(new BorderLayout(0,0));
		
		final Label label = new Label("   "+message);
		label.setFont(font);
		Panel panel = new Panel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		panel.add(label);
		add("North",panel);
		
		final Button button = new Button("  OK  ");
		button.setFont(font);
		button.addActionListener(this);
		button.addKeyListener(this);
		panel = new Panel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		panel.add(button);
		add("Center",panel);
		
		panel = new Panel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));
		add("South",panel);
		
		pack();
		GUI.center(this);
		addWindowListener(this);
		setResizable(true);
		setVisible(true);
	}
	
	private void quit() { setVisible(false); dispose(); }
	
	public void actionPerformed(final ActionEvent e) { quit(); }
	
	public void keyPressed(final KeyEvent e) { if (e.getKeyCode() == KeyEvent.VK_ENTER) quit(); }
	
	public void keyReleased(final KeyEvent e) { }
	
	public void keyTyped(final KeyEvent e) { }
	
	public void windowActivated(final WindowEvent e) { }
	
	public void windowClosed(final WindowEvent e) { }
	
	public void windowClosing(final WindowEvent e) { quit(); }
	
	public void windowDeactivated(final WindowEvent e) { }
	
	public void windowDeiconified(final WindowEvent e) { }
	
	public void windowIconified(final WindowEvent e) { }
	
	public void windowOpened(final WindowEvent e) { }
	
}
