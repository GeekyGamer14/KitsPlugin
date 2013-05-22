package com.endercraftservers.geekygamer14;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class KitPlugin extends JavaPlugin {
	
	private void setupConfig(FileConfiguration config) throws IOException {
		if(!new File(getDataFolder(), "Delete this file to reset the config file").exists()){
			config.set("info", "This config is not working at the moment!");
			config.set("kits.Vip.Items", "279-1, 278-1, 277-1, 276-1, 320-64");
			config.set("kits.Mod.Items", "50-64, 42-10, 57-10, 41-10");
			
			
			config.set("vipkits.Names", "Vip, Mod");
			
			new File(getDataFolder(), "Delete this file to reset the config file").createNewFile();}
		}
	public void onEnable()
	{
		getLogger().info("Turning on Kits by GeekyGamer14.");
		getLogger().info("Kits enabled!");
		 try{
			 saveConfig();
			 setupConfig(getConfig());
			 saveConfig();
			}catch(Exception e) {
			 e.printStackTrace();}
	}
	
	Countdown cd = new Countdown();
	
	private List<Player> cooldowns = new ArrayList<Player>();
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		getConfig();
		Player player = (Player) sender;
		Location location = player.getEyeLocation();
		PlayerInventory inventory = player.getInventory();
		if (commandLabel.equalsIgnoreCase("kit")){
			if(!cooldowns.contains(player)){
			{
				if(args.length != 1){
					sender.sendMessage(ChatColor.RED + "Please enter a kit name.");
					return true;
				}
				if(args[0].equalsIgnoreCase("vip")){
					if(sender.hasPermission("kits.vip")){
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
				    	cd.setList(cooldowns);
				    	cd.setPlayer(player);
				    	new Thread(cd).start();
				    	return true;
					}else{
						sender.sendMessage(ChatColor.RED + "You are not a VIP!");
						// I returned it true because I don't want it saying the correct usage :P
						return true;
					}
				}else if(args[0].equalsIgnoreCase("mod")){
					if(sender.hasPermission("kits.mod")){
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
						cd.setList(cooldowns);
				    	cd.setPlayer(player);
				    	new Thread(cd).start();
						return true;
					}else{
						sender.sendMessage(ChatColor.RED + "You are not a moderator!");
						return true;
					}

				}else if(args[0].equalsIgnoreCase("supplies")){
					if(sender.hasPermission("kits.supplies")){
						sender.sendMessage(ChatColor.GREEN + "You got the supplies kit!");
						player.playSound(location, Sound.PORTAL_TRAVEL, 10F, 0F);
						Bukkit.broadcastMessage(ChatColor.RED + "[RedBullCraft] " + ChatColor.DARK_BLUE + sender.getName() + ChatColor.RED + " got the supplies kit!");
						inventory.addItem(new ItemStack(Material.LOG.getId(), 64));
					    inventory.addItem(new ItemStack(Material.GRASS.getId(), 64));
					    inventory.addItem(new ItemStack(Material.COBBLESTONE.getId(), 64));
					    inventory.addItem(new ItemStack(Material.NETHERRACK.getId(), 64));
					    inventory.addItem(new ItemStack(Material.SOUL_SAND.getId(), 64));
					    inventory.addItem(new ItemStack(Material.GLOWSTONE.getId(), 64));
					    inventory.addItem(new ItemStack(Material.QUARTZ_BLOCK.getId(), 64));
					    cd.setList(cooldowns);
				    	cd.setPlayer(player);
				    	new Thread(cd).start();
					    return true;
					}else{
						sender.sendMessage(ChatColor.RED + "You are not a moderator!");
						return true;
					}
				}
				}
				return true;
			}
		}
		//TODO	player.sendMessage("You have " + pc.getTimeLeft() + " seconds left until you can use a kit." );
		return false;
	}
	{
}
	
	
	
	public class Countdown implements Runnable{

		public Player player = null;
		public List<Player> cooldowns = new ArrayList<Player>();
		
		public void setPlayer(Player player){
			this.player = player;
		}
		
		public void setList(List<Player> list){
			cooldowns = list;
		}
		
		public List<Player> getList(){
			
			
			return cooldowns;
		}
		
		public void run() {
			try{
				Thread.sleep(7200000);
				cooldowns.remove(player);
			}catch(Exception ignored){
				
			}
		}
	
	}
	
}