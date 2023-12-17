package lijpe.spin.commands;

import lijpe.spin.helpers.Items;
import lijpe.spin.helpers.Messaging;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class PoepCommand implements CommandExecutor {
    private static final String ROTTEN_FLESH = "rotvlees";
    private static final String FLOWERS = "bloemen";

    private static HashMap<Player, String> poependeSpelers = new HashMap<Player, String>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = null;

        player = (Player) sender;

        if (args.length == 2){
            player = Bukkit.getPlayer(args[1]);

            if(player == null){
                sender.sendMessage("Speler niet gevonden!");
                return false;
            }
        }

        if(poependeSpelers.containsKey(player)){
            player.chat("Ik wil even zeggen dat ik net heerlijk "+poependeSpelers.get(player)+" heb gescheten!");
            poependeSpelers.remove(player);
            return true;
        }

        if(args.length == 0){
            player.chat("Ik probeerde net te stoppen met schijten, maar ik was dus helemaal niet aan het schijten.");
            return true;
        }

        switch(args[0].toLowerCase()){
            case ROTTEN_FLESH:
                poependeSpelers.put(player, ROTTEN_FLESH);
                break;
            case FLOWERS:
                poependeSpelers.put(player, FLOWERS);
                break;
        }

        sender.sendMessage(player.getDisplayName()+" poept nu "+args[0]+"!");

        return true;
    }

    public static void Poep(){
        for (Map.Entry<Player, String> entry : poependeSpelers.entrySet()) {
            Player player = entry.getKey();
            String poepType = entry.getValue();

            if(poepType.equals(ROTTEN_FLESH))
                Items.SpawnItemsAtPlayer(player, Material.ROTTEN_FLESH, 1);
            else if (poepType.equals(FLOWERS)){
                setFlowerBlock(player);
            }
        }
    }

    public static void setFlowerBlock(Player player) {
        Location playerLocation = player.getLocation();

        Location blockAbove = playerLocation.clone();

        if (blockAbove.getBlock().getType() == Material.AIR) {
            blockAbove.getBlock().setType(Material.YELLOW_FLOWER);
        }
    }
}
