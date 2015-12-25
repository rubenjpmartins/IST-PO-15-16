package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.Display;

import java.io.IOException;

import edt.core.*;

/**
 * Command for saving the current document in the editor.
 */
public class SaveDocument extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param manager contains the current document and the related methods.
     */
    public SaveDocument(Manager manager) {
        super(MenuEntry.SAVE, manager);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
    
        if(entity().getFilename().equals("")|| entity().getFilename() == null || entity().getIsNew()) {
            Form f = new Form(title());
            InputString filename = new InputString(f,Message.newSaveAs());
            f.parse();
            entity().setFilename(filename.value());
            entity().saveDocument(filename.value());
        }      
        else{
            if (entity().getDocument().getEdited()){
                entity().saveDocument(entity().getFilename());
            }
        }
    }
}

