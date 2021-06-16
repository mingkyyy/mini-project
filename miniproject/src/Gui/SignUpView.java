package Gui;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Dao.commonDao;
import Dto.commonDto;

public class SignUpView extends JFrame implements ActionListener {
	JLabel name, signUp, id, pw, phonenumber, zip, adress, adress_detail;
	JTextField nameField, idField, pwField, phonenumberField, zipField, adressField, adress_detailField;
	JButton button, backbutton;
	JRadioButton typebutton, typebutton1;

	SignUpView() {
		super("회원가입");
		setSize(new Dimension(800, 800));
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800, 800));

		button = new JButton("확인");
		button.setBounds(180, 600, 300, 50);
		button.addActionListener(this);

		backbutton = new JButton("back");
		backbutton.setBounds(0, 0, 60, 30);
		backbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainView();
				setVisible(false);

			}
		});
		
		typebutton = new JRadioButton("일반회원");
		typebutton1 = new JRadioButton("사장님");
		
		typebutton.setBounds(220, 560, 80 , 20);
		typebutton1.setBounds(300, 560, 80, 20);

		signUp = new JLabel("일반 회원가입");
		signUp.setFont(new Font("Magneto 굵게", Font.BOLD, 30));
		name = new JLabel(" 이름  ");
		name.setFont(new Font("Magneto 굵게", Font.BOLD, 13));
		id = new JLabel(" 아이디  ");
		id.setFont(new Font("Magneto 굵게", Font.BOLD, 13));
		pw = new JLabel(" 패스워드 ");
		pw.setFont(new Font("Magneto 굵게", Font.BOLD, 13));
		phonenumber = new JLabel(" 전화번호 ");
		phonenumber.setFont(new Font("Magneto 굵게", Font.BOLD, 13));
		zip = new JLabel(" 우편번호 ");
		zip.setFont(new Font("Magneto 굵게", Font.BOLD, 13));
		adress = new JLabel(" 기본주소 ");
		adress.setFont(new Font("Magneto 굵게", Font.BOLD, 13));
		adress_detail = new JLabel(" 상세주소 ");
		adress_detail.setFont(new Font("Magneto 굵게", Font.BOLD, 13));

		nameField = new JTextField();
		idField = new JTextField();
		pwField = new JTextField();
		phonenumberField = new JTextField();
		zipField = new JTextField();
		adressField = new JTextField();
		adress_detailField = new JTextField();

		signUp.setBounds(250, 100, 300, 100);
		name.setBounds(150, 200, 70, 40);
		id.setBounds(150, 250, 70, 40);
		pw.setBounds(150, 300, 70, 40);
		phonenumber.setBounds(150, 350, 70, 40);
		zip.setBounds(150, 400, 70, 40);
		adress.setBounds(150, 450, 70, 40);
		adress_detail.setBounds(150, 500, 70, 40);

		nameField.setBounds(220, 200, 300, 40);
		idField.setBounds(220, 250, 300, 40);
		pwField.setBounds(220, 300, 300, 40);
		phonenumberField.setBounds(220, 350, 300, 40);
		zipField.setBounds(220, 400, 300, 40);
		adressField.setBounds(220, 450, 300, 40);
		adress_detailField.setBounds(220, 500, 300, 40);

		panel.setLayout(null);
		panel.add(signUp);
		panel.add(name);
		panel.add(id);
		panel.add(pw);
		panel.add(phonenumber);
		panel.add(zip);
		panel.add(adress);
		panel.add(adress_detail);
		panel.add(backbutton);

		panel.add(nameField);
		panel.add(idField);
		panel.add(pwField);
		panel.add(phonenumberField);
		panel.add(zipField);
		panel.add(adressField);
		panel.add(adress_detailField);

		panel.add(button);
		panel.add(typebutton);
		panel.add(typebutton1);

		add(panel);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("aaa");
		String name = nameField.getText();
		String id = idField.getText();
		String pw = pwField.getText();
		String phoneNumber = phonenumberField.getText();
		String zip = zipField.getText();
		String adress = adressField.getText();
		String adressDetail = adress_detailField.getText();
		int type;
		if(typebutton.isSelected()) {
			type = 0;
		}else{
			type =1;
		}
		
		
		commonDto dto = new commonDto();
		dto.setName(name);
		dto.setId(id);
		dto.setPassword(pw);
		dto.setPhone(phoneNumber);
		dto.setZip(zip);
		dto.setAdress(adress);
		dto.setAdress_detail(adressDetail);
		dto.setType(type);

		commonDao dao = commonDao.getInstance();
		dao.insert(dto);

		dispose();
		new MainView();

	}

	public static void main(String[] args) {
		new SignUpView();
	}

}