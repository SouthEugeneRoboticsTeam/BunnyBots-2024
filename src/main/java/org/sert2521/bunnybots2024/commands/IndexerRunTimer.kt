package org.sert2521.bunnybots2024.commands

import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.subsystems.Indexer

class IndexerRunTimer : Command() {
    var timer = 10
    var isRunning = true


    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(Indexer)
    }

    override fun initialize() {}

    override fun execute() {
        if (Indexer.getBeamBreak() && timer==0){
            timer = 10
        }
        else {
            timer -= 1
        }
        if (timer != 0){
            Indexer.setMotor(0.3)
        }
        else {
            Indexer.stopMotor()
        }
    }

    override fun isFinished(): Boolean {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false
    }

    override fun end(interrupted: Boolean) {}
}
