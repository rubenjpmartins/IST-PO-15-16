package edt.textui.main;

import edt.core.*;
import edt.parser.Parser;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/**
 * Represents the main menu of this application. This is the first menu
 * shown to the users.
 ***/

public class MainMenu extends Menu {

  public MainMenu(Manager manager) {
    super(MenuEntry.TITLE, new Command<?>[] {
      new NewDocument(manager),
      new OpenDocument(manager),
      new SaveDocument(manager),
      new ShowMetadata(manager),
      new AddAuthor(manager),
      new ListTopSections(manager),
      new ShowTextElement(manager),
      new EditSection(manager),
    });
  }
 } 

