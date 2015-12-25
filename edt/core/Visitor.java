package edt.core;

/**
 * Grupo 2
 *
 * @author David Lourenco 77077
 * @author Duarte Clara 76832
 * @author Ruben Martins 79532
 * @version 1.1
 */

/*
 * Defines the concrete elements to be visited.
 */
public interface Visitor {
	public abstract String visit(Section sec);
	public abstract String visit(Paragraph par);	
}