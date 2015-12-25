package edt.textui.main;

import java.io.IOException;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import java.io.*;

import edt.core.*;

/**
 * Command for opening an existing document in the editor.
 */
public class OpenDocument extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param manager contains the current document and the related methods.
     */
    public OpenDocument(Manager manager) {
        super(MenuEntry.OPEN, manager);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {

        Form f = new Form(title());
        InputString filename = new InputString(f, Message.openFile());
        f.parse();

        Display d = new Display(title());

        try{
            entity().loadDocument(filename.value());
        }catch(FileNotFoundException|ClassNotFoundException e){
            String error = Message.fileNotFound();
            d.addNewLine(error);
            d.display();
        }catch(IOException ex){
          String error = Message.fileNotFound();
          d.addNewLine(error);
          d.display();
        }
        
    }
}
