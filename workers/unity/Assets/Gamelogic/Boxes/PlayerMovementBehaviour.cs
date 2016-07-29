using Improbable.Math;
using Improbable.Player.Controls;
using Improbable.Player.Physical;
using Improbable.Unity.Common.Core.Math;
using Improbable.Unity.Visualizer;
using UnityEngine;

namespace Gamelogic.Visualizers
{
    public class PlayerMovementBehaviour : MonoBehaviour
    {
        [Require] protected PlayerControlsStateReader playerControlsStateReader;
        [Require] protected PlayerStateReader playerStateReader;
        private Rigidbody cachedRigidbody;
        private Vector3 movementDirection;

        protected virtual void Awake()
        {
            cachedRigidbody = GetComponent<Rigidbody>();
        }

        protected virtual void OnEnable()
        {
            playerControlsStateReader.MovementDirectionUpdated += SetMovementDirection;
        }

        protected virtual void OnDisable()
        {
            playerControlsStateReader.MovementDirectionUpdated -= SetMovementDirection;
        }

        protected void SetMovementDirection(Vector3d direction)
        {
            movementDirection = direction.ToUnityVector();
        }

        protected virtual void  FixedUpdate()
        {
            cachedRigidbody.AddForce(movementDirection * playerStateReader.ForceMagnitude);	
        }
    }
}
