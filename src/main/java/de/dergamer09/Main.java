package de.dergamer09;

import cn.nukkit.plugin.PluginBase;
import de.dergamer09.commands.DayCommand;
import de.dergamer09.commands.HealCommand;
import de.dergamer09.commands.NightCommand;

public class Main extends PluginBase {

    @Override
    public void onEnable() {
        getLogger().info("[Meynonix] Plugin Enabled");

        this.getServer().getCommandMap().register("day", new DayCommand());
        this.getServer().getCommandMap().register("night", new NightCommand());
        this.getServer().getCommandMap().register("heal", new HealCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("[Meynonix] Plugin Disabled");
    }

}