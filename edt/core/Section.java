package edt.core;

import java.util.*;
import java.io.*;

/**
 * Grupo 2
 *
 * @author David Lourenco 77077
 * @author Duarte Clara 76832
 * @author Ruben Martins 79532
 * @version 2.1
 */

public class Section extends TextElement implements Serializable {
	private String _title = "";
	private List<Section> _secSections = new LinkedList<Section>();
	private List<Paragraph> _secParagraphs = new LinkedList<Paragraph>();
	private boolean _edited;

	/**
     * Constructor
	 *
	 * Default constructor
	 *
	 * @param Document is the doc where the section belongs
     */
	public Section(Document doc){
		super.setDoc(doc);
	}

	/**
     * Constructor
	 *
	 * If the section has a title
	 *
	 * @param String title is the section title
	 * @param Document is the doc where the section belongs
     */
	public Section(String title, Document doc){
		super.setDoc(doc);
		_title = title; 
	}

	/**
	 * Gets the identifier and the title from a section
	 *
     * @return String with the identifier and the title, with the spec structure
     */
	public String getHeadline(){
		return ("["+this.getKey()+"] "+ "{"+_title+"}");
	}

	/**
	 * Sets a new title for the section
	 *
     * @param String with the title to be assigned
     */
	public void setTitle(String usrTitle){
		_title = usrTitle;
	}

	/**
	 * Gets the title from the section
	 *
     * @return String with the section title
     */
	public String getTitle(){
		return _title;
	}

	/**
	 * Gets the section size. The section size is the size of
	 * the title, plus the size of the sub-sections and paragraphs
	 * contained by the section
	 *
     * @return int with the section size 
     */
	public int getSize(){ 
		int size = _title.length();

		for (Paragraph p : _secParagraphs){
			size += p.getSize();
		}

		for (Section s : _secSections){
			size += s.getSize();
		}

		return size;
	}

	/**
	 * Signs that document was modified
	 *
	 **/
	public void isEdited(){
		_edited = true;
	}

	/**
	 * Gets the current state of the signal edited variable
	 *
	 * @return boolean true if the document was modified  
	 **/
	public boolean getEdited(){
		return _edited;
	}

	/**
	 * Gets the sub-sections contained by a section
	 *
     * @return List with the sub-sections in a section
     */
	public List<Section> getSubsections(){
		return _secSections;
	}

	/**
	 * Gets a section from a given index
	 *
	 * @param int is the index of the section to be returned
     * @return String with the content of the section in the given index
     */
	public String getSection(int idx){
		ContentVisitor contentVisitor = new ContentVisitor();
		return _secSections.get(idx).accept(contentVisitor);
	}

	/**
	 * Gets the subsections titles from a section
	 *
     * @return String with the subsections from the current section
     */
	public String getSubsectionIndex(){
		String indexs = this.getHeadline()+"\n";
	
		for (Section s : _secSections){
			indexs += s.getSubsectionIndex();
		}
		return indexs;
	}


	/**
	 * Adds a section in the current section in the given index position.
	 * If the index doesn't exists, adds the element in the end.   
	 *
	 * @param int is the position where the subsection will be added
     * @param Section is the subsection to add 
     */
	public void addSection(int idx, Section sec){
		try{
			_secSections.add(idx,sec);
		}catch(IndexOutOfBoundsException e){
			_secSections.add(sec);
		}
		return;
	}

	/**
	 * Removes all the elements unique identifiers from an element.  
	 */
	public void removeIsIndexed(){
		for (Paragraph p : _secParagraphs){
				if (p.isIndexed()){
					super.getDoc().removeFromIndex(p);
				}
		}
		for (Section s : _secSections){
				if (s.isIndexed()){
					super.getDoc().removeFromIndex(s);
				}
				s.removeIsIndexed();
		}
	}
	

	/**
	 * Removes a section from the current document.
	 * If there are no element at the given index, don't do nothing,
	 * If exists, remove them.
	 *
	 * @param int is the position of the section to be removed 
     */
	public void removeSection(int idx){
		try{
			_secSections.get(idx).removeIsIndexed();
			_secSections.remove(idx);
		}catch(IndexOutOfBoundsException e){
			return;
		} 
	}

	/**
	 * Gets a paragraph from a given index
	 *
	 * @param int is the index of the section to be returned 
     * @return Paragraph with the strings it contains
     */
	public Paragraph getParagraph(int idx){
		return _secParagraphs.get(idx);
	}

	/**
	 * Gets all paragraphs contained by a section
	 *
	 * @List contains all the paragraphs from a section
	 */
	public List<Paragraph> getParagraphs(){
		return _secParagraphs;
	}

	/**
	 * Adds a paragraph in the current section in the given index position 
	 * If the index doesn't exists, adds the element in the end.   
	 *
	 * @param int is the position where the paragraph will be added
     * @param Paragraph to be added to the the current section
     */
	public void addParagraph(int idx, Paragraph par){
		try{
			_secParagraphs.add(idx,par);
		}catch(IndexOutOfBoundsException e){
			_secParagraphs.add(par);
		}
	}
	
	/**
	 * Removes a paragraph from the current document
	 *
	 * @param int is the position where the paragraph will be removed
     * @return boolean true if the paragraph in the given position was sucesssefuly removed
     */
	public void removeParagraph(int idx){
			_secParagraphs.remove(idx);
	}

	/**
	 * Permits the acess from an visitor to his own elements
	 *
	 * @return String with the visited section
	 */
	public String accept(ContentVisitor visitor){
		return visitor.visit(this);
	}	
} 