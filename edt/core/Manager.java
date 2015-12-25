package edt.core;

import pt.utl.ist.po.ui.InvalidOperation;
import java.io.*;

/**
 * Grupo 2
 *
 * @author David Lourenco 77077
 * @author Duarte Clara 76832
 * @author Ruben Martins 79532
 * @version 2.1
 */

public class Manager implements Serializable {
	private Document _curDocument;
	private boolean _new;

	/**
     * Constructor
     * 
     */
	public Manager(){
		_curDocument = new Document();
	}

	/**
     *  Creates a new empty document
     */
	public void criaDocumento(){
		_curDocument = new Document();
	}

	/**
	 * Load one previous document state that was stored in a file
	 *
	 * @param filename is the name of the serialized file
	 *
	 * @throws IOException if some error happens during reading from file
	 **/
	public void loadDocument(String filename) throws FileNotFoundException, ClassNotFoundException, IOException{

			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
	  		_curDocument = (Document)in.readObject();
	  		in.close();
	}

	/**
	 * Saves the current document
	 *
	 * @param String is the filename for the document to be saved
	 *
	 * @throws IOException if some error happens during reading from file
	 **/
	public void saveDocument(String filename){
		try{
	  		ObjectOutputStream out =
	  		new ObjectOutputStream(new FileOutputStream(filename));
	  
	  		out.writeObject(_curDocument);
	  		out.flush();
	  		out.close();
	  	}catch(IOException e) {
	  		System.out.println("Erro (IO):"+filename+":"+e);
	  	}
	}

	/**
	 * Gets the document filename
	 *
	 * @return String with the name of the file
	 **/
	public String getFilename(){
		return _curDocument.getFilename();
	}

	/**
	 * Sets a new filename
	 *
	 * @param String with the new name for the file
	 **/
	public void setFilename(String filename){
		_curDocument.setFilename(filename);	
	}	

	/**
	 * Sets the current document state
	 *
	 * @param Document to be managed
	 **/
	public void setDocument(Document document){
		_curDocument = document;
	}

	/**
	 * Gets the current document
	 *
	 * @return Document is the current document in manager
	 **/
	public Document getDocument(){
		return _curDocument;
	}

	/**
	 * Signs that document was loaded and doesn't have a filename
	 *
	 **/
	public void isNew(){
		_new = true;
	}

	/**
	 * Return a variable in order to know if an imported file wasn't saved yet
	 *
	 * @return boolean true if the loaded document doesn't have a filename
	 **/
	public boolean getIsNew(){
		return _new;
	}
}