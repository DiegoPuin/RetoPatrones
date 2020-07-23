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
public class OverseasOrder extends Order {

	private double additionalSH;
	private JTextField txtSyHOverseas = new JTextField(20);

	public OverseasOrder() {
		super();
	}

	public OverseasOrder(double inp_orderAmount, double inp_additionalSH) {
		super(inp_orderAmount);
		additionalSH = inp_additionalSH;
	}

	public double getAdditionalSH() {
		return additionalSH;
	}

	public String print() {
		String orders = "OverSeas Order --" + super.print() + " -- " + getAdditionalSH();
		return orders;
	}

	public double accept(OrderVisitor v) {
		return v.visit(this);
	}

	public void setAdditionalSH(double additionalSH) {
		this.additionalSH = additionalSH;
	}

	public String getTxtAdditionalTax() {
		return txtSyHOverseas.getText();
	}

	public void setAdditionalTax(double newAdditionalTax) {
		additionalSH = newAdditionalTax;
	}

	@Override
	public void initialize() {
		txtSyHOverseas.setText("Enter the value of the S & H Overseas");
	}

	@Override
	public void addUIControls() {
		orderUI = new JPanel();
		JLabel lblSyHOverseas = new JLabel("Additional S & H Overseas Order");

		GridBagLayout gridbag = new GridBagLayout();
		orderUI.setLayout(gridbag);
		GridBagConstraints gbc = new GridBagConstraints();
		orderUI.add(lblSyHOverseas);
		orderUI.add(txtSyHOverseas);

		gbc.insets.top = 5;
		gbc.insets.bottom = 5;
		gbc.insets.left = 5;
		gbc.insets.right = 5;

		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gridbag.setConstraints(lblSyHOverseas, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gridbag.setConstraints(txtSyHOverseas, gbc);
	}

}
