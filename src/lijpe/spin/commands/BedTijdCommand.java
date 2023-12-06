package lijpe.spin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BedTijdCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        long time = sender.getServer().getWorlds().get(0).getTime();

        if (time >= 13000 && time < 24000) {
            for (Player player : sender.getServer().getOnlinePlayers()) {
                if (!player.equals(sender)) {
                    player.sendMessage("GA NOU SLAPEN!!!");
                }
            }
            sender.sendMessage("De spelers zijn naar bed gestuurd! Het is ook gewoon daadwerkelijk donker, goed gezien hoor!");
        } else {
            sender.sendMessage("Hallo! De bedtijdprankpreventie hier! Stiekem zeggen dat ze moeten gaan slapen, terwijl het niet eens nacht is, hè? Prankmeister!");
        }

        return true;
    }
}