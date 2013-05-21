package com.endercraftservers.geekygamer14;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class KitPlugin extends JavaPlugin {
	
	public void onEnable()
	{
		getLogger().info("Turning on Kits by GeekyGamer14.");
		getLogger().info("Kits enabled!");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		//TODO add cooldown
		//PlayerCooldown pc = Cooldown.getCooldown("KitCooldown", sender.getName(), 7200000);
		//if(pc.isOver()){
		Player player = (Player) sender;
		Location location = player.getEyeLocation();
		PlayerInventory inventory = player.getInventory();
		if (commandLabel.equalsIgnoreCase("kit")){
			{
				if(args[0].equalsIgnoreCase("vip")){
					sender.sendMessage(ChatColor.GREEN + "You got the VIP kit!");
					player.playSound(location, Sound.PORTAL_TRAVEL, 10F, 0F);
					Bukkit.broadcastMessage(ChatColor.RED + "[RedBullCraft] " + ChatColor.BLUE + sender.getName() + ChatColor.RED + " got the VIP kit!");
					inventory.addItem(new ItemStack(Material.DIAMOND_AXE.getId()));
					inventory.addItem(new ItemStack(Material.DIAMOND_HOE.getId()));
					inventory.addItem(new ItemStack(Material.DIAMOND_SWORD.getId()));
					inventory.addItem(new ItemStack(Material.DIAMOND_PICKAXE.getId()));
					inventory.addItem(new ItemStack(Material.DIAMOND_SPADE.getId()));
					inventory.addItem(new ItemStack(Material.EXP_BOTTLE.getId(), 16));
					inventory.addItem(new ItemStack(Material.DIAMOND.getId(), 16));
					inventory.addItem(new ItemStack(Material.LOG.getId(), 64));
					inventory.addItem(new ItemStack(Material.GRASS.getId(), 64));
					inventory.addItem(new ItemStack(Material.COBBLESTONE.getId(), 64));
					inventory.addItem(new ItemStack(Material.NETHERRACK.getId(), 64));
			    	inventory.addItem(new ItemStack(Material.SOUL_SAND.getId(), 64));
			    	inventory.addItem(new ItemStack(Material.GLOWSTONE.getId(), 64));
			    	inventory.addItem(new ItemStack(Material.QUARTZ_BLOCK.getId(), 64));
				}else if(args[0].equalsIgnoreCase("mod")){
					sender.sendMessage(ChatColor.GREEN + "You got the moderator kit!");
					player.playSound(location, Sound.PORTAL_TRAVEL, 10F, 0F);
					Bukkit.broadcastMessage(ChatColor.RED + "[RedBullCraft] " + ChatColor.DARK_BLUE + sender.getName() + ChatColor.RED + " got the moderator kit!");
					inventory.addItem(new ItemStack(Material.DIAMOND_AXE.getId()));
					inventory.addItem(new ItemStack(Material.DIAMOND_HOE.getId()));
					inventory.addItem(new ItemStack(Material.DIAMOND_SWORD.getId()));
					inventory.addItem(new ItemStack(Material.DIAMOND_PICKAXE.getId()));
					inventory.addItem(new ItemStack(Material.DIAMOND_SPADE.getId()));
					inventory.addItem(new ItemStack(Material.EXP_BOTTLE.getId(), 16));
					inventory.addItem(new ItemStack(Material.DIAMOND.getId(), 16));
					return true;
				}else if(args[0].equalsIgnoreCase("tools")){
					sender.sendMessage(ChatColor.GREEN + "You got the tools kit!");
					player.playSound(location, Sound.PORTAL_TRAVEL, 10F, 0F);
					Bukkit.broadcastMessage(ChatColor.RED + "[RedBullCraft] " + ChatColor.DARK_BLUE + sender.getName() + ChatColor.RED + " got the tools kit!");
					inventory.addItem(new ItemStack(Material.LOG.getId(), 64));
				    inventory.addItem(new ItemStack(Material.GRASS.getId(), 64));
				    inventory.addItem(new ItemStack(Material.COBBLESTONE.getId(), 64));
				    inventory.addItem(new ItemStack(Material.NETHERRACK.getId(), 64));
				    inventory.addItem(new ItemStack(Material.SOUL_SAND.getId(), 64));
				    inventory.addItem(new ItemStack(Material.GLOWSTONE.getId(), 64));
				    inventory.addItem(new ItemStack(Material.QUARTZ_BLOCK.getId(), 64));
				}
				return true;
			}
		}else{
		//TODO	player.sendMessage("You have " + pc.getTimeLeft() + " seconds left until you can use a kit." );
	}
		return false;
}
}