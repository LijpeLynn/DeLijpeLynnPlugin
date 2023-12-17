package lijpe.spin;

import lijpe.spin.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    private static String pluginName = "De Lijpe Spin Plugin";
    private static String version = "MC 1.0.0";

    private Logger logger;

    private BukkitScheduler scheduler;
    private BukkitTask task;

    @Override
    public void onEnable() {
        getCommand("spin").setExecutor(new SpinCommand());
        getCommand("welkom").setExecutor(new WelkomCommand());
        getCommand("bedtijd").setExecutor(new BedTijdCommand());
        getCommand("handalshoed").setExecutor(new HandAlsHoedCommand());
        getCommand("spreekals").setExecutor(new SpreekAlsCommand());
        getCommand("weer").setExecutor(new WeerCommand());
        getCommand("meld").setExecutor(new MeldCommand());
        getCommand("poep").setExecutor(new PoepCommand());
        getCommand("hernoem").setExecutor(new HernoemCommand());
        getCommand("prank").setExecutor(new PrankCommand());
        getCommand("ophoofdvan").setExecutor(new OpHoofdVanCommand());

        logger = Bukkit.getServer().getLogger();
        logger.info(pluginName+" is aan hoor! ("+version+")");

        startTick();
    }

    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTasks(this);

        logger.info(pluginName+" is rustig afgesloten! ("+version+")");
    }

    private void startTick(){
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            onTick();
        }, 0L, 10L);
    }

    private void onTick(){
        PoepCommand.Poep();
    }
}
