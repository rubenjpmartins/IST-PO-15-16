package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.*;


/**
 * Command for indexing ia subsection the current section .
 */
public class IndexSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param section is the current section.
     */
    public IndexSection(Section section) {
        super(MenuEntry.NAME_SECTION, section);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form secId = new Form(title());
        InputInteger sectionId = new InputInteger(secId,Message.requestSectionId());
        secId.parse();

        Form uniqId = new Form(title());
        InputString uniqueId = new InputString(uniqId,Message.requestUniqueId());
        uniqId.parse();
        
        Display d = new Display();

        try{ 
            Section s = entity().getSubsections().get(sectionId.value());
    
            if (s.isIndexed()){
                entity().getDoc().removeFromIndex(s);
                d.addNewLine(Message.sectionNameChanged());
            }
            entity().getDoc().indexElement(uniqueId.value(),s);
            s.setKey(uniqueId.value());
        
        }catch(IndexOutOfBoundsException e){
            String erro = Message.noSuchSection(sectionId.value());
            d.addNewLine(erro);
        }
        d.display();
    }
}
