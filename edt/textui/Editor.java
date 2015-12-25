package edt.textui;

import java.io.*;

import edt.textui.main.MainMenu;
import edt.core.*;
import edt.parser.Parser;

import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
 * The main class of the edt application.
 **/

public class Editor {

  public static void main(String[] args) throws FileNotFoundException,IOException{
    String fileToImport = System.getProperty("import");
    Manager manager = new Manager();
    Parser parser = new Parser();
    if(fileToImport!=(null)){ 
    	manager.setDocument(parser.parse(fileToImport));
        manager.isNew();
        manager.getDocument().setDoc(manager.getDocument());
    }

    MainMenu menu = new MainMenu(manager);
    menu.open();
    IO.close();
  }
}
