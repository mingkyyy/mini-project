package Gui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SearchView extends JFrame {
	
	private JPanel leftPanel;
	private JPanel bigPanel;
	private JPanel smallPanel;
	private JLabel subwayLabel;
	private JLabel searchLabel;
	private JTextArea textarea;
	private JTextField textField;	
	private JButton button, backButton;
	
	
	public SearchView() {
		super("찾는 뷰");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		
		button=new JButton("search");
		
		
		backButton=new JButton("back");
		
	
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainView();
				setVisible(false);
				
			}
		});
				
		
		textarea=new JTextArea();
		textarea.setPreferredSize(new Dimension(200,30));
		
		textField=new JTextField();
		textField.setPreferredSize(new Dimension(250,800));
		
		
		subwayLabel=new JLabel("subway picture");
		subwayLabel.setOpaque(true);
		subwayLabel.setBackground(Color.LIGHT_GRAY);
		
		searchLabel=new JLabel("역 이름을 검색하세요:");
		
		smallPanel=new JPanel();
		smallPanel.setLayout(new FlowLayout());
		smallPanel.add(backButton);
		smallPanel.add(searchLabel);
		smallPanel.add(textarea);
		smallPanel.add(button);
		
		
		leftPanel=new JPanel();
		leftPanel.setLayout(new BorderLayout());
		
		leftPanel.add(subwayLabel,BorderLayout.CENTER);
		leftPanel.add(smallPanel, BorderLayout.NORTH);
		
		
		bigPanel=new JPanel();
		bigPanel.setLayout(new BorderLayout());			
		bigPanel.add(leftPanel, BorderLayout.CENTER);
		bigPanel.add(textField, BorderLayout.EAST);
		this.add(bigPanel);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SearchView();
		
	}

}