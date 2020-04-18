package edu.aiub.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.aiub.bank.model.Account;
import edu.aiub.bank.util.AccountManager;

public class FrameStudentInfo extends JFrame implements ActionListener{
	public AccountManager am;
	private ArrayList<Account> accounts;
	private int currentIndex = 0;
	private JTextField tfName;
	private JTextField tfAmount;
	private JTextField tfAccountNumber;
	public FrameStudentInfo(AccountManager am) {
		super("Banking Systems"); 
		this.am = am;
		accounts = am.getAccounts();
		setSize(500,400);
		//setVisible(true);
		
//		setLayout(new FlowLayout());
//		setLayout(new GridLayout(3,3));
		
		setLayout(new BorderLayout());
		
		JLabel nameLabel = new JLabel("Account info: ");
		nameLabel.setForeground(Color.blue);
		add(nameLabel, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5,2));
		centerPanel.add(new JLabel("Name:"));
		tfName = new JTextField(40);
		//tf.setText("Tahmid");
		centerPanel.add(tfName);		
		
		centerPanel.add(new JLabel("Account Number:"));
		tfAccountNumber = new JTextField(40);
		centerPanel.add(tfAccountNumber);
		//JPanel jp = new JPanel();
		//jp.add(tf2);
		//jp.setLayout(new FlowLayout());
		//centerPanel.add(jp);
		add(centerPanel, BorderLayout.CENTER);
		
		centerPanel.add(new JLabel("Amount:"));
		tfAmount = new JTextField(40);
		centerPanel.add(tfAmount);
		add(centerPanel, BorderLayout.CENTER);
		
//		centerPanel.add(new JLabel("Amount to withdraw:"));
//		JTextField tf4 = new JTextField(40);
//		centerPanel.add(tf4);
//		add(centerPanel, BorderLayout.CENTER);
//		
//		centerPanel.add(new JLabel("Amount to deposit:"));
//		JTextField tf5 = new JTextField(40);
//		centerPanel.add(tf5);
//		add(centerPanel, BorderLayout.CENTER);
		
		
		
		JPanel bottomPanel = new JPanel();	
		JButton bt = new JButton("<< Previous");
		bt.addActionListener(this);
		bottomPanel.add(bt);		
		bt = new JButton("Save");
		bt.addActionListener(this);
		bottomPanel.add(bt);
		bt = new JButton("Delete");
		bt.addActionListener(this);
		bottomPanel.add(bt);
		bt = new JButton("Next >> ");
		bt.addActionListener(this);
		
		bottomPanel.add(bt);
		add(bottomPanel, BorderLayout.SOUTH);
		
		revalidate();
//		repaint();
		addWindowListener(new MyWindowManager());
	
		updateAccountInfo(currentIndex);
	}

	void process() {

		int ret = JOptionPane.showConfirmDialog(null, "Do you really want to close the window?", "Close Window", 
				JOptionPane.YES_NO_OPTION);

		if(ret == JOptionPane.YES_OPTION) {
			System.out.println("Exiting");
			System.exit(0);
		}
		
	}
	private void updateAccountInfo(int index) {
		if (index<0 || index>=accounts.size()) {
			return;
		}
		Account ac = accounts.get(index);
		tfName.setText(ac.getAccountHoldersName());
		tfAccountNumber.setText(ac.getAccountNumber());
		tfAmount.setText(ac.getBalance()+"");
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Click registered");
		if (e.getActionCommand().equals("Next >> ")) {
			System.out.println("Next Clicked");
			if (currentIndex<accounts.size()-1) {
			updateAccountInfo(++currentIndex);
			}
		}
		if (e.getActionCommand().equals("<< Previous")) {
			System.out.println("Previous Clicked");
			if (currentIndex>0) {
			updateAccountInfo(--currentIndex);
			}
		}
		if (e.getActionCommand().equals("Save")) {
			System.out.println("Save");
		}
		if (e.getActionCommand().equals("Delete")) {
			System.out.println("Delete Clicked");
		}
		
		
	}
	
	
	
}
