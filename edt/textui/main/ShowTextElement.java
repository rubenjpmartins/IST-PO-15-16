package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import edt.core.*;

/**
 * Command for showing the text element with a given identifier of the current document in the editor.
 */
public class ShowTextElement extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param manager contains the current document and the related methods.
     */
    public ShowTextElement(Manager manager) {
        super(MenuEntry.SHOW_TEXT_ELEMENT, manager);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form(title());
        InputString textElement = new InputString(f,Message.requestElementId());
        f.parse();

        ContentVisitor contentVisitor = new ContentVisitor();
        Display d = new Display();
        if (entity().getDocument().getTextElement(textElement.value()) != null){
            d.addNewLine(entity().getDocument().getTextElement(textElement.value()).accept(contentVisitor));            
        }
        else{
            String error = Message.noSuchTextElement(textElement.value());
            d.addNewLine(error);
        }
        d.display();
    }
}
