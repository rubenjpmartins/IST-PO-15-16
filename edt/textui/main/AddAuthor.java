package edt.textui.main;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import edt.core.*;

/**
 * Command for adding an author to the current document in the editor.
 */
public class AddAuthor extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param manager contains the current document and the related methods.
     */
    public AddAuthor(Manager manager) {
        super(MenuEntry.ADD_AUTHOR, manager);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
      Form name = new Form(title());
      InputString authorName = new InputString(name, Message.requestAuthorName());
      name.parse();

        if(entity().getDocument().getAuthors().containsKey(authorName.value())){
          String erro = Message.duplicateAuthor(authorName.value());
          Display d = new Display(title());
          d.addNewLine(erro);
          d.display();
            }
        else{
          Form email = new Form(title());
          InputString authorEmail = new InputString(email, Message.requestEmail());
          email.parse();
          entity().getDocument().addAuthor(authorName.value(),authorEmail.value());
          
          entity().getDocument().isEdited();
        }
      
    }
}
