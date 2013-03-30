package me.fish.bukkit;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Merchant.MerchantTrade;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin implements Listener {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerInteract(EntityTargetLivingEntityEvent event) {
		if (!EntityType.VILLAGER.equals(event.getTarget().getType())) {
			return;
		}
		
		if (!EntityType.PLAYER.equals(event.getEntity().getType())) {
			return;
		}
		
		Player player = (Player) event.getEntity();
		Villager villager = (Villager) event.getTarget();
		
		for (MerchantTrade trade : villager.getTrades()) {
			player.sendMessage("Product: " + trade.getProduct() + ";Price: " + trade.getPrice());
		}
	}

	@EventHandler
	public void onPlayerOpenInv(InventoryOpenEvent open) {
		if (!(open.getInventory() instanceof MerchantInventory)) {
			return;
		}
		
		MerchantInventory inv = (MerchantInventory) open.getInventory();
		
		List<MerchantTrade> trades = Arrays.asList(new MerchantTrade(new ItemStack(Material.EMERALD, 5), new ItemStack(Material.DIAMOND, 5)),
													new MerchantTrade(new ItemStack(Material.DIAMOND, 5), new ItemStack(Material.EMERALD, 5)));
		
		inv.getMerchant().setTrades(trades);
	}
	
}
