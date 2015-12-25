package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

import pt.utl.ist.po.ui.Display;

import edt.core.*;

/**
 * Command for adding a subsection to current section.
 */
public class InsertSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param section is the current section.
     */
    public InsertSection(Section section) {
        super(MenuEntry.INSERT_SECTION, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Form reqId = new Form(title());
        InputInteger secId = new InputInteger(reqId,Message.requestSectionId());
        reqId.parse();

        Form reqTitle = new Form(title());
        InputString secTitle = new InputString(reqTitle,Message.requestSectionTitle());
        reqTitle.parse();

        Section s = new Section(secTitle.value(),entity().getDoc());
        s.setDoc(entity().getDoc());
        
        entity().addSection(secId.value(),s);
        entity().isEdited();
    }
}
