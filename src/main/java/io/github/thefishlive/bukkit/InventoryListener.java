package io.github.thefishlive.bukkit;

import org.bukkit.MerchantTrade;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.MerchantInventory;

public class InventoryListener implements Listener {

    @SuppressWarnings("unused")
    private BukkitTest plugin;

    public InventoryListener(BukkitTest bukkitTest) {
        this.plugin = bukkitTest;
    }
    
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (!(event.getInventory() instanceof MerchantInventory)) {
            return;
        }
        
        Player player = (Player)event.getPlayer();
        MerchantInventory inventory = (MerchantInventory) event.getInventory();
        
        for (MerchantTrade trade : inventory.getTrades()) {
            if (trade == null) {
                player.sendMessage("null");
                continue;
            }
            player.sendMessage(trade.toString());
        }
    }

}
