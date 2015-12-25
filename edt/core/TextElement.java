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

public abstract class TextElement implements Serializable {
	private String _key = "";
	private Document _document;


	public abstract int getSize();
	public abstract String accept(ContentVisitor contentVisitor);

	/**
	 * Assigns an empty string to the key
	 *
     */
	public void clearKey(){
		_key = "";
	}

	/**
     * Gets the element unique identifier 
     *
     * @return String is the element identifier
     */
	public String getKey(){
		return _key;
	}

	/**
     * Sets a key for the element 
     *
     * @param String is the new unique identifier to be assigned
     */
	public void setKey(String usrKey){
		_key = usrKey;
	}

	/**
	 * Sets the document current state
	 *
	 * @param Document is the doc to be assigned as current
	 */
	public void setDoc(Document doc){
		_document = doc;
	}

	/**
	 * Gets the current document state
	 *
	 * @return Document is the current document
	 */
	public Document getDoc(){
		return _document;
	}

	/**
	 * Shows if an element has identifier 
	 *
     * @return boolean with true if the element currently has an identifier
     */
	public boolean isIndexed(){
		return !_key.equals("");
	}
}