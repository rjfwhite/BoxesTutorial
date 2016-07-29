package improbable.natures

import improbable.bot.BotMovementState
import improbable.corelib.natures.{BaseNature, NatureApplication, NatureDescription}
import improbable.corelibrary.transforms.TransformNature
import improbable.math.{Vector3d, Vector3f}
import improbable.papi.entity.behaviour.EntityBehaviourDescriptor
import improbable.util.EntityPrefabs.BOT

object BotNature extends NatureDescription {

  override def dependencies: Set[NatureDescription] = Set(
    BaseNature,
    TransformNature,
    ColoredNature
  )

  override def activeBehaviours: Set[EntityBehaviourDescriptor] = Set.empty

  def apply(initialPosition: Vector3d): NatureApplication = {
    application(
      states = Seq(BotMovementState(0f, Vector3f.zero)),
      natures = Seq(
        BaseNature(entityPrefab = BOT),
        TransformNature(globalPosition = initialPosition),
        ColoredNature(color = java.awt.Color.white))
    )
  }

}
