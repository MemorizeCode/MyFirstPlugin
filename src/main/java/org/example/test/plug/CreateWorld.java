package org.example.test.plug;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class CreateWorld implements CommandExecutor {
    World world;
    private final JavaPlugin plugin;

    public CreateWorld(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand( CommandSender sender,  Command command,  String s,  String[] args) {
        if(sender instanceof Player){
            String worldSeed = args[0];
            Player player = (Player) sender;
            WorldCreator worlds = new WorldCreator(worldSeed);
            worlds.environment(World.Environment.NORMAL);
            worlds.type(WorldType.NORMAL);
            //Проверяем есть ли аргументы
            if(args.length == 1){
                worlds.seed(Long.parseLong(worldSeed));

            }
            //Создание мира
            world = worlds.createWorld();
            Location lo = new Location(Bukkit.getWorld(worldSeed), 0,90,0);
            //Телепортируем игрока в мир
            player.getPlayer().teleport(lo);
            for(int i = 20;i<140;i++){
                Bukkit.getWorld(worldSeed).getBlockAt(0,i,0).setType(Material.GLOWSTONE);
            }
            player.sendMessage(ChatColor.GREEN + "Мир с сидом " + world.getSeed() + " загружен");
        }

        return true;
    }

}
