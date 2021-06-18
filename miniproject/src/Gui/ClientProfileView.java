package Gui;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Dao.commonDao;
import Dto.commonDto;

/**
 * 회원 정보를 수정하거나 탈퇴 하게 할수있는 gui 클래스
 * 
 *
 */
public class ClientProfileView extends JFrame implements ActionListener {
	JLabel name, clientProfile, phonenumber, zip, adress, adress_detail;
	JTextField nameField, phonenumberField, zipField, adressField, adress_detailField;
	JButton modyfiyButton,leaveButton;
	JFrame parentWindow;
	
	public ClientProfileView(JFrame parentWindow) {
		super("회원정보");
		this.parentWindow = parentWindow;
		commonDto dto = commonDao.getInstance().findById(CurrentUser.id);
		setSize(new Dimension(400, 600));
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setSize(new Dimension(400, 600));

		modyfiyButton = new JButton("수정");
		modyfiyButton.setBounds(220, 110, 100, 40);
		modyfiyButton.addActionListener(this);
		
		leaveButton = new JButton("회원탈퇴");
		leaveButton.setBounds(220, 160, 100, 40);
		leaveButton.addActionListener(this);
		

		clientProfile = new JLabel("회원정보");
		clientProfile.setFont(new Font("Magneto 굵게", Font.BOLD, 30));
		name = new JLabel(" 이름  ");
		name.setFont(new Font("Magneto 굵게", Font.BOLD, 13));
		phonenumber = new JLabel(" 전화번호 ");
		phonenumber.setFont(new Font("Magneto 굵게", Font.BOLD, 13));
		zip = new JLabel(" 우편번호 ");
		zip.setFont(new Font("Magneto 굵게", Font.BOLD, 13));
		adress = new JLabel(" 기본주소 ");
		adress.setFont(new Font("Magneto 굵게", Font.BOLD, 13));
		adress_detail = new JLabel(" 상세주소 ");
		adress_detail.setFont(new Font("Magneto 굵게", Font.BOLD, 13));

		nameField = new JTextField(dto.getName());
		phonenumberField = new JTextField(dto.getPhone());
		zipField = new JTextField(dto.getZip());
		adressField = new JTextField(dto.getAdress());
		adress_detailField = new JTextField(dto.getAdress_detail());

		clientProfile.setBounds(50, 10, 200, 50);
		name.setBounds(20, 100, 70, 40);
		phonenumber.setBounds(20, 130, 70, 40);
		zip.setBounds(20, 160, 70, 40);
		adress.setBounds(20, 190, 70, 40);
		adress_detail.setBounds(20, 220, 70, 40);

		nameField.setBounds(90, 110, 100, 20);
		phonenumberField.setBounds(90, 140, 100, 20);
		zipField.setBounds(90, 170, 100, 20);
		adressField.setBounds(90, 200, 100, 20);
		adress_detailField.setBounds(90, 230, 100, 20);

		panel.setLayout(null);
		panel.add(clientProfile);
		panel.add(name);
		panel.add(phonenumber);
		panel.add(zip);
		panel.add(adress);
		panel.add(adress_detail);
		panel.add(nameField);
		panel.add(phonenumberField);
		panel.add(zipField);
		panel.add(adressField);
		panel.add(adress_detailField);
		panel.add(modyfiyButton);
		panel.add(leaveButton);
		
		add(panel);
		setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		switch (jButton.getText()) {
		case "수정" : {
			onModifyButtonClick();
			break;
		}
		case "회원탈퇴": {
			onLeaveButtonClick();
			break;
		}
		
		default:
		
		}
		
	}
	/**
	 * 회원 정보를 변경할수 있는 메서드
	 */
	private void onModifyButtonClick() {
		commonDto dto = commonDao.getInstance().findById(CurrentUser.id);
		dto.setName(nameField.getText());
		dto.setPhone(phonenumberField.getText());
		dto.setZip(zipField.getText());
		dto.setAdress(adressField.getText());
		dto.setAdress_detail(adress_detailField.getText());
		commonDao.getInstance().update(dto);
		
		dispose();
		
		JOptionPane.showMessageDialog(this, "수정을 완료하였습니다.");
		
	}
	
	/**
	 * 회원 정보를 삭제할수 있는 메서드
	 */
	private void onLeaveButtonClick() {
		commonDao.getInstance().delete(CurrentUser.id);
		CurrentUser.id = null;
		JOptionPane.showMessageDialog(this, "회원탈퇴를 완료하였습니다.");
		
		dispose();
		parentWindow.dispose();
		new MainView();
	}

}