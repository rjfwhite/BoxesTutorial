using Improbable.Bot;
using Improbable.Math;
using Improbable.Unity.Common.Core.Math;
using Improbable.Unity.Visualizer;
using UnityEngine;

namespace Gamelogic.Visualizers
{
    public class MoveRandomlyBehaviour : MonoBehaviour
    {
        [Require] protected BotMovementStateReader BotMovementStateReader;

        protected Rigidbody CachedRigidbody;
        protected Vector3 ForceToApply;

        protected virtual void Awake()
        {
            CachedRigidbody = GetComponent<Rigidbody>();
            ForceToApply = Vector3.zero;
        }

        protected virtual void OnEnable()
        {
            BotMovementStateReader.MovementDirectionUpdated += SetForce;
        }

        protected virtual void OnDisable()
        {
            BotMovementStateReader.MovementDirectionUpdated -= SetForce;
        }

        protected virtual void FixedUpdate()
        {
            CachedRigidbody.AddForce(ForceToApply, ForceMode.Force);
        }

        protected virtual void SetForce(Vector3f direction)
        {
            ForceToApply = direction.ToUnityVector()*BotMovementStateReader.MovementIntensity;
        }
    }
}
