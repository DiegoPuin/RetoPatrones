/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
/**
 *
 * @author Julian Sanchez 
 * @author Diego Puin
 */
public interface OrderComponent {

	public void add(OrderComponent menuComponent);

	public void remove(OrderComponent menuComponent);

	public OrderComponent getOrder(int componentNum) throws CompositeException;

	public String print();

	public double accept(OrderVisitor v);

	public boolean hasNext();

	public Object next();

	public void setOrderAmount(double newAmount);

	public void setAdditionalTax(double newAdditionalTax);

	public boolean changeOrder(int pos, double newAmount, double newTaxAdditional);
}
