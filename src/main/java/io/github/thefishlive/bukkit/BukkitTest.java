package io.github.thefishlive.bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitTest extends JavaPlugin {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        Player player = (Player) sender;
        
        if (label.equalsIgnoreCase("methods")) {
            
            if (args.length < 1) {
                return false;
            }
            
            if (args[0].equalsIgnoreCase("workbench")) {
                player.openWorkbench(null, true);
                sender.sendMessage("Opened workbench inventory");
                return true;
            }
            
            if (args[0].equalsIgnoreCase("enchanting")) {
                player.openEnchanting(null, true);
                sender.sendMessage("Opened enchanting inventory");
                return true;
            }
            
            if (args[0].equalsIgnoreCase("anvil")) {
                player.openAnvil(null, true);
                sender.sendMessage("Opened anvil inventory");
                return true;
            }
            
            return false;
        }
        
        InventoryType type = InventoryType.valueOf(label.toUpperCase());
        if (type == null) {
            return false;
        }
        
        Inventory inv = getServer().createInventory(player, type);
        player.openInventory(inv);
        sender.sendMessage("Opened " + type.name().toLowerCase() + " inventory");
        
        return true;       
    }
}
