package src;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Julian Sanchez 
 * @author Diego Puin
 */
public class OrderManager extends JFrame {
	public static final String newline = "\n";
	public static final String GET_TOTAL = "Get Total";
	public static final String CREATE_ORDER = "Create Order";
	public static final String EXIT = "Exit";
	public static final String CA_ORDER = "California Order";
	public static final String NON_CA_ORDER = "Non-California Order";
	public static final String OVERSEAS_ORDER = "Overseas Order";
	public static final String COLOMBIAN_ORDER = "Colombian Order";
	public static final String MODIFY = "Modify order";
	public static final String BLANK = "";

	private JComboBox cmbOrderType;
	private JTextField txtOrderAmount;
	private JLabel lblOrderType, lblOrderAmount, lblTotal, lblTotalValue;
	private JPanel pOrder;
	OrderComponent allOrders;
	OrderVisitor objVisitor;
	private JTextArea txtAreaResult;

	public OrderManager() {
		super("Visitor Pattern whit improvements");

		// Create the visitor instance

		allOrders = new OrderComposite();
		objVisitor = new OrderVisitor();

		pOrder = new JPanel();

		cmbOrderType = new JComboBox();
		cmbOrderType.addItem(OrderManager.BLANK);
		cmbOrderType.addItem(OrderManager.CA_ORDER);
		cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
		cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);
		cmbOrderType.addItem(OrderManager.COLOMBIAN_ORDER);

		txtOrderAmount = new JTextField(10);

		lblOrderType = new JLabel("Order Type:");
		lblOrderAmount = new JLabel("Order Amount:");
		lblTotal = new JLabel("Result:");
		lblTotalValue = new JLabel("Click Create or GetTotal Button");
		txtAreaResult = new JTextArea();

		// Create the open button
		JButton getTotalButton = new JButton(OrderManager.GET_TOTAL);
		getTotalButton.setMnemonic(KeyEvent.VK_G);
		JButton createOrderButton = new JButton(OrderManager.CREATE_ORDER);
		getTotalButton.setMnemonic(KeyEvent.VK_C);
		JButton exitButton = new JButton(OrderManager.EXIT);
		exitButton.setMnemonic(KeyEvent.VK_X);
		JButton modifyButton = new JButton(OrderManager.MODIFY);
		modifyButton.setMnemonic(KeyEvent.VK_Y);
		ButtonHandler objButtonHandler = new ButtonHandler(this);

		getTotalButton.addActionListener(objButtonHandler);
		createOrderButton.addActionListener(objButtonHandler);
		exitButton.addActionListener(objButtonHandler);
		modifyButton.addActionListener(objButtonHandler);
		cmbOrderType.addActionListener(objButtonHandler);

		// For layout purposes, put the buttons in a separate panel
		JPanel buttonPanel = new JPanel();

		// ****************************************************
		GridBagLayout gridbag = new GridBagLayout();
		buttonPanel.setLayout(gridbag);
		GridBagConstraints gbc = new GridBagConstraints();

		buttonPanel.add(lblOrderType);
		buttonPanel.add(cmbOrderType);
		buttonPanel.add(lblOrderAmount);
		buttonPanel.add(txtOrderAmount);
		buttonPanel.add(pOrder);
		buttonPanel.add(lblTotal);
		buttonPanel.add(lblTotalValue);
		buttonPanel.add(getTotalButton);
		buttonPanel.add(createOrderButton);
		buttonPanel.add(modifyButton);
		buttonPanel.add(exitButton);
		buttonPanel.add(txtAreaResult);

