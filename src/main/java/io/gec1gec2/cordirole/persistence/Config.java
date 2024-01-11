package io.gec1gec2.cordirole.persistence;

import io.gec1gec2.cordirole.defs.CordiroleConfig;
import io.gec1gec2.cordirole.util.JsonStorage;

public class Config extends JsonStorage<CordiroleConfig> {
    @Override
    protected String getFileName() {
        return "cordirole.json";
    }

    @Override
    protected CordiroleConfig getBoilerplate() {
        return CordiroleConfig.boilerplate();
    }

    @Override
    protected Class getClazz() {
        return CordiroleConfig.class;
    }
}
