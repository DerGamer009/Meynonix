package de.dergamer09.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerLoginEvent;
import cn.nukkit.utils.TextFormat;
import de.dergamer09.Main;

public class MaintenanceListener implements Listener {

    private final Main plugin;

    public MaintenanceListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        if (plugin.isMaintenance()) {
            if (!event.getPlayer().hasPermission("maintenance.bypass")) {
                event.setKickMessage(TextFormat.RED + "Server befindet sich im Wartungsmodus.");
                event.setCancelled(true);
            }
        }
    }
}
