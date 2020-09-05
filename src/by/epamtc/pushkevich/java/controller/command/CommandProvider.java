package by.epamtc.pushkevich.java.controller.command;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<RequestCommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(RequestCommandName.GET_ALL_SENTENCES, new AllSentencesCommand());
        commands.put(RequestCommandName.GET_ALL_WORDS, new AllWordsCommand());
        commands.put(RequestCommandName.GET_WORDS_FROM_INTERROGATIVE_SENTENCES, new WordsFromInterrogativeSentenceCommand());
        commands.put(RequestCommandName.GET_REVERSED_ORDER_SENTENCES, new ReversedOrderSentencesCommand());
    }

    public Command getCommand(String commandName){
        Command command;
        RequestCommandName value;

        commandName = commandName.toUpperCase();
        value = RequestCommandName.valueOf(commandName);

        command = commands.get(value);

        return command;
    }
}
