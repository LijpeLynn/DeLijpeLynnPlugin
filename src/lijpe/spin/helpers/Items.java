package lijpe.spin.helpers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Items {
    public static void SpawnItemsAtPlayer(Player player, Material mat, int count) {
        Location playerLocation = player.getLocation();

        ItemStack itemStack = new ItemStack(mat, 1);

        player.getWorld().dropItem(playerLocation, itemStack);
    }
}
