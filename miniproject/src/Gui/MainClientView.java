package Gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainClientView extends JFrame implements ActionListener {
	private JButton membershipButton, logOutButton;
	private JButton findButton, myShopButton;
	private CardLayout card;
	
	public MainClientView() {
		super("반찬 on subway");
		setLayout(new BorderLayout());
		add(getNorthPanel(), BorderLayout.NORTH);
		add(getCenterPanel(), BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(800, 800));
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JPanel getCenterPanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 720));

		JLabel mainName = new JLabel("반찬 \n on subway");
		mainName.setFont(new Font("Magneto 굵게", Font.BOLD, 40));
		mainName.setHorizontalAlignment(JLabel.CENTER);
		mainName.setBounds(150, 200, 400, 100);

		findButton = new JButton("가게 찾기");
		findButton.addActionListener(this);
		myShopButton = new JButton("찜한 가게");
		myShopButton.addActionListener(this);

		findButton.setBounds(150, 400, 150, 100);
		myShopButton.setBounds(350, 400, 150, 100);

		panel.setLayout(null);
		panel.add(mainName);
		panel.add(findButton);
		panel.add(myShopButton);

		return panel;

	}

	private JPanel getNorthPanel() {
		membershipButton = new JButton("회원정보");
		membershipButton.addActionListener(this);
		logOutButton = new JButton("로그아웃");
		logOutButton.addActionListener(this);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		panel.add(membershipButton);
		panel.add(logOutButton);

		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		switch (jButton.getText()) {
		case "회원정보": {
			onMembershipClick();
			break;
		}
		case "로그아웃": {
			onLogOutButtonClick();
			break;
		}
		case "가게 찾기": {
			onSearchButtonClick();
			break;
		}
		case "찜한 가게": {
			onFavoriteButtonClick();
			break;
		}
		default:

		}

	}

	private void onMembershipClick() {
		ClientProfileView pv = new ClientProfileView(this);
		pv.setVisible(true);
		pv.setLocationRelativeTo(this);
		
	}

	private void onLogOutButtonClick() {
		MainView Mainview = new MainView();
		Mainview.setVisible(true);
		Mainview.setLocationRelativeTo(null);

		dispose();
	}

	private void onFavoriteButtonClick() {
		FavoriteView favoriteView = new FavoriteView();
		favoriteView.setVisible(true);
		favoriteView.setLocationRelativeTo(null);

		this.dispose();
	}

	private void onSearchButtonClick() {
		SearchView searchView = new SearchView();
		searchView.setVisible(true);
		searchView.setLocationRelativeTo(null);
		this.dispose();
		new MainView();
	}

	public static void main(String[] args) {
		new MainClientView();
	}

}