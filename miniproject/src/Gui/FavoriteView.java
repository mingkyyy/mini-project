package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class FavoriteView extends JFrame {
	JLabel favorite;
	private JTextArea textArea;
	
	
	public FavoriteView() {
		super("찜한 가게");
		setSize(new Dimension(800, 800));
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800,800));
		
		favorite = new JLabel("찜한 가게들");
		favorite.setFont(new Font("Magneto 굵게",Font.BOLD , 30));
		favorite.setBounds(50, 30 ,200, 80 );
		
		panel.setLayout(null);
		panel.add(favorite);
		panel.add(getShopPanel());
		
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	JPanel getShopPanel() {
		textArea = new JTextArea();
		
		
		textArea.setEditable(false);
		textArea.setPreferredSize(new Dimension(600, 500));
		textArea.setBackground(Color.lightGray);
		
		JPanel panel = new JPanel();
		panel.add(textArea);
		panel.setBounds(50, 130, 600, 500);
		
		
		return panel;
	}
	
	public static void main(String[] args) {
		new FavoriteView();
	}

}