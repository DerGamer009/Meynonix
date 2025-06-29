package de.dergamer09;

import cn.nukkit.plugin.PluginBase;
import de.dergamer09.commands.DayCommand;
import de.dergamer09.commands.HealCommand;
import de.dergamer09.commands.MaintenanceCommand;
import de.dergamer09.commands.NightCommand;
import de.dergamer09.listener.MaintenanceListener;

public class Main extends PluginBase {

    private boolean maintenance = false;

    public boolean isMaintenance() {
        return maintenance;
    }

    public void setMaintenance(boolean maintenance) {
        this.maintenance = maintenance;
        if (maintenance) {
            this.getServer().getOnlinePlayers().values().forEach(player -> {
                if (!player.hasPermission("maintenance.bypass")) {
                    player.kick("Server befindet sich im Wartungsmodus.");
                }
            });
        }
    }

    @Override
    public void onEnable() {
        getLogger().info("[Meynonix] Plugin Enabled");

        this.getServer().getCommandMap().register("day", new DayCommand());
        this.getServer().getCommandMap().register("night", new NightCommand());
        this.getServer().getCommandMap().register("heal", new HealCommand());
        this.getServer().getCommandMap().register("maintenance", new MaintenanceCommand(this));

        this.getServer().getPluginManager().registerEvents(new MaintenanceListener(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("[Meynonix] Plugin Disabled");
    }

}