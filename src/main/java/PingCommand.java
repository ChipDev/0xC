import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by blake on 6/6/17.
 */
public class PingCommand implements GenericCommand {

    @EventSubscriber
    public void messageRecieved(MessageReceivedEvent event){
        if(event.getMessage().toString().toLowerCase().split(" ")[0].equalsIgnoreCase("?ping")) {
            event.getChannel().sendMessage("https://www.justshopok.com/images/uploads/product_images/82671404554517.jpg");
        }
    }


    public String getName() {
        return "ping";
    }

    public String getDescription() {
        return "What did you expect? Obviously a picture of one of the items from the great golf brand, Ping.";
    }
}
