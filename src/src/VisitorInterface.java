package src;
/**
 *
 * @author Julian Sanchez 
 * @author Diego Puin
 */
public interface VisitorInterface {
	public double visit(NonCaliforniaOrder nco);

	public double visit(CaliforniaOrder co);

	public double visit(OverseasOrder oo);

	public double visit(ColombianOrder colo);
}