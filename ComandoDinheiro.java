package me.kali.skeconomy.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kali.apis.Mine;

public class ComandoDinheiro implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (args.length == 0) {
				double dinheiro = MoneyAPI.getMoney(p);

				p.sendMessage("§aVocê possui §7" + dinheiro + " §ade money.");

				Mine.sendActionBar(p, "§aVocê possui §7" + dinheiro + " §ade money.");

			} else {

				if (args[0].equalsIgnoreCase("set")) {
					if (args.length <= 2) {

						p.sendMessage("");
						p.sendMessage("§aUtilize /money set <Jogador> <Quantia>.");
						p.sendMessage("");

					} else {

						Player alvo = Bukkit.getPlayer(args[1]);
						Double quantidade = Mine.toDouble(args[2]);

						p.sendMessage("");
						p.sendMessage("§aVocê alterou a quantidade de money do jogador §f" + alvo.getName()
								+ " §apara §f" + quantidade + "§a.");
						p.sendMessage("");

						MoneyAPI.setMoney(alvo, quantidade);

					}
				}
				if (args[0].equalsIgnoreCase("add")) {
					if (args.length <= 2) {

						p.sendMessage("");
						p.sendMessage("§aUtilize /money add <Jogador> <Quantia>.");
						p.sendMessage("");

					} else {

						Player alvo = Bukkit.getPlayer(args[1]);
						Double quantidade = Mine.toDouble(args[2]);

						p.sendMessage("");
						p.sendMessage("§aVocê adicionou §f" + quantidade + " §ade money na conta do jogador §f" + alvo.getName() + "§a.");
						p.sendMessage("");

						MoneyAPI.addMoney(alvo, quantidade);

					}
				}
				if (args[0].equalsIgnoreCase("remove")) {
					if (args.length <= 2) { 
						p.sendMessage("");
						p.sendMessage("§aUtilize /money remove <Jogador> <Quantia>.");
						p.sendMessage("");

					} else {

						Player alvo = Bukkit.getPlayer(args[1]);
						Double quantidade = Mine.toDouble(args[2]);

						p.sendMessage("");
					p.sendMessage("§aVocê excluiu §f" + quantidade + " §amoney da conta do jogador §f" + alvo.getName() + "§a.");
						p.sendMessage("");

						MoneyAPI.removeMoney(alvo, quantidade);

					}

				}

			}
		}

		return true;
	}

}
