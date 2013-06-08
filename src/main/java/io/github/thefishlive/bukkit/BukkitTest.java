package io.github.thefishlive.bukkit;

import org.bukkit.plugin.java.JavaPlugin;

public class BukkitTest extends JavaPlugin {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
    }
}
