package org.sert2521.bunnybots2024.commands


import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.TunedConstants
import org.sert2521.bunnybots2024.subsystems.TailSubsystem


class TailDownCommand : Command() {
    private val tailSubsystem = TailSubsystem
    private val tailPid = PIDController(
        TunedConstants.TAIL_P,
        TunedConstants.TAIL_I,
        TunedConstants.TAIL_D
    )

    init {
        addRequirements(tailSubsystem)
    }

    override fun initialize() {
        tailSubsystem.setInversion(false)
        tailPid.setpoint = Math.PI / 2 /* assuming that the only position the tail can start this command
                                        * in is the raised position. */
        tailPid.setTolerance(0.01)
    }

    override fun execute() {
        val calculate = tailPid.calculate(tailSubsystem.getAngleRads())
        tailSubsystem.setVoltage(calculate)
    }

    override fun isFinished(): Boolean {
        return tailPid.atSetpoint()
    }

    override fun end(interrupted: Boolean) {
        tailSubsystem.stopMotor()
    }
}
