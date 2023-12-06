package lijpe.spin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class SpreekAlsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length < 2)
            return false;

        Player targetPlayer = getServer().getPlayer(args[0]);

        if (targetPlayer == null) {
            sender.sendMessage("Speler niet gevonden.");
            return true;
        }

        targetPlayer.chat(args[1]);

        return true;
    }
}