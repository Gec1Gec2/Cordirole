package io.gec1gec2.cordirole.defs;

import java.util.HashMap;

public class CordiroleConfig {
    private String botToken = "";

    private HashMap<String, String> lpGroupToRole = new HashMap<>();

    private String guildId = "";

    public static CordiroleConfig boilerplate() {
        var roleToGroup = new HashMap<String, String>();
        roleToGroup.put("builder", "51281597191678169");

        return new CordiroleConfig("", roleToGroup);
    }

    public CordiroleConfig(String botToken, HashMap<String, String> lpGroupToRole) {
        this.botToken = botToken;
        this.lpGroupToRole = lpGroupToRole;
    }

    public String getGuildId() {
        return guildId;
    }

    public String getBotToken() {
        return botToken;
    }
}
