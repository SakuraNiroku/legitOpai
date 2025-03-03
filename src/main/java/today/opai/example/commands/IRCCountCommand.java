package today.opai.example.commands;

import today.opai.api.features.ExtensionCommand;
import today.opai.example.ExampleExtension;

public class IRCCountCommand extends ExtensionCommand {
    public IRCCountCommand() {
        super(new String[]{"irc"}, "Show irc online", ".irc");
    }
    @Override
    public void onExecute(String[] strings) {
        ExampleExtension.openAPI.printMessage("Now irc online: "+ExampleExtension.openAPI.getIRC().getOnlineUserCount());
    }
}
