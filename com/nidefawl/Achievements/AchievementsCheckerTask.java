package com.nidefawl.Achievements;

public class AchievementsCheckerTask
  implements Runnable
{
  private Achievements achievements;

  public AchievementsCheckerTask(Achievements plugin)
  {
    this.achievements = plugin;
  }

  public void run() {
    this.achievements.checkAchievements();
  }
}