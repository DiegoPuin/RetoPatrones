package src;
import javax.swing.*;
/**
 *
 * @author Julian Sanchez 
 * @author Diego Puin
 */
public abstract class UIBuilder {

	protected JPanel orderUI;

	public abstract void addUIControls();

	public abstract void initialize();

	public abstract String getTxtAdditionalTax();

	public JPanel getSearchUI() {
		return orderUI;
	}
}
