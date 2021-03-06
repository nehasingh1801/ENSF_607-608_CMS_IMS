package Client.ClientView;

import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import Client.Controller.ViewController.CustomerViewController.CustomerListener;

public class CustomerView extends JFrame {
	
	private JButton save;
	private JButton delete;
	private JButton clear;
	private JTextField customerID;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField address;
	private JTextField postalCode;
	private JTextField phoneNo;
	private JComboBox typeCustomer;
	private JTextArea displayText;
	private JRadioButton searchCustomerID; 
    private JRadioButton searchLastName;
    private JRadioButton searchCustomerType; 
    private JTextField searchParameter;
    private JButton search;
    private JButton clearSearch;
    
    private ButtonGroup group; 
	
	public CustomerView() {
		
		
		//high-level container
		Container contentPanel = getContentPane();
		contentPanel.setLayout(new BorderLayout());
		
		contentPanel.add("North", new JLabel("Customer Management Screen"));
		
		JPanel rightView = new JPanel(new  BorderLayout());// JPanel for adding right side of Customer GUI
		rightView.add("North", new JLabel("Customer Information"));
		
		JPanel buttons = new JPanel();// JPanel for adding for adding buttons Save, delete, and clear
		
		save = new JButton("Save");
		delete = new JButton("Delete");
		clear = new JButton("Clear");
		
		// adding buttons to JPanel
		buttons.add(save);
		buttons.add(delete);
		buttons.add(clear);
		
		rightView.add("South", buttons);// added buttns to the rightView
		
		JPanel centerRightView = new JPanel();
		centerRightView.setLayout(new GridLayout(7,2,2,2));
		
		centerRightView.add(new JLabel("CustomerID"));//adding CustomerID
		customerID = new JTextField(20);
		centerRightView.add(customerID);
		
		centerRightView.add(new JLabel("First Name"));//adding firstName
		firstName = new JTextField();
		centerRightView.add(firstName);
		
		centerRightView.add(new JLabel("Last Name "));//adding lastName
		lastName = new JTextField();
		centerRightView.add(lastName);
		
		centerRightView.add(new JLabel("Address"));//adding Address
		address = new JTextField();
		centerRightView.add(address);
		
		centerRightView.add(new JLabel("Postal Code"));//adding Postal Code
		postalCode = new JTextField();
		centerRightView.add(postalCode);
		
		centerRightView.add(new JLabel("Phone no"));//adding Phone no
		phoneNo = new JTextField();
		centerRightView.add(phoneNo);
			
		String[] customerType = { "Residential", "Commercial"};// type of residents
		centerRightView.add(new JLabel("Customer type"));//adding residential type
		typeCustomer = new JComboBox(customerType);
		centerRightView.add(typeCustomer);
		
		rightView.add("Center", centerRightView);
		contentPanel.add("East", rightView);
		
		JPanel leftView = new JPanel(new BorderLayout());
		
		displayText = new JTextArea(10,10);
		displayText.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(displayText);
		leftView.add("Center", new JLabel("Search Results :"));
		leftView.add("South", scroll);
		
		JPanel leftNorth = new JPanel(new GridLayout(7,1,2,2));
		leftNorth.add(new JLabel("Search Customers"));
		leftNorth.add(new JLabel("Select type of search to be performed"));
		
		searchCustomerID = new JRadioButton("Customer ID");
		searchLastName = new JRadioButton("Last Name");
	    searchCustomerType = new JRadioButton("Cient Type");
	    
	    group = new  ButtonGroup();
	    group.add(searchCustomerID);
	    group.add(searchLastName);
	    group.add(searchCustomerType);
	    
	    leftNorth.add(searchCustomerID);
	    leftNorth.add(searchLastName);
	    leftNorth.add(searchCustomerType);
	    leftNorth.add(new JLabel("Enter the search parameter below"));
	    
	    JPanel leftViewButtons = new JPanel();// for adding text field, search and clear search
	    searchParameter = new JTextField(20);// for inputting the search text
	    search = new JButton("Search");
	    clearSearch = new JButton("Clear Search");
	    
	    leftViewButtons.add(searchParameter);
	    leftViewButtons.add(search);
	    leftViewButtons.add(clearSearch);
	    leftView.add(leftViewButtons);
		leftView.add("North", leftNorth);
		
		contentPanel.add("West", leftView);
			
	}

	public void addCustomerListener(ActionListener customerListener) {
		// TODO Auto-generated method stub
		search.addActionListener(customerListener);
		save.addActionListener(customerListener);
		delete.addActionListener(customerListener);
		clear.addActionListener(customerListener);
		customerID.addActionListener(customerListener);
		firstName.addActionListener(customerListener);
		lastName.addActionListener(customerListener);
		address.addActionListener(customerListener);
		postalCode.addActionListener(customerListener);
		phoneNo.addActionListener(customerListener);
		typeCustomer.addActionListener(customerListener);
		//displayText.addActionListener(customerListener);
		searchCustomerID.addActionListener(customerListener); 
	    searchLastName.addActionListener(customerListener);
	    searchCustomerType.addActionListener(customerListener); 
	    searchParameter.addActionListener(customerListener);
	    search.addActionListener(customerListener);
	    clearSearch.addActionListener(customerListener);
	}

	public JButton getSave() {
		return save;
	}

	public void setSave(JButton save) {
		this.save = save;
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	public JButton getClear() {
		return clear;
	}

	public void setClear(JButton clear) {
		this.clear = clear;
	}

	public JTextField getCustomerID() {
		return customerID;
	}

	public void setCustomerID(JTextField customerID) {
		this.customerID = customerID;
	}

	public JTextField getFirstName() {
		return firstName;
	}

	public void setFirstName(JTextField firstName) {
		this.firstName = firstName;
	}

	public JTextField getLastName() {
		return lastName;
	}

	public void setLastName(JTextField lastName) {
		this.lastName = lastName;
	}

	public JTextField getAddress() {
		return address;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}

	public JTextField getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(JTextField postalCode) {
		this.postalCode = postalCode;
	}

	public JTextField getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(JTextField phoneNo) {
		this.phoneNo = phoneNo;
	}

	public JComboBox getTypeClient() {
		return typeCustomer;
	}

	public void setTypeCustomer(JComboBox typeCustomer) {
		this.typeCustomer = typeCustomer;
	}

	public JTextArea getDisplayText() {
		return displayText;
	}

	public void setDisplayText(JTextArea displayText) {
		this.displayText = displayText;
	}

	public JRadioButton getSearchCustomerID() {
		return searchCustomerID;
	}

	public void setSearchCustomerID(JRadioButton searchCustomerID) {
		this.searchCustomerID = searchCustomerID;
	}

	public JRadioButton getSearchLastName() {
		return searchLastName;
	}

	public void setSearchLastName(JRadioButton searchLastName) {
		this.searchLastName = searchLastName;
	}

	public JRadioButton getSearchCustomerType() {
		return searchCustomerType;
	}

	public void setSearchCustomerType(JRadioButton searchCustomerType) {
		this.searchCustomerType = searchCustomerType;
	}

	public JTextField getSearchParameter() {
		return searchParameter;
	}

	public void setSearchParameter(JTextField searchParameter) {
		this.searchParameter = searchParameter;
	}

	public JButton getSearch() {
		return search;
	}

	public void setSearch(JButton search) {
		this.search = search;
	}

	public JButton getClearSearch() {
		return clearSearch;
	}

	public void setClearSearch(JButton clearSearch) {
		this.clearSearch = clearSearch;
	}

	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}
	
	
}
