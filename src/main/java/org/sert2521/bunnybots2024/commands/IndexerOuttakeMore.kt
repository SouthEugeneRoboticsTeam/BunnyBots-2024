package org.sert2521.bunnybots2024.commands

import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.subsystems.Indexer
import org.sert2521.bunnybots2024.subsystems.Intake

class IndexerOuttakeMore : Command() {
    private val indexer = Indexer


    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(indexer, Intake)
    }

    override fun initialize() {
        Indexer.setMotor(0.35)
        Intake.setMotor(1.0)
    }

    override fun execute() {
        Indexer.setMotor(0.35)
        Intake.setMotor(1.0)
    }

    override fun isFinished(): Boolean {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false
    }

    override fun end(interrupted: Boolean) {
        Intake.stop()
        Indexer.stopMotor()
    }
}
