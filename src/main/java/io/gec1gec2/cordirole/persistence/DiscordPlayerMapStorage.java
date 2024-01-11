package io.gec1gec2.cordirole.persistence;

import io.gec1gec2.cordirole.util.JsonStorage;
import io.gec1gec2.cordirole.defs.DiscordPlayerMap;

public class DiscordPlayerMapStorage extends JsonStorage<DiscordPlayerMap> {
    @Override
    protected String getFileName() {
        return "discordplayer.json";
    }

    @Override
    protected DiscordPlayerMap getBoilerplate() {
        return new DiscordPlayerMap();
    }

    @Override
    protected Class getClazz() {
        return DiscordPlayerMap.class;
    }
}
