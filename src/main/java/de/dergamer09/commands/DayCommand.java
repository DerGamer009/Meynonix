package de.dergamer09.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import cn.nukkit.utils.TextFormat;

public class DayCommand extends Command {

    public DayCommand() {
        super("day");
        this.setDescription("Setzt die Tageszeit auf Tag");
        this.setUsage("/day");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender instanceof Player) {  // Überprüfen, ob der Sender ein Spieler ist
            Player player = (Player) sender;
            Level level = player.getLevel();  // Zugriff auf das Level des Spielers
            if (level != null) {
                level.setTime(Level.TIME_DAY);  // Setzt die Tageszeit auf Tag
                player.sendMessage(TextFormat.GREEN + "Es ist jetzt Tag!");
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
