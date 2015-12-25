package edt.textui.section;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.textui.main.EditSection;

import edt.core.*;

/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param section is the current section.
     */
    public SelectSection(Section section) {
        super(MenuEntry.SELECT_SECTION, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form(title());
        InputInteger sectionId = new InputInteger(f,Message.requestSectionId());
        f.parse(); 
        
        Display d = new Display();

        try{ 
            Section s = entity().getSubsections().get(sectionId.value());
            String error = Message.newActiveSection(sectionId.value());
            d.addNewLine(error);
            d.display();

            EditMenu menu = new EditMenu(s);
            menu.open();
        
        }catch(IndexOutOfBoundsException e){
            String error = Message.noSuchSection(sectionId.value());
            d.addNewLine(error);
            d.display();
        }
    }
}
