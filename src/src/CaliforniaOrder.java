/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Julian Sanchez 
 * @author Diego Puin
 */
public class CaliforniaOrder extends Order {
	private double additionalTax;
	private JTextField txtTaxCalifornian = new JTextField(20);

	public CaliforniaOrder() {
		super();
	}

	public CaliforniaOrder(double inp_orderAmount, double inp_additionalTax) {
		super(inp_orderAmount);
		additionalTax = inp_additionalTax;
	}

	public double getAdditionalTax() {
		return additionalTax;
	}
	
	public String getTxtAdditionalTax() {
		return txtTaxCalifornian.getText();
	}

	public String print() {
		String orders = "CalifornianOrder --" + super.print() + " -- " + getAdditionalTax();
		return orders;
	}

	public double accept(OrderVisitor v) {
		return v.visit(this);
	}

	public void setAdditionalTax(double additionalTax) {
		this.additionalTax = additionalTax;
	}

	@Override
	public void addUIControls() {
		orderUI = new JPanel();
		JLabel lblTaxCalifornian = new JLabel("Additional Tax (CA Orders Only)");

		GridBagLayout gridbag = new GridBagLayout();
		orderUI.setLayout(gridbag);
		GridBagConstraints gbc = new GridBagConstraints();
		orderUI.add(lblTaxCalifornian);
		orderUI.add(txtTaxCalifornian);

		gbc.insets.top = 5;
		gbc.insets.bottom = 5;
		gbc.insets.left = 5;
		gbc.insets.right = 5;

		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gridbag.setConstraints(lblTaxCalifornian, gbc);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gridbag.setConstraints(txtTaxCalifornian, gbc);
	}

	@Override
	public void initialize() {
		txtTaxCalifornian.setText("Enter the tax value");
	}

}
