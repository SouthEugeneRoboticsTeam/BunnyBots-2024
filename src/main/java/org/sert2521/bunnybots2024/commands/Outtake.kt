package org.sert2521.bunnybots2024.commands

import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.subsystems.Indexer

class Outtake : Command() {


    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(Indexer)
    }

    override fun initialize() {}

    override fun execute() {
        //sets the indexer speed to 0.3 when a balloon is in the beam break and stops it when there isn't
        Indexer.setMotor(0.3)
    }

    override fun isFinished(): Boolean {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false
    }

    override fun end(interrupted: Boolean) {
        Indexer.stopMotor()
    }
}
