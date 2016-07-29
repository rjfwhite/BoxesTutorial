package improbable.behaviours.bot

import improbable.bot.BotMovementStateWriter
import improbable.math.Vector3f
import improbable.papi.entity.{Entity, EntityBehaviour}
import improbable.papi.world.World

import scala.concurrent.duration._

class MoveRandomlyBehaviour(entity: Entity, world: World, botMovementStateWriter: BotMovementStateWriter) extends EntityBehaviour {

  val INTENSITY = 12f
  val rand = scala.util.Random

  override def onReady(): Unit = {
    botMovementStateWriter.update
      .movementIntensity(INTENSITY)
      .finishAndSend()

    world.timing.every(1.seconds) {
      botMovementStateWriter.update
        .movementDirection(Vector3f(rand.nextFloat() - 0.5f, 0f, rand.nextFloat() - 0.5f).normalised)
        .finishAndSend()
    }
  }
}