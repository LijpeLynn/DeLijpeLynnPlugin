package lijpe.spin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class HernoemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length < 1)
            return false;

        if(args.length == 1){
            if(!(sender instanceof Player))
                return false;

            Player player = (Player) sender;
            player.setDisplayName(args[0]);

            sender.sendMessage("Je bent hernoemd tot "+player.getDisplayName()+"!");
            return true;
        } else if(args.length == 2){
            Player targetPlayer = getServer().getPlayer(args[0]);

            if(targetPlayer == null){
                sender.sendMessage("Speler niet gevonden!");
                return false;
            }

            targetPlayer.setDisplayName(args[1]);

            sender.sendMessage(targetPlayer.getName()+" is hernoemd tot "+targetPlayer.getDisplayName()+"!");
            return true;
        }

        return false;
    }
}