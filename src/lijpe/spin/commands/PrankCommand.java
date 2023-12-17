package lijpe.spin.commands;

import lijpe.spin.helpers.Messaging;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrankCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Alleen een speler kan dit doen!");
            return true;
        }

        if(args.length != 1){
            Messaging.Announce("Je moder", ((Player)sender).getDisplayName()+" probeerde zojuist iedereen te pranken!");
            return true;
        }

        if(args[0].equalsIgnoreCase("herobrine")){
            Messaging.SendAll(ChatColor.YELLOW + "Herobrine joined the game." + ChatColor.WHITE);
        }

        return true;
    }
}