package org.sert2521.bunnybots2024.commands

import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.subsystems.TailSubsystem

class TailStayStillCommand : Command() {
    private val tailSubsystem = TailSubsystem


    init {
        addRequirements(tailSubsystem)
    }

    override fun initialize() {
        tailSubsystem.setVoltage(0.0)
    }

    override fun execute() {}

    override fun isFinished(): Boolean {
        return false
    }

    override fun end(interrupted: Boolean) {
        if (!interrupted) { //
            tailSubsystem.stopMotor()
        }
    }
}
