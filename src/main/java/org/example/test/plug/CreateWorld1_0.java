package org.example.test.plug;

import org.bukkit.plugin.java.JavaPlugin;

public final class CreateWorld1_0 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("sed").setExecutor(new CreateWorld(this));
        getCommand("tpw").setExecutor(new TeleportWorld(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
