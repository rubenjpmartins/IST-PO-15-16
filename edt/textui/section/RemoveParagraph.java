package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.*;

/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveParagraph(Section section) {
        super(MenuEntry.REMOVE_PARAGRAPH, section);
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

        try{
            Paragraph p = entity().getParagraph(paragraphId.value());
            
            if (p.isIndexed()){
                entity().getDoc().removeFromIndex(p);
            }
            entity().removeParagraph(paragraphId.value());
            entity().isEdited();
        }catch(IndexOutOfBoundsException e){
            Display d = new Display(title());
            String error = Message.noSuchParagraph(paragraphId.value());
            d.addNewLine(error);
            d.display();
        }
    }
}
