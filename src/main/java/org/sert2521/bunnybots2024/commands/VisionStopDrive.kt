package org.sert2521.bunnybots2024.commands

import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.TunedConstants
import org.sert2521.bunnybots2024.subsystems.Drivetrain
import kotlin.math.absoluteValue

class VisionStopDrive : Command() {

    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements()
    }

    override fun initialize() {

    }

    override fun execute() {}

    override fun isFinished(): Boolean {
        if (Drivetrain.getTx().absoluteValue < TunedConstants.VISION_AUTO_TOLERANCE) {
            return true
        } else {
            return false
        }
    }

    override fun end(interrupted: Boolean) {}
}
