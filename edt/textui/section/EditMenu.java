package edt.textui.section;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import edt.textui.section.*;
import edt.core.*;

/**
 * Represents the edit menu of this application. This menu
 * shows the option to edit the selected section.
 ***/

public class EditMenu extends Menu {
    /**
     * Builds an EditMenu object. It has all available options for editing
     * a section.
     *
     * @param section is the current section.
     **/
    public EditMenu(Section section) {
        super(MenuEntry.TITLE,
        new Command<?>[] { 
        new ChangeTitle(section),
        new ListSections(section),
        new ShowSection(section),
        new SelectSection(section),
        new InsertSection(section),
        new IndexSection(section),
        new RemoveSection(section),
        new InsertParagraph(section),
        new IndexParagraph(section),
        new ChangeParagraph(section),
        new RemoveParagraph(section),
        });
    }
}
