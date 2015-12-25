package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import edt.core.*;

/**
 * Command for showing the content of current section.
 */
public class ShowSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param section is the current section.
     */
    public ShowSection(Section section) {
        super(MenuEntry.SHOW_CONTENT, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        ContentVisitor contentVisitor = new ContentVisitor();

        Display d = new Display();
        d.add(entity().accept(contentVisitor));
        d.display();
     }
}