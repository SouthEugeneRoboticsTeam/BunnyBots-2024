package org.sert2521.bunnybots2024.commands

import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.subsystems.Intake

class IntakeRun: Command()
{
    private val intake = Intake


    init
    {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(intake)
    }

    override fun initialize() {
        Intake.setMotor(1.0)
    }

    override fun execute() {
        Intake.setMotor(1.0)

    }

    override fun isFinished(): Boolean {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false
    }

    override fun end(interrupted: Boolean) {
        Intake.stop()
    }
}
