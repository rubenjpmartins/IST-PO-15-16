package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

import edt.core.*;

/**
 * Command for indexing a paragraph (nomear um parágrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param section is the current section.
     */
    public IndexParagraph(Section section) {
        super(MenuEntry.NAME_PARAGRAPH, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form parId = new Form(title());
        InputInteger paragraphId = new InputInteger(parId,Message.requestParagraphId());
        parId.parse();

        Display d = new Display();

        try{ 
            Paragraph p = entity().getParagraph(paragraphId.value());

            Form uniqId = new Form(title());
            InputString uniqueId = new InputString(uniqId,Message.requestUniqueId());
            uniqId.parse();

            if (p.isIndexed()){
                entity().getDoc().removeFromIndex(p);
                d.addNewLine(Message.paragraphNameChanged());
            }
            entity().getDoc().indexElement(uniqueId.value(),p);
            p.setKey(uniqueId.value());
            
        }catch(IndexOutOfBoundsException e){
            String erro = Message.noSuchParagraph(paragraphId.value());
            d.addNewLine(erro);
        }
        d.display();
    }
}
