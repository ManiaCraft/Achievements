package com.nidefawl.Achievements.Commands;

import com.nidefawl.Achievements.Achievements;
import net.minecraft.server.MinecraftServer;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Player;

public class AchCommandNativeCommand
{
  protected static boolean handleCommand(Achievements plugin, Player player, String[] s)
  {
    if (s[0].length() == 1) return false;
    CraftServer cs = (CraftServer)plugin.getServer();
    String command = "";
    for (String arg : s) {
      if (command.length() > 0) {
        if ("*".equals(arg)) arg = player.getName();
        command = command + " " + arg;
      }
      else {
        command = command + arg.substring(1);
      }
    }
    Achievements.LogError("executing Console-Command '" + command + "'");
    if (!cs.dispatchCommand(cs.getServer().console, command)) {
      Achievements.LogError("Could not execute Console-Command '" + command + "'");
      return false;
    }
    return true;
  }
}