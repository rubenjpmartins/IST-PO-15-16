package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import edt.core.*;
import java.util.*;

/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param manager contains the current document and the related methods.
     */
    public ShowMetadata(Manager manager) {
        super(MenuEntry.SHOW_METADATA, manager);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Map<String,Author> au = entity().getDocument().getAuthors();
        int count = entity().getDocument().getSize();

        Display d = new Display();
        
        /* Titulo */
        d.addNewLine(Message.documentTitle(entity().getDocument().getTitle()));
        
        /* Autores */
        for (Author author : au.values()){
            d.addNewLine(Message.author(author.getName(),author.getEmail()));
        }
        
        /* Seccoes de topo */
        try{
            d.addNewLine(Message.documentSections(entity().getDocument().getSubsections().size()));
        }catch(NullPointerException e){
            d.addNewLine(Message.documentSections(0));
        }

        /* Dimensao do documento */
        d.addNewLine(Message.documentBytes(count));
        
        /* Identificadores unicos */
        try{
            d.addNewLine(Message.documentIdentifiers(entity().getDocument().getTextElements().size()));
        }
        catch(NullPointerException e){
            d.addNewLine(Message.documentIdentifiers(0));
        }
        d.display();
    }
}

