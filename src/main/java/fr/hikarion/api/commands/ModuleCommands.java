package fr.hikarion.api.commands;

import fr.hikarion.api.API;
import fr.hikarion.api.models.Module;
import fr.hikarion.api.utils.commands.Command;
import fr.hikarion.api.utils.commands.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ModuleCommands {

    @Command(name = "module", permission = "hikarion.module",
            noPerm = "§cTu joues à des jeux dangereux.", description = "Hikarion Admin commands")
    public void onModuleCommand(CommandArgs args) {

        API main = API.getInstance();

        CommandSender sender = args.getSender();

        if (args.length() == 0) {
            sender.sendMessage("§7§m--------------------------------");
            sender.sendMessage("§cAttention cette commande permet de désactiver");
            sender.sendMessage("§cles modules hikarion.");
            sender.sendMessage("§f   ");
            sender.sendMessage("§cUtilisation: /module <list/nom> <on/off>");
            sender.sendMessage("§7§m--------------------------------");
        } else if (args.length() == 1) {

            if (args.getArgs(0).equalsIgnoreCase("list")) {

                sender.sendMessage("§7Liste des modules:");
                sender.sendMessage("§7Actif: §a" + main.getModuleManager().getActivatedList()
                        .toString().replace("[", " ").replace("]", " "));
                sender.sendMessage("§7Inactif: §c" + main.getModuleManager().getUnactivatedList()
                        .toString().replace("[", " ").replace("]", " "));

            } else {
                sender.sendMessage("§cUtilisation: /module");
            }

        } else if (args.length() == 2) {

            String name = args.getArgs(0);

            if (main.getModuleManager().getModuleNameList().contains(name)) {

                if (args.getArgs(1).equalsIgnoreCase("on")) {

                    Module module = main.getModuleManager().getModule(name);
                    if (module.isActive()) {
                        sender.sendMessage("§cLe module est déja activer");
                    } else {
                        module.setActive(true);
                        sender.sendMessage("§aVous venez d'activer avec succes le module: §f" + name);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            if (players.hasPermission("hikarion.module")) {
                                players.sendMessage("§7§m----------------------------");
                                players.sendMessage("§f» §7Module: §f" + name);
                                players.sendMessage("§f» §7Etat: §aActivé");
                                players.sendMessage("§f» §7Par: §f" + sender.getName());
                                players.sendMessage("§7§m----------------------------");
                            }
                        }
                    }

                } else if (args.getArgs(1).equalsIgnoreCase("off")) {

                    Module module = main.getModuleManager().getModule(name);
                    if (!module.isActive()) {
                        module.setActive(false);
                        sender.sendMessage("§aVous venez de désactiver avec succes le module: §f" + name);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            if (players.hasPermission("hikarion.module")) {
                                players.sendMessage("§7§m----------------------------");
                                players.sendMessage("§f» §7Module: §f" + name);
                                players.sendMessage("§f» §7Etat: §cDésactivé");
                                players.sendMessage("§f» §7Par: §f" + sender.getName());
                                players.sendMessage("§7§m----------------------------");
                            }
                        }
                    } else {
                        sender.sendMessage("§cLe module est déja désactiver");
                    }

                } else {
                    sender.sendMessage("§cAttention respectez les majuscules pour les noms des modules!");
                    sender.sendMessage("§cUtilisation: /module");
                }

            } else {
                sender.sendMessage("§cAttention respectez les majuscules pour les noms des modules!");
                sender.sendMessage("§cUtilisation: /module");
            }

        } else {
            sender.sendMessage("§cUtilisation: /module");
        }

    }

}
