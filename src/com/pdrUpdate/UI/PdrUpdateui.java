package com.pdrUpdate.UI;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;

import com.pdrUpdate.testCases.PDRUpdate;

public class PdrUpdateui 
{

	private JFrame frmPdrUpdateTool;
	public JPasswordField passwordField;
	public TextField username;
	public TextField otp;
	public TextField prno;
	public static String userId;
	public static String pwd;
	public static String ot;
	public static String pr;
	public PDRUpdate pd = new PDRUpdate();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PdrUpdateui window = new PdrUpdateui();
					window.frmPdrUpdateTool.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PdrUpdateui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPdrUpdateTool = new JFrame();
		frmPdrUpdateTool.setTitle("PDR Update tool");
		frmPdrUpdateTool.setBounds(100, 100, 450, 300);
		frmPdrUpdateTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPdrUpdateTool.getContentPane().setLayout(null);
		
		username = new TextField();
		username.setBounds(10, 97, 198, 22);
		frmPdrUpdateTool.getContentPane().add(username);
		
		Label label = new Label("User Name ");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		label.setAlignment(Label.CENTER);
		label.setBounds(47, 69, 141, 22);
		frmPdrUpdateTool.getContentPane().add(label);
		
		Label label_1 = new Label("SSO Password");
		label_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(262, 69, 134, 22);
		frmPdrUpdateTool.getContentPane().add(label_1);
		
		otp = new TextField();
		otp.setBounds(10, 171, 198, 22);
		frmPdrUpdateTool.getContentPane().add(otp);
		
		prno = new TextField();
		prno.setBounds(243, 171, 181, 22);
		frmPdrUpdateTool.getContentPane().add(prno);
		
		Label label_2 = new Label("OTP");
		label_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		label_2.setAlignment(Label.CENTER);
		label_2.setBounds(47, 146, 134, 22);
		frmPdrUpdateTool.getContentPane().add(label_2);
		
		Label label_3 = new Label("PR Number");
		label_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		label_3.setAlignment(Label.CENTER);
		label_3.setBounds(282, 146, 103, 22);
		frmPdrUpdateTool.getContentPane().add(label_3);
		
		Button update = new Button("Update");
		update.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				userId= username.getText();
				pwd= passwordField.getText();
				ot=otp.getText();
				pr=prno.getText();
				try {
					pd.test();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		update.setFont(new Font("Dialog", Font.BOLD, 14));
		update.setBounds(157, 216, 126, 22);
		frmPdrUpdateTool.getContentPane().add(update);
		
		Label label_4 = new Label("PDR Update Tool");
		label_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		label_4.setAlignment(Label.CENTER);
		label_4.setBounds(0, 24, 424, 22);
		frmPdrUpdateTool.getContentPane().add(label_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(243, 97, 181, 22);
		frmPdrUpdateTool.getContentPane().add(passwordField);
		
	}
}
