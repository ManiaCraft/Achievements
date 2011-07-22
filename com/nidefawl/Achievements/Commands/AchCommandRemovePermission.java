package com.nidefawl.Achievements.Commands;

import com.nidefawl.Achievements.Achievements;
import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.data.User;
import org.anjocaido.groupmanager.dataholder.OverloadedWorldHolder;
import org.anjocaido.groupmanager.dataholder.worlds.WorldsHolder;
import org.bukkit.entity.Player;

public class AchCommandRemovePermission
{
  protected static boolean handleCommand(Achievements plugin, Player player, String[] s)
  {
    if (s.length < 2) {
      Achievements.LogError("Bad command (not enough arguments) correct is: removepermission <permissions-name>");
      return false;
    }
    if (plugin.groupManager() != null) {
      User grpUser = plugin.groupManager().getWorldsHolder().getWorldData(player).getUser(player.getName());
      if (grpUser != null) {
        grpUser.removePermission(s[1]);
      }
      return true;
    }
    Achievements.LogError("removepermission is only supported when GroupManager is installed - http://bit.ly/GroupManager");
    return true;
  }
}