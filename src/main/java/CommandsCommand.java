import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by blake on 6/7/17.
 */
public class CommandsCommand implements GenericCommand {

    @EventSubscriber
    public void messageRecieved(MessageReceivedEvent event) {

        String cmdstr = "";

        for(int i = 0; i < Main.genericCommandList.size() - 1; i++){
            cmdstr+="     ?" + Main.genericCommandList.get(i).getName() + "['" + Main.genericCommandList.get(i).getDescription() + "'];\n";
        }

        if(event.getMessage().toString().toLowerCase().split(" ")[0].equalsIgnoreCase("?commands")) {
            event.getChannel().sendMessage("```C\n" +
                    "int commands(Lists all, commands_for 0xC) {\n" +
                    "\n" +
                    cmdstr +
                    "\n" +
                    "}\n" +
                    "```");
        }
    }

    public String getName() {
        return "commands";
    }

    public String getDescription() {
        return "Lists all commands bundled with 0xC.";
    }



}