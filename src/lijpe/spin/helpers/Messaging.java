package lijpe.spin.helpers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messaging {

    public static void Announce(String announcer, String msg){
        String formattedMessage = ChatColor.YELLOW + "["+announcer+"] " + ChatColor.WHITE + msg.trim();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if(player != null)
                player.sendMessage(formattedMessage);
        }
    }

    public static void SendAll(String message)
    {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if(player != null)
                player.sendMessage(message);
        }
    }
    public static String GetMessageFromArgs(String[] args) {
        return GetMessageFromArgs(args, 1);
    }

    public static String GetMessageFromArgs(String[] args, int startArg){
        String msg = "";
        for (int i = startArg; i < args.length-1; i++)
            msg += args[i]+" ";
        msg += args[args.length-1];

        return msg;
    }
}
