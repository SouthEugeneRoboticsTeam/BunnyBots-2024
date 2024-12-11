package org.sert2521.bunnybots2024.commands

import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.subsystems.Indexer

class IndexerStop : Command() {


    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(Indexer)
    }

    override fun initialize() {
        Indexer.stopMotor()
    }

    override fun execute() {
        Indexer.stopMotor()
    }

    override fun isFinished(): Boolean {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false
    }

    override fun end(interrupted: Boolean) {
        Indexer.stopMotor()
    }
}
