package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.Display;

import edt.core.*;

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param section is the current section.
     */
    public RemoveSection(Section section) {
        super(MenuEntry.REMOVE_SECTION, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form id = new Form(title());
        InputInteger sectionId = new InputInteger(id,Message.requestSectionId());
        id.parse();

        try {
        	Section s = entity().getSubsections().get(sectionId.value());

       		if (s.isIndexed()){
                entity().getDoc().removeFromIndex(s);
        	} 
        	entity().removeSection(sectionId.value());            
        	entity().isEdited();
        }catch(IndexOutOfBoundsException i){

        }

    }
}
