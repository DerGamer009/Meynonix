package de.dergamer09.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import de.dergamer09.Main;

public class MaintenanceCommand extends Command {

    private final Main plugin;

    public MaintenanceCommand(Main plugin) {
        super("maintenance");
        this.plugin = plugin;
        this.setDescription("Schaltet den Wartungsmodus ein oder aus");
        this.setUsage("/maintenance <on|off>");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(TextFormat.RED + "Benutze /maintenance <on|off>");
            return false;
        }

        String arg = args[0].toLowerCase();
        boolean state;
        if ("on".equals(arg)) {
            state = true;
        } else if ("off".equals(arg)) {
            state = false;
        } else {
            sender.sendMessage(TextFormat.RED + "Benutze /maintenance <on|off>");
            return false;
        }

        plugin.setMaintenance(state);
        sender.sendMessage(TextFormat.GREEN + "Wartungsmodus " + (state ? "aktiviert" : "deaktiviert") + ".");
        return true;
    }
}
