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
public class ColombianOrder extends Order {
	private double additionalSH;
	private JTextField txtSyHColombian = new JTextField(20);

	public ColombianOrder() {
		super();
	}

	public ColombianOrder(double inp_orderAmount, double inp_additionalSH) {
		super(inp_orderAmount);
		additionalSH = inp_additionalSH;
	}

	public double getAdditionalSH() {
		return additionalSH;
	}

	public String print() {
		String orders = "ColombianOrder --" + super.print() + " -- " + getAdditionalSH();
		return orders;
	}

	public double accept(OrderVisitor v) {
		return v.visit(this);
	}

	public void setAdditionalSH(double additionalSH) {
		this.additionalSH = additionalSH;
	}

	public String getTxtAdditionalTax() {
		return txtSyHColombian.getText();
	}

	@Override
	public void addUIControls() {
		orderUI = new JPanel();
		JLabel lblSyHColombian = new JLabel("Additional S & H Colombian Order");

		GridBagLayout gridbag = new GridBagLayout();
		orderUI.setLayout(gridbag);
		GridBagConstraints gbc = new GridBagConstraints();
		orderUI.add(lblSyHColombian);
		orderUI.add(txtSyHColombian);

		gbc.insets.top = 5;
		gbc.insets.bottom = 5;
		gbc.insets.left = 5;
		gbc.insets.right = 5;

		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gridbag.setConstraints(lblSyHColombian, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gridbag.setConstraints(txtSyHColombian, gbc);
	}

	@Override
	public void initialize() {
		txtSyHColombian.setText("Enter the value of the S & H Colombian");
	}

}