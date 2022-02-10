package pyke.ui;
import java.util.Scanner;

public class Ui {
    private static final String GREETINGS = "Hello! I'm Pyke\n" + "What can I do for you?";
    private static final String FAREWELL = "Bye. Hope to see you again soon!";
    private Scanner scanner;
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Convert the plain output text to chat-box style with indentation for output
     *
     * @param text : String (output text)
     * @return chat-box style output text : String
     */
    private String convertToChatBox(String text) {
        /*
        return "    ____________________________________________________________\n"
                + text.replaceAll("(?m)^", "     ") + "\n"
                + "    ____________________________________________________________\n";

         */
        return text;
    }

    /**
     * read a line of String from users' input
     *
     * @return the command in String
     */
    public String getCommand() {
        return scanner.nextLine();
    }

    /**
     * The duke logo
     */
    public void showLogo() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(convertToChatBox(logo));
    }
    public void sayGreeting() {
        System.out.println(convertToChatBox(GREETINGS));
    }
    public void sayFarewell() {
        System.out.println(convertToChatBox(FAREWELL));
    }

    /**
     * Output text in a chat-box style
     *
     * @param text the original text for output
     */
    public void outputText(String text) {
        System.out.println(convertToChatBox(text));
    }

    /**
     * Output exception information in a chat-box style
     *
     * @param exceptionInfo the original info about exceptions
     */
    public void outputException(String exceptionInfo) {
        System.out.println(convertToChatBox(exceptionInfo));
    }

    public String outputUiText(String text) {
        return text;
    }

    public String outputUiGreeting() {
        return GREETINGS;
    }

    public String outputUiFarewell() {
        return FAREWELL;
    }
}
