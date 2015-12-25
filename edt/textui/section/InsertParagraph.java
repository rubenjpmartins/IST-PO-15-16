package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.*;

/**
 * Command for adding a paragraph to the current section.
 */
public class InsertParagraph extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param section is the current section.
     */
    public InsertParagraph(Section section) {
        super(MenuEntry.INSERT_PARAGRAPH, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form id = new Form(title());
        InputInteger paragraphId = new InputInteger(id,Message.requestParagraphId());
        id.parse(); 

        Form content = new Form(title());
        InputString paragraphContent = new InputString(content,Message.requestParagraphContent());
        content.parse();

        Paragraph p = new Paragraph(paragraphContent.value(),entity().getDoc());
        p.setDoc(entity().getDoc());
        
        entity().addParagraph(paragraphId.value(),p);
        entity().isEdited();
    }
}
