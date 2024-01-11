package io.gec1gec2.cordirole;

import io.gec1gec2.cordirole.discord.Bot;
import io.gec1gec2.cordirole.persistence.Config;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class Cordirole implements ModInitializer {
    private Bot bot;

    @Override
    public void onInitialize() {
        Config config = new Config();

        this.bot = new Bot(config.get().getBotToken());

        ServerLifecycleEvents.SERVER_STARTED.register((server -> {
            this.bot.start();
        }));

        ServerLifecycleEvents.SERVER_STOPPING.register((server -> {
            this.bot.triggerStopping();
        }));
    }
}
