package edt.core;

import java.io.*;

/**
 * Grupo 2
 *
 * @author David Lourenco 77077
 * @author Duarte Clara 76832
 * @author Ruben Martins 79532
 * @version 2.1
 */

public class Author implements Serializable {
	private String _name;
	private String _email;

	/**
     * Constructor
	 *
	 * @param name is the author's name
	 * @param email is the author's email
	 **/
	public Author(String name, String email){
		_name = name;
		_email = email;
	}

	/**
	 * Gets the author name 
	 *
     * @return String with the author's name
     */
	public String getName(){
		return _name;
	}

	/**
	 * Gets the author email
	 * 
     * @return String with the author's email
     */
	public String getEmail(){
		return _email;
	}
}