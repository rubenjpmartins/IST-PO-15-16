package edt.textui.main;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import edt.textui.section.EditMenu;

import edt.core.*;

/**
 * Command for editing the current document in the editor.
 */
public class EditSection extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param manager contains the current document and the related methods.
     */
    public EditSection(Manager manager) {
        super(MenuEntry.OPEN_DOCUMENT_EDITOR, manager);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        EditMenu menu = new EditMenu(entity().getDocument());
        menu.open();
    }
}

