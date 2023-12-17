package lijpe.spin.commands;

import lijpe.spin.Main;
import lijpe.spin.helpers.Messaging;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) || args.length == 0)
            return false;

        Player player = (Player) sender;
        World world = player.getWorld();

        switch (args[0].toLowerCase()) {
            case "mooi":
                world.setStorm(false);
                world.setThundering(false);
                Messaging.Announce("Je moder", player.getDisplayName()+" heeft mooi weer meegenomen!");
                return true;
            case "regen":
                world.setStorm(true);
                world.setThundering(false);
                Messaging.Announce("Je moder", "Je kunt "+player.getDisplayName()+" uitschelden voor de regen!");
                return true;
            case "onweer":
                world.setStorm(true);
                world.setThundering(true);
                Messaging.Announce("Je moder", player.getDisplayName()+" is geen dondergod, maar heeft toch onweer over iedereen afgeroepen!");
                return true;
        }

        return false;
    }
}
