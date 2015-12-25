package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

import edt.core.*;

/**
 * Command for changing the content of a paragraph of the current section.
 */
public class ChangeParagraph extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param section is the current section.
     */
    public ChangeParagraph(Section section) {
        super(MenuEntry.EDIT_PARAGRAPH, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form parId = new Form(title());
        InputInteger paragraphId = new InputInteger(parId,Message.requestParagraphId());
        parId.parse();

        Form content = new Form(title());
        InputString paragraphContent = new InputString(content,Message.requestParagraphContent());
        content.parse();

        try{
            entity().getParagraph(paragraphId.value()).setText(paragraphContent.value());
            entity().isEdited();
        }catch(IndexOutOfBoundsException e){
        Display d = new Display(title());
        String error = Message.noSuchParagraph(paragraphId.value());
        d.addNewLine(error);
        d.display();
        }
    }
}
