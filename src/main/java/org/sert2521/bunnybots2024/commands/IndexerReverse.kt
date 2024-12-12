package org.sert2521.bunnybots2024.commands

import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.subsystems.Indexer

class IndexerReverse : Command() {
    private val indexer = Indexer


    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(indexer)
    }

    override fun initialize() {}

    override fun execute() {
        Indexer.setMotor(-0.3)
    }

    override fun isFinished(): Boolean {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false
    }

    override fun end(interrupted: Boolean) {
        Indexer.stopMotor()
    }
}
