package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import java.util.*;

import edt.core.*;

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param section is the current section.
     */
    public ListSections(Section section) {
        super(MenuEntry.LIST_SECTIONS, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Display d = new Display();
        List<Section> sec = entity().getSubsections();
        
        for (Section s : sec){
            d.add(s.getSubsectionIndex());
        }
        d.display();
    }
}
