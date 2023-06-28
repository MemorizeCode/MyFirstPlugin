package org.example.test.plug;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class TeleportWorld implements CommandExecutor {
    private  final JavaPlugin plugin;

    public TeleportWorld(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    World worlds;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            String worldName = args[0];
            if(args.length == 1){
                Location loc = new Location(Bukkit.getWorld(worldName), 0 , 0, 0);
                player.getPlayer().teleport(loc);
                player.sendMessage(ChatColor.YELLOW + "Телепортация в мир" + worlds.getName());
                player.sendMessage(ChatColor.GREEN + "Вы были телепортированы в мир " + worlds.getName());
            }
            else{
                player.sendMessage(ChatColor.RED + "Введите /tpw name_world");
            }
        }
        return false;
    }
}
