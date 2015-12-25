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

public class Paragraph extends TextElement implements Serializable {
	private String _text;

	/**
     * Constructor
     * 
     * @param String text is the paragraph text
     * @param Document is the doc where the paragraph belongs
     */
	public Paragraph(String text, Document doc){
		super.setDoc(doc);
		_text = text;
	}

	/**
     * Sets the given text to a paragraph.
     * 
     * @param String usrText is the text to be assigned to a paragraph
     */
	public void setText(String usrText){
		_text = usrText;
	}
	
	/**
     * Get the paragraph content.
     * 
     * @return String with the text assigned to a paragraph
     */
	public String getContent(){
		return _text + "\n";
	}

	/**
     * Get the string size.
     * 
     * @return int is the size of the paragraph
     */
	public int getSize(){
		return _text.length();
	}

	/**
	 * Permits the acess from an visitor to his own elements
	 *
	 * @return String with the visited paragraph
	 */
	public String accept(ContentVisitor visitor){
		return visitor.visit(this);
	}
}