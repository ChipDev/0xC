import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.util.DiscordException;

/**
 * Created by blake on 6/6/17.
 */
public class Main {

    //Code taken from https://github.com/austinv11/Discord4J just incase you are from the future and lost context. Thanks.

    public static void main(String[] args){
        IDiscordClient client = createClient(args[0], true);
        EventDispatcher dispatcher = client.getDispatcher(); // Gets the EventDispatcher instance for this client instance
        dispatcher.registerListener(new PingCommand());
    }

    public static IDiscordClient createClient(String token, boolean login) { // Returns a new instance of the Discord client
        ClientBuilder clientBuilder = new ClientBuilder(); // Creates the ClientBuilder instance
        clientBuilder.withToken(token); // Adds the login info to the builder
        try {
            if (login) {
                return clientBuilder.login(); // Creates the client instance and logs the client in
            } else {
                return clientBuilder.build(); // Creates the client instance but it doesn't log the client in yet, you would have to call client.login() yourself
            }
        } catch (DiscordException e) { // This is thrown if there was a problem building the client
            e.printStackTrace();
            return null;
        }
    }



}
