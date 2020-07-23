package src;
/**
 *
 * @author Julian Sanchez 
 * @author Diego Puin
 */
class OrderVisitor implements VisitorInterface {

	public double visit(NonCaliforniaOrder inp_order) {
		return inp_order.getOrderAmount();
	}

	public double visit(CaliforniaOrder inp_order) {
		return inp_order.getOrderAmount() + inp_order.getAdditionalTax();
	}

	public double visit(OverseasOrder inp_order) {
		return inp_order.getOrderAmount() + inp_order.getAdditionalSH();
	}

	public double visit(ColombianOrder inp_order) {
		return inp_order.getOrderAmount() + inp_order.getAdditionalSH();
	}

}