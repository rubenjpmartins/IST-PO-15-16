package edt.core;

/**
 * Grupo 2
 *
 * @author David Lourenco 77077
 * @author Duarte Clara 76832
 * @author Ruben Martins 79532
 * @version 1.1
 */

public class ContentVisitor implements Visitor {

	/**
	 * Gets the section content. The section content is the content of
	 * the title, plus the content of the sub-sections and paragraphs
	 * contained by the section. 
	 * From an given section, visits all the elements it contains.
     * @return String with the visited sections and paragraphs
     */
	public String visit(Section sec){
		String content = sec.getHeadline() + "\n";

		for (Paragraph p : sec.getParagraphs()){
			content += visit(p);
		} 

		for (Section s : sec.getSubsections()){
			content += visit(s);
		}

		return content;
	}

	/**
     * Get the paragraph content.
     * 
     * @return String with the text assigned to a paragraph
     */
	public String visit(Paragraph par){
		return par.getContent();
	}
}