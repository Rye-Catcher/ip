package pyke.util;

import pyke.command.*;
import pyke.exception.InvalidCommandException;


public class Parser {
    private static Command dispatchCommand(String command, String[] tokenList) throws InvalidCommandException {
        switch (tokenList[0]) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(true, Integer.parseInt(tokenList[1]));
        case "unmark":
            return new MarkCommand(false, Integer.parseInt(tokenList[1]));
        case "delete":
            return new DelCommand(Integer.parseInt(tokenList[1]));
        case "todo":
            return new AddTodoCommand(command.substring(5));
        case "help":
            return new HelpCommand();
        case "deadline":
            return new AddDeadlineCommand(
                    command.substring(9).split("/")[0],
                    command.substring(9).split("/")[1].substring(3));
        case "event":
            return new AddEventCommand(
                    command.substring(6).split("/")[0],
                    command.substring(6).split("/")[1].substring(3));
        case "find":
            return new FindCommand(tokenList[1]);
        default:
            throw new InvalidCommandException();
        }
    }
    /**
     * Parse the commands into a string of tokens.
     * Then dispatch the commands according to the first word
     *
     * @param command inputed by the user
     * @return the dispatched command
     * @throws InvalidCommandException if the command cannot be recognized
     */
    public Command parseCommand(String command) throws InvalidCommandException {
        String[] tokenList = command.split(" ");
        if (tokenList.length == 1) {
            //bye | list
        } else if (tokenList.length == 2) {
            //mark | unmark | delete
        } else if (tokenList.length > 2) {
            //todo | deadline | event
        }

        return dispatchCommand(command, tokenList);
    }
}
