package lijpe.spin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

import java.util.Map;

public class SpinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        PluginDescriptionFile description = Bukkit.getPluginManager().getPlugin("DeLijpeSpinPlugin").getDescription();
        // Attempt to cast to the desired type
        Object commandsObject = description.getCommands();
        if (commandsObject instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Map<String, Object>> commands = (Map<String, Map<String, Object>>) commandsObject;

            sender.sendMessage(ChatColor.GOLD+"§e==================");
            sender.sendMessage(ChatColor.GOLD+"§e[De Lijpe Spin Plugin]");
            sender.sendMessage(ChatColor.GOLD+"§e==================");

            for (String commandName : commands.keySet()) {
                Map<String, Object> commandInfo = commands.get(commandName);
                String usage = ChatColor.GREEN+(String) commandInfo.get("usage");
                String descriptionStr = ChatColor.WHITE+(String) commandInfo.get("description");

                sender.sendMessage(usage + ": " + descriptionStr);
            }
        } else {
            sender.sendMessage("Invalid type for commands");
        }

        return true;
    }
}
