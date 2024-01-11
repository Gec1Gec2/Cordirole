package io.gec1gec2.cordirole.persistence;

import io.gec1gec2.cordirole.defs.DiscordPlayerHashMap;
import io.gec1gec2.cordirole.util.JsonStorage;

public class DiscordPlayerMapStorage extends JsonStorage<DiscordPlayerHashMap> {
    @Override
    protected String getFileName() {
        return "discordplayer.json";
    }

    @Override
    protected DiscordPlayerHashMap getBoilerplate() {
        return new DiscordPlayerHashMap();
    }

    @Override
    protected Class getClazz() {
        return DiscordPlayerHashMap.class;
    }
}
