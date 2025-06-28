package de.dergamer09.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

public class HealCommand extends Command {

    public HealCommand() {
        super("heal");
        this.setDescription("Heilt den Spieler");
        this.setUsage("/heal");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender instanceof Player) {  // Überprüfen, ob der Sender ein Spieler ist
            Player player = (Player) sender;
            player.setHealth(player.getMaxHealth());  // Setzt die Gesundheit des Spielers auf das Maximum
            player.sendMessage(TextFormat.GREEN + "Du wurdest geheilt!");
            return true;
        } else {
            sender.sendMessage(TextFormat.RED + "Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
            return false;
        }
    }
}