package lijpe.spin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class WelkomCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Deze commando kan alleen door een speler worden uitgevoerd.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            return false;
        }

        Player targetPlayer = getServer().getPlayer(args[0]);

        if (targetPlayer == null) {
            sender.sendMessage("Speler niet gevonden.");
            return true;
        }

        targetPlayer.sendMessage(player.getDisplayName() + " verwelkomt jou!");
        sender.sendMessage("Je hebt " + targetPlayer.getDisplayName() + " verwelkomd!");
        return true;
    }
}
