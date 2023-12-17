package lijpe.spin.commands;

import lijpe.spin.helpers.Messaging;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class OpHoofdVanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Alleen een speler kan dit doen!");
            return true;
        }

        Player sp = (Player) sender;

        if(args.length != 1)
            return false;

        Player player = Bukkit.getPlayer(args[0]);

        if(player == null){
            sender.sendMessage("Speler niet gevonden.");
            return false;
        }

        if(player == sp){
            Messaging.Announce("Je moder", sp.getDisplayName()+" probeerde op zijn eigen hoofd te gaan zitten!");
            return true;
        }

        if(player.getLocation().subtract(sp.getLocation()).length() > 20){
            sp.sendMessage("Helaas, "+player.getDisplayName()+" is meer dan 20 blokjes van je vandaan!");
            return true;
        }

        sp.setPassenger(null);

        player.setPassenger((Entity)sender);

        Messaging.Announce("Je moder", sp.getDisplayName()+" is op het hoofd gaan zitten van "+player.getDisplayName()+"!");

        return true;
    }
}