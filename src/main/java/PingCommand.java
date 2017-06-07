import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by blake on 6/6/17.
 */
public class PingCommand {

    @EventSubscriber
    public void messageRecieved(MessageReceivedEvent event){
        if(event.getMessage().toString().toLowerCase().split(" ")[0].equalsIgnoreCase("?ping")) {
            event.getChannel().sendMessage("https://www.justshopok.com/images/uploads/product_images/82671404554517.jpg");
        }
    }


}
