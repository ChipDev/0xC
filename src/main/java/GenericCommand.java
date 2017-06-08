import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by blake on 6/6/17.
 */
public interface GenericCommand {

    public String getName();
    public String getDescription();
    public void messageRecieved(MessageReceivedEvent event);

}
