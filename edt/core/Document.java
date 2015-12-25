package edt.core;

import java.io.*;
import java.util.*;

/**
 * Grupo 2
 *
 * @author David Lourenco 77077
 * @author Duarte Clara 76832
 * @author Ruben Martins 79532
 * @version 2.1
 */

public class Document extends Section implements Serializable {
	private String _filename = "";
	private Map<String,Author> _authors = new TreeMap<String,Author>();
	private Map<String,TextElement> _textElements = new HashMap<String,TextElement>();

	/**
     * Constructor
     *
     * Default constructor
     */
	public Document(){
		super(null);
		setDoc(this);
	}

	/**
     * Constructor 
     * 
     * If the document already has a filename when loaded
     *
     * @param String filename is the name of the file
     * @return Document is the document with the associated filename 
     */
	public Document(String filename){
		super(null);
		_filename = filename;
		setDoc(this);
	}

	/**
	 * Adds an Author to a document from parsing, receiving the element
	 *
     * @param Author au is the Author to be added to the document
     */
	public void addAuthor(Author au){
		_authors.put(au.getName(),au);
	}

	/**
	 * Adds an Author to a document from the interface
	 *
	 * @name String is the author name
	 * @mail String is the author email
	 */
	public void addAuthor(String name, String email){
		Author au = new Author(name, email);
		_authors.put(au.getName(),au);
	}

	/**
	 * Gets the authors from a document
	 *
     * @return Map is struct that contains the document authors 
     */
	public Map<String,Author> getAuthors(){
		return _authors;
	}

	/**
	 * Gets all text elements from a document
	 *
	 * @return Map is a struct that contains the text elements from a document
     */
	public Map<String,TextElement> getTextElements(){
		return _textElements;
	}

	/**
	 * Gets a specific text element from the document
	 *
	 * @param String is the identifier from text element
     * @return TextElement specified by the identifier
     */
	public TextElement getTextElement(String id){
		return _textElements.get(id);
	}

	/**
	 * Index the given ele to the text elements struct 
	 *
     * @param String is the identifier of the element
     * @param TextElement to be assigned 
     */
	public void indexElement(String id, TextElement ele){
		TextElement element;
		ele.setKey(id);
		
		if ((element = _textElements.put(id,ele)) != null){
			element.clearKey();
		}
		return;
	}

	/**
	 * Get the document title 
	 *
     * @return String with the title
     */
	public String getHeadline(){
		return ("{" + getTitle() + "}");
	}

	/**
	 * Sets the document filename 
	 *
     * @param String is the filename to be assigned to the document
     */
	public void setFilename(String filename){
		_filename = filename;
	}

	/**
	 * Gets the filename from a document
	 * 
     * @return String with the filename 
     */
	public String getFilename(){
		return _filename;
	}

	/**
	 * Removes the given text element from the struct 
	 *
     * @param TextElement ele is the element to be removed
     */
	public void removeFromIndex(TextElement ele){
		_textElements.remove(ele.getKey());

		return;
	}
}