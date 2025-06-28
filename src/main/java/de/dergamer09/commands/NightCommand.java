package de.dergamer09.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import cn.nukkit.utils.TextFormat;

public class NightCommand extends Command {

    public NightCommand() {
        super("night");
        this.setDescription("Setzt die Tageszeit auf Nacht");
        this.setUsage("/night");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender instanceof Player) {  // Überprüfen, ob der Sender ein Spieler ist
            Player player = (Player) sender;
            Level level = player.getLevel();  // Zugriff auf das Level des Spielers
            if (level != null) {
                level.setTime(Level.TIME_NIGHT);  // Setzt die Tageszeit auf Nacht
                player.sendMessage(TextFormat.GREEN + "Es ist jetzt Nacht!");
                return true;
            } else {
                player.sendMessage(TextFormat.RED + "Ungültige Welt!");
                return false;
            }
        } else {
            sender.sendMessage(TextFormat.RED + "Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
            return false;
        }
    }
}