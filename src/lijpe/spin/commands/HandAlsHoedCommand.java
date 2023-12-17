package lijpe.spin.commands;

import net.minecraft.server.ItemBlock;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HandAlsHoedCommand  implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Dit commando kan alleen door een speler worden uitgevoerd.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            return false;
        }

        Player targetPlayer = player.getServer().getPlayer(args[0]);

        if (targetPlayer == null) {
            sender.sendMessage("Speler niet gevonden: " + args[0]);
            return true;
        }

        // Krijg het item in de hand van de sender
        ItemStack handItem = player.getInventory().getItemInHand();

        if(handItem == null)
            return false;

        // Krijg het huidige helmet van de target speler
        ItemStack currentHelmet = targetPlayer.getInventory().getHelmet();

        // Als de target speler een helmet heeft, plaats het in zijn inventaris
        if (currentHelmet != null && currentHelmet.getType() != Material.AIR) {
            targetPlayer.getWorld().dropItemNaturally(targetPlayer.getLocation(), currentHelmet);
        }

        // Plaats het item in de hand van de sender als een helmet op de target speler
        targetPlayer.getInventory().setHelmet(handItem);

        player.getInventory().setItemInHand(null);

        sender.sendMessage("Je hebt "+ targetPlayer.getDisplayName() +" geprankt door deze een bijzondere hoed te schenken, haha hilarisch " + player.getDisplayName()+"!");

        return true;
    }
}