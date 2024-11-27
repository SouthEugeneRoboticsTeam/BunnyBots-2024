package org.sert2521.bunnybots2024.commands

import edu.wpi.first.math.controller.ArmFeedforward
import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.TunedConstants
import org.sert2521.bunnybots2024.subsystems.WristSubsystem

class SetWristCommand : Command() {
    private var wristAngle = WristSubsystem.getRadians()
    private var feedForward = ArmFeedforward(TunedConstants.WRIST_S, TunedConstants.WRIST_G, TunedConstants.WRIST_V, TunedConstants.WRIST_A)

    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(WristSubsystem)
    }

    override fun initialize() {}

    override fun execute() {}

    override fun isFinished(): Boolean {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false
    }

    override fun end(interrupted: Boolean) {}
}
