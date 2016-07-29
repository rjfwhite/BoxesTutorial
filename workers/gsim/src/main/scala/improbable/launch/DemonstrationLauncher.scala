package improbable.launch

import improbable.dapi.{LaunchConfig, Launcher}

class DemonstrationLauncher(launchConfig: LaunchConfig) {

  val options = Seq(
    "--game_world_edge_length=5000",
    "--entity_activator=improbable.corelib.entity.CoreLibraryEntityActivator",
    "--resource_based_config_name=one-gsim-one-jvm"
  )
  Launcher.startGame(launchConfig, options: _*)

}

object SpatialOSLauncherWithManualWorkers extends DemonstrationLauncher(ManualEngineStartupLaunchConfig) with App

object SpatialOSLauncherWithAutomaticWorkers extends DemonstrationLauncher(AutomaticEngineStartupLaunchConfig) with App
