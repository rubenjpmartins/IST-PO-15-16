package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import edt.core.*;

/**
 * Command for changing the title of the current section.
 */
public class ChangeTitle extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param section is the current section.
     */
    public ChangeTitle(Section section) {
        super(MenuEntry.CHANGE_TITLE, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form(title());
        InputString newTitle = new InputString(f,Message.requestSectionTitle());
        f.parse();

        entity().setTitle(newTitle.value());
        entity().isEdited();
    }
}
