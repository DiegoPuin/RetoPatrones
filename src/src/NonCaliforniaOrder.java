package src;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Julian Sanchez 
 * @author Diego Puin
 */
public class NonCaliforniaOrder extends Order {

	public NonCaliforniaOrder() {
		super();
	}

	public NonCaliforniaOrder(double inp_orderAmount) {
		super(inp_orderAmount);
	}

	public String print() {
		String orders = "Non CaliforniaOrder --" + super.print();
		return orders;
	}

	public double accept(OrderVisitor v) {
		return v.visit(this);
	}

	public void addUIControls() {
		orderUI = new JPanel();
		JLabel lblTaxNonCalifornian = new JLabel("This type of order has no additional taxes");

		GridBagLayout gridbag = new GridBagLayout();
		orderUI.setLayout(gridbag);
		GridBagConstraints gbc = new GridBagConstraints();
		orderUI.add(lblTaxNonCalifornian);

		gbc.insets.top = 5;
		gbc.insets.bottom = 5;
		gbc.insets.left = 5;
		gbc.insets.right = 5;

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gridbag.setConstraints(lblTaxNonCalifornian, gbc);
	}

	@Override
	public void initialize() {
	}

}