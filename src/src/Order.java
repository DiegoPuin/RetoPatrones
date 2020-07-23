/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julian Sanchez 
 * @author Diego Puin
 */
public class Order extends UIBuilder implements OrderComponent {

	private double orderAmount;

	public Order() {
	}

	public Order(double price) {
		this.orderAmount = price;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public String print() {
		return " " + getOrderAmount();
	}

	@Override
	public void add(OrderComponent menuComponent) {
            throw new UnsupportedOperationException();
        }

	@Override
	public void remove(OrderComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public OrderComponent getOrder(int componentNum) throws CompositeException {
		throw new CompositeException("Invalid Operation. Not Supported");
	}

	@Override
	public double accept(OrderVisitor v) {
		throw new UnsupportedOperationException();
	}

	public boolean hasNext() {
		throw new UnsupportedOperationException();
	}

	public Object next() {
		throw new UnsupportedOperationException();
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Override
	public void addUIControls() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public void initialize() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public String getTxtAdditionalTax() {
		return "";
	}

	@Override
	public void setAdditionalTax(double newAdditionalTax) {
	}

	@Override
	public boolean changeOrder(int pos, double newAmount, double newTaxAdditional) {
		return false;
	}

}