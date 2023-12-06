package lijpe.spin;

import lijpe.spin.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.logging.Logger;

public class Main extends JavaPlugin {
    private static String pluginName = "De Lijpe Spin Plugin";
    private static String version = "MC 1.0.0";

    private Logger logger;

    @Override
    public void onEnable() {
        getCommand("spin").setExecutor(new SpinCommand());
        getCommand("welkom").setExecutor(new WelkomCommand());
        getCommand("bedtijd").setExecutor(new BedTijdCommand());
        getCommand("handalshoed").setExecutor(new HandAlsHoedCommand());
        getCommand("spreekals").setExecutor(new SpreekAlsCommand());

        logger = Bukkit.getServer().getLogger();
        logger.info(pluginName+" is aan hoor! ("+version+")");
    }

    @Override
    public void onDisable() {
        logger.info(pluginName+" is rustig afgesloten! ("+version+")");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("welkom")) {

        }
        else if (label.equalsIgnoreCase("spreekals")){

        }

        return false;
    }
}