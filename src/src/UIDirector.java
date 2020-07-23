package src;
/**
 *
 * @author Julian Sanchez 
 * @author Diego Puin
 */
public class UIDirector {
	private UIBuilder builder;

	public UIDirector(UIBuilder bldr) {
		builder = bldr;
	}

	public void build() {
		builder.addUIControls();
		builder.initialize();
	}

}