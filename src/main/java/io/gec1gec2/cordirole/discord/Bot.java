package io.gec1gec2.cordirole.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.exceptions.InvalidTokenException;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bot extends Thread {
    private static JDA jda;
    private static Guild guild;
    private static Bot instance;

    private static final Logger LOGGER = LoggerFactory.getLogger("bot");

    private static String token;

    public Bot(String token) {
        Bot.token = token;
    }

    public void triggerStopping() {
        if (jda != null) {
            jda.shutdown();
        }
    }

    @Override
    public void run () {
        try {
            jda = null;
            guild = null;
            instance = null;

            JDABuilder builder = JDABuilder.createDefault(token);
            builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
            builder.setMemberCachePolicy(MemberCachePolicy.ALL);

            jda = builder.build();
            instance = this;

            LOGGER.info("Bot constructed!");
        } catch (InvalidTokenException e) {
            LOGGER.error("Invalid token provided");
        } catch (Exception e) {
            LOGGER.error("Error while starting bot ", e);
        }
    }
}
