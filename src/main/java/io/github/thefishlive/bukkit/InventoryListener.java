package io.github.thefishlive.bukkit;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class InventoryListener implements Listener {
	
	@EventHandler
	public void onOpenInventory(InventoryOpenEvent event) {
		((Player)event.getPlayer()).sendMessage(event.getInventory().getType().toString());
	}

	@EventHandler
	public void onOpenInventory(InventoryClickEvent event) {
		((Player)event.getWhoClicked()).sendMessage(event.getSlotType().toString());
	}

}