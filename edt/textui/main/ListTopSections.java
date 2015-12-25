package edt.textui.main;

import java.util.*;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import edt.core.*;

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param manager contains the current document and the related methods.
     */
    public ListTopSections(Manager manager) {
        super(MenuEntry.SHOW_INDEX, manager);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        
        List<Section> topSections = entity().getDocument().getSubsections();

        Display d = new Display();
        d.addNewLine("{"+entity().getDocument().getTitle()+"}");

        for (Section section : topSections){
            d.addNewLine(Message.sectionIndexEntry(section.getKey(),section.getTitle()));
        }
        
        d.display();
    }
}
