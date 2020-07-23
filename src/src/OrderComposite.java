/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 *
 * @author Julian Sanchez 
 * @author Diego Puin
 */
public class OrderComposite implements Iterator, OrderComponent {
	Vector orderComponents = new Vector();
	Enumeration ec;
	OrderComponent nextCandidate;

	public OrderComposite() {
		ec = orderComponents.elements();
	}

	public void add(OrderComponent oc) {
		orderComponents.add(oc);
	}

	public void remove(OrderComponent oc) {
		orderComponents.remove(oc);
	}

	public OrderComponent getOrder(int location) throws CompositeException {
		return (OrderComponent) orderComponents.elementAt(location);
	};

	public boolean changeOrder(int pos, double newAmount, double newTaxAdditional) {
		try {
			OrderComponent orderAux = getOrder(pos);
			orderAux.setOrderAmount(newAmount);
			orderAux.setAdditionalTax(newTaxAdditional);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public String print() {
		int i = 0;
		Enumeration e = orderComponents.elements();
		String orders = "# --- Order Type --- Order Amount --- Additional Tax";
		while (e.hasMoreElements()) {
			OrderComponent component = (OrderComponent) e.nextElement();
			orders = orders + "\n#" + i + " " + component.print();
			i++;
		}
		return orders;
	}

	public boolean hasNext() {

		nextCandidate = null;

		while (ec.hasMoreElements()) {
			OrderComponent tempObj = (OrderComponent) ec.nextElement();
			nextCandidate = tempObj;
			break;
		}
		return (nextCandidate != null);
	}

	public Object next() {
		if (nextCandidate == null) {
			throw new NoSuchElementException();
		} else {
			return nextCandidate;
		}
	}

	public void remove() {
	};

	public double accept(OrderVisitor v) {

		double sum = 0;

		Enumeration e = orderComponents.elements();
		while (e.hasMoreElements()) {
			OrderComponent component = (OrderComponent) e.nextElement();
			sum = sum + component.accept(v);
		}
		return sum;
	}

	@Override
	public void setOrderAmount(double newAmount) {
	}

	@Override
	public void setAdditionalTax(double newAdditionalTax) {
	}

}