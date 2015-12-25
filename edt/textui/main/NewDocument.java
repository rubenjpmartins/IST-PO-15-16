package edt.textui.main;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.*;

/**
 * Command for creating a new document in the editor.
 */
public class NewDocument extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param manager contains the current document and the related methods.
     */
    public NewDocument(Manager manager) {
        super(MenuEntry.NEW, manager);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        entity().criaDocumento();
    }
}
