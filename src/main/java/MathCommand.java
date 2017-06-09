import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by blake on 6/8/17.
 */
public class MathCommand implements GenericCommand {


    public String getName() {
        return "math";
    }

    public String getDescription() {
        return "Takes in an algebraic expression, prints out values. Powered by *cymath.com*";
    }

    public void messageRecieved(MessageReceivedEvent event) {

        try {

            String urlq = URLEncoder.encode(event.getMessage().getContent(), "UTF-8").replace("+", "%20");
            URL url = new URL("https://www.cymath.com/answer?q=" + urlq);
            InputStream is = null;
            is = url.openStream();
            int ptr = 0;
            StringBuffer buffer = new StringBuffer();
            while ((ptr = is.read()) != -1) {
                buffer.append((char)ptr);
            }
            is.close();

            String[] htmlsplit = buffer.toString().split("<p class=\"decimal\">");
            String decimalval = (htmlsplit[1].split("</p>"))[0];

            event.getChannel().sendMessage(decimalval + " , *values may be approxamate. Results from cymath.com*");

        } catch (UnsupportedEncodingException e) {
            event.getChannel().sendMessage("Error! Exception: " + e);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
