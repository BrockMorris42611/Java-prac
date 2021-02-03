//Thomas tutoring
//
//SERC 358?
//mon: 5-6
//thurs: 2-3
//-----------
//Text Editor|
//-----------
//Part1:
//	>ask user for line of text
//	>If the line begins with an integer, the line will be entered into a linked list in order sorted by the line number used
//		>If there is no number, the first word entered should be interpreted as a command
//			>LIST - this should list the current lines
//			>READ - should read data from a text file
//			>SAVE - should save data to a text file
//			>RESEQUENCE - re-number all the lines starting from 10 and incrementing the line numbers by 10.
//			>EXIT
//			>QUIT - synonyms that cause the program to exit.*/

import java.util.Scanner;
import java.io.*;


public class Editor
{
    public static final String EDITOR = "E:\\2168\\textEditor\\textFile.txt"; // change this to change location for text file
    private CompLL<TextLine> theText;
    private String prompt;
    private enum Keywords {READ, SAVE, LIST, RESEQUENCE, QUIT, EXIT, UNDEFINED;};
    private Scanner console;

    public Editor()
    {
        this.theText = new CompLL<TextLine>();
        this.prompt = ">";
        this.console = new Scanner(System.in);
    }

    public String getPrompt()
    {
        return prompt;
    }


    public void setPrompt(String p)
    {
        this.prompt = p;
    }

    private static boolean isInt(String s) // see if a string represents
    { 									   // an integer.
        boolean retval = false;
        try
        {
            Integer.parseInt(s);
            retval = true;
        }
        catch (NumberFormatException e)
        {
            retval = false;
        }
        return retval;
    }

    public void process() throws FileNotFoundException
    {

        boolean done = false;
        boolean alExist = false;
        String line;
        while (!done)
        {
            System.out.print(this.prompt);
            line = console.nextLine().toUpperCase(); // Work only with upper case
            String splitString[] = line.split(" ", 2);
            // at this point, the line that was read in has been split into two
            // arrays. splitString[0] contains the first token, splitString[1]
            // contains all the rest of the line.

            //At this point, you need to decide whether this is a command or
            //a line of text to be entered.
            if (this.isInt(splitString[0]))
            {
                // Here we have a line of text to be entered. Write the code to
                //insert it into the LLComp named theText.
                TextLine lineToBeInserted = new TextLine(line);
                /*for (int i = 0; i < theText.size(); i++) {
                    if(lineToBeInserted.lineNum == theText.getAtInd(i).lineNum && lineToBeInserted.text == null){
                        theText.remove(theText.getAtInd(i));
                    }
                    else if(lineToBeInserted.lineNum == theText.getAtInd(i).lineNum){
                            theText.getAtInd(i).text = lineToBeInserted.text;
                        }
                }*/
                for (int i = 0; i < theText.size(); i++) {
                    if(lineToBeInserted.lineNum == theText.getAtInd(i).lineNum){
                        theText.getAtInd(i).text = lineToBeInserted.text;
                    }
                }
                System.out.println(lineToBeInserted);
                theText.insertInOrder(lineToBeInserted);
                for(int i = 0; i < theText.size(); i++){
                    System.out.print("IN LIST: " + theText.getAtInd(i));
                }
            }
            else //otherwise, it is a command, so call doCommand to perform it.
                done = this.doCommand(splitString[0]);
        }
    }

    private boolean doCommand(String com) throws FileNotFoundException
    {
        boolean retval = false;
        Keywords command;
        //This first bit takes the string in the first word of the line
        //and turns it into one of the manifest constants of the
        //enumerated data type. This makes it fairly easy to add new
        //commands later.
        try
        {
            command = Keywords.valueOf(com);// command is a Keywords and can
        } // can be used as the target of a switch.
        catch (IllegalArgumentException e)
        {
            command = Keywords.UNDEFINED; //An undefined Keywords will cause
        } //an exception.
        switch (command)
        {
            case READ: this.read();
                break;
            case SAVE: this.save();
                break;
            case LIST: this.list();
                break;
            case RESEQUENCE: this.resequence();
                break;
            case QUIT:
            case EXIT: retval = true;
                break;
            case UNDEFINED: System.out.println("Undefined command:" + com);
        }
        return retval;
    }

	 /*You need to implement the following routines.
	>LIST - this should list the current lines
	>READ - should read data from a text file
	>SAVE - should save data to a text file
	>RESEQUENCE - re-number all the lines starting from 10 and incrementing the line numbers by 10.
	>EXIT
	>QUIT - synonyms that cause the program to exit.*/

    private void read()throws FileNotFoundException
    {
        try {
            String line;
            Scanner file = new Scanner(new File(EDITOR));
            while(file.hasNextLine()) {
                line = file.nextLine();
                System.out.println(line);
            }
        }catch(Exception e) {
            System.out.println("\nThere was a problem with the file. It could possibly not exist or jsut a bad root directory. please fix and try again");
        }
    }

    private void save()
    {
        PrintWriter pw = null;
        String save = "";
        for(int i = 0; i < theText.size(); i++){
            save += theText.getAtInd(i);
        }
        try {
            for(int i = 0; i < theText.size(); i++) {
                pw = new PrintWriter(new FileWriter(new File(EDITOR)));
                pw.print(save);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("Error writing to file:  " + EDITOR);
        } finally {
            if(pw!=null) {
                pw.close();
            }
        }
    }

    private void list()
    {
        System.out.println(theText.toString());
    }

    private void resequence() {
        for (int i = 0; i < theText.size(); i++) {
            theText.getAtInd(i).lineNum = (i + 1) * 10;
            System.out.println(theText.getAtInd(i).lineNum);
        }
    }
    public static void main(String args[]) throws FileNotFoundException
    {
        Editor e = new Editor();
        e.process();
    }
}