package lijpe.spin.commands;

import lijpe.spin.helpers.Messaging;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MeldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length < 2 || !args[0].contains("\""))
            return false;

        String line = "";
        for(String arg : args){
            line += arg+" ";
        }

        String[] split = line.trim().split("\"");

        if(split.length != 3)
            return false;

        String service = split[1];

        Messaging.Announce(service, split[2]);

        return true;
    }
}