		gbc.insets.top = 5;
		gbc.insets.bottom = 5;
		gbc.insets.left = 5;
		gbc.insets.right = 5;

		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gridbag.setConstraints(lblOrderType, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gridbag.setConstraints(cmbOrderType, gbc);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gridbag.setConstraints(lblOrderAmount, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gridbag.setConstraints(txtOrderAmount, gbc);

		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gridbag.setConstraints(pOrder, gbc);

		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gridbag.setConstraints(lblTotal, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 4;
		gridbag.setConstraints(lblTotalValue, gbc);

		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets.left = 2;
		gbc.insets.right = 2;
		gbc.insets.top = 40;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gridbag.setConstraints(createOrderButton, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 6;
		gridbag.setConstraints(getTotalButton, gbc);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 1;
		gbc.gridy = 6;
		gridbag.setConstraints(modifyButton, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 2;
		gbc.gridy = 6;
		gridbag.setConstraints(exitButton, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 1;
		gbc.gridy = 7;
		gridbag.setConstraints(txtAreaResult, gbc);

		// ****************************************************

		// Add the buttons and the log to the frame
		Container contentPane = getContentPane();
		contentPane.add(buttonPanel, BorderLayout.CENTER);
		try {
			// UIManager.setLookAndFeel(new WindowsLookAndFeel());
			SwingUtilities.updateComponentTreeUI(OrderManager.this);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new OrderManager();

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// frame.pack();
		frame.setSize(1050, 600);
		frame.setVisible(true);
	}

	public OrderComponent getAllOrders() {
		return allOrders;
	}

	public void displayNewUI(JPanel panel) {
		pOrder.removeAll();
		pOrder.add(panel);
		pOrder.validate();
		validate();
	}

	public OrderVisitor getOrderVisitor() {
		return objVisitor;
	}

	public void displeySearchResults(String txtArea) {
		txtAreaResult.setText(txtArea);
	}

	public void setTotalValue(String msg) {
		lblTotalValue.setText(msg);
	}

	public String getOrderType() {
		return (String) cmbOrderType.getSelectedItem();
	}

	public String getOrderAmount() {
		return txtOrderAmount.getText();
	}

	public JComboBox getOrderTypeCtrl() {
		return cmbOrderType;
	}
} // End of class OrderManager

class ButtonHandler implements ActionListener {
	OrderManager objOrderManager;
	UIBuilder builder;

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(OrderManager.EXIT)) {
			System.exit(1);
		}

		if (e.getSource() == objOrderManager.getOrderTypeCtrl()) {
			String selection = objOrderManager.getOrderType();
			if (selection.equals("") == false) {
				BuilderFactory factory = new BuilderFactory();
				builder = factory.getUIBuilder(selection);
				UIDirector director = new UIDirector(builder);
				director.build();
				JPanel UIObj = builder.getSearchUI();
				objOrderManager.displayNewUI(UIObj);
			}
		}

		if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {
			// get input values
			String orderType = objOrderManager.getOrderType();
			if (orderType.equals("")) {
				JOptionPane.showMessageDialog(objOrderManager, "Select a order type", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				String strOrderAmount = objOrderManager.getOrderAmount();
				String stradditionalTax = builder.getTxtAdditionalTax();

				double dblOrderAmount = 0.0;
				double dblAdditionalTax = 0.0;

				if (strOrderAmount.trim().length() == 0) {
					strOrderAmount = "0.0";
				}
				if (stradditionalTax.trim().length() == 0) {
					stradditionalTax = "0.0";
				}

				dblOrderAmount = new Double(strOrderAmount);
				dblAdditionalTax = new Double(stradditionalTax);

				// Create the order
				OrderComponent order = createOrder(orderType, dblOrderAmount, dblAdditionalTax);

				// Get the Visitor
				OrderComponent allOder = objOrderManager.getAllOrders();

				// accept the visitor instance
				allOder.add(order);
				objOrderManager.setTotalValue(" Order Created Successfully");
			}
		}

		if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
			// Get the Visitor
			OrderVisitor objVisitor = objOrderManager.getOrderVisitor();
			OrderComponent ao = objOrderManager.getAllOrders();

			String text = ao.print();
			Double amountTotal = ao.accept(objVisitor);
			text = text + "\n" + "The total of all orders is:" + amountTotal;

			objOrderManager.displeySearchResults(text);
		}

		if (e.getActionCommand().equals(OrderManager.MODIFY)) {
			OrderComponent allOder = objOrderManager.getAllOrders();
			String query = JOptionPane.showInputDialog(objOrderManager,
					"Enter the order number and the new values (#, amount, additional tax)", "Modify Order");
			String[] queryPart = query.split(",");
			if (allOder.changeOrder(Integer.parseInt(queryPart[0]), new Double(queryPart[1]),
					new Double(queryPart[2]))) {
				JOptionPane.showMessageDialog(objOrderManager, "Order changed successfully");
			} else {
				JOptionPane.showMessageDialog(objOrderManager, "An error occurred when changing the order");
			}

		}
	}

	public OrderComponent createOrder(String orderType, double orderAmount, double additionalTax) {
		if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
			return new CaliforniaOrder(orderAmount, additionalTax);
		}
		if (orderType.equalsIgnoreCase(OrderManager.NON_CA_ORDER)) {
			return new NonCaliforniaOrder(orderAmount);
		}
		if (orderType.equalsIgnoreCase(OrderManager.OVERSEAS_ORDER)) {
			return new OverseasOrder(orderAmount, additionalTax);
		}
		if (orderType.equalsIgnoreCase(OrderManager.COLOMBIAN_ORDER)) {
			return new ColombianOrder(orderAmount, additionalTax);
		}
		return null;
	}

	public ButtonHandler() {
	}

	public ButtonHandler(OrderManager inObjOrderManager) {
		objOrderManager = inObjOrderManager;
	}

} // End of class ButtonHandler

class BuilderFactory {
	public UIBuilder getUIBuilder(String str) {
		UIBuilder builder = null;
		if (str.equals(OrderManager.CA_ORDER)) {
			builder = new CaliforniaOrder();
		} else if (str.equals(OrderManager.NON_CA_ORDER)) {
			builder = new NonCaliforniaOrder();
		} else if (str.equals(OrderManager.OVERSEAS_ORDER)) {
			builder = new OverseasOrder();
		} else if (str.equals(OrderManager.COLOMBIAN_ORDER)) {
			builder = new ColombianOrder();
		}
		return builder;
	}
}