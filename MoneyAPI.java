package me.kali.skeconomy.comandos;

import org.bukkit.entity.Player;

import me.kali.apis.ConfigAPI;
import me.kali.skeconomy.Main;

public class MoneyAPI {
	public static ConfigAPI config = new ConfigAPI("config.yml", Main.plugin);

	public static double getMoney(Player player) {
		
		return config.getDouble("contas." + player.getName());
		
	}
public static void setMoney(Player player, double money) {
config.set("contas." +player.getName(), money);
config.saveConfig();
}
public static void addMoney(Player player, double money) {
setMoney(player, getMoney(player) +money);
}
public static void removeMoney(Player player, double money) {
setMoney(player, getMoney(player) -money);
}
}
