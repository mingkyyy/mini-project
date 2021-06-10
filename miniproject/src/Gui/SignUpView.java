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

public class SignUpView extends JFrame{
	JLabel signUp, name, id, pw, phonenumber, zip, adress, adress_detail;
	JTextField nameField, idField, pwField,phonenumberField, zipField,adressField,adress_detailField;
	JRadioButton radio1, radio2;
	JButton button, backbutton;
	
	SignUpView() {
		super("회원가입");
		setSize(new Dimension(800, 800));
		setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800,800));
		
		button=new JButton("확인");
		button.setBounds(180,600,300,50);
		 button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new MainView();
					setVisible(false);
					
				}
			});
		 
		 backbutton=new JButton("back");
		 backbutton.setBounds(0,0,60,30);
		 backbutton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new MainView();
						setVisible(false);
						
					}
				});
		
		
		signUp = new JLabel("회원가입");
		signUp.setFont(new Font("Magneto 굵게",Font.BOLD , 30));
		name = new JLabel(" 이름  ");
		name.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		id = new JLabel(" 아이디  ");
		id.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		pw = new JLabel(" 패스워드 ");
		pw.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		phonenumber = new JLabel(" 전화번호 ");
		phonenumber.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		zip = new JLabel(" 우편번호 ");
		zip.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		adress = new JLabel(" 기본주소 ");
		adress.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		adress_detail = new JLabel(" 상세주소 ");
		adress_detail.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		radio1=new JRadioButton("일반 회원");
		radio1.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		radio2=new JRadioButton("가게");
		radio2.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		
		nameField = new JTextField();
		idField = new JTextField();
		pwField = new JTextField();
		phonenumberField=new JTextField();
		zipField=new JTextField();
		adressField=new JTextField();
		adress_detailField=new JTextField();
		
		
		
		
		
		signUp.setBounds(250, 100, 300, 100 );
		name.setBounds(150, 200, 70, 40);
		id.setBounds(150, 250, 70, 40);
		pw.setBounds(150, 300, 70, 40);
		phonenumber.setBounds(150,350,70,40);
		zip.setBounds(150,400,70,40);
		adress.setBounds(150,450,70,40);
		adress_detail.setBounds(150,500,70,40);
		radio1.setBounds(150,550,100,40);
		radio2.setBounds(250,550,100,40);
		
		
		
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
		panel.add(radio1);
		panel.add(radio2);
		panel.add(backbutton);
		
		
		
		panel.add(nameField);
		panel.add(idField);
		panel.add(pwField);
		panel.add(phonenumberField);
		panel.add(zipField);
		panel.add(adressField);
		panel.add(adress_detailField);
		
		panel.add(button);
		
		
				
		add(panel);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SignUpView();
	}

}