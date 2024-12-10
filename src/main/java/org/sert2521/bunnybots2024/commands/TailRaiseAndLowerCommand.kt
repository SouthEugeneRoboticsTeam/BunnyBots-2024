package org.sert2521.bunnybots2024.commands


import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.TunedConstants
import org.sert2521.bunnybots2024.subsystems.TailSubsystem


class TailRaiseAndLowerCommand(private val setPoint: Double) : Command() {
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
        tailPid.setpoint = setPoint

        if (setPoint > tailSubsystem.getAngleRads()) {
            tailSubsystem.setInversion(false)
        }
        else if (setPoint < tailSubsystem.getAngleRads()) {
            tailSubsystem.setInversion(true)
        }
    }

    override fun execute() {
        val nextVoltage = tailPid.calculate(tailSubsystem.getAngleRads())
        tailSubsystem.setVoltage(nextVoltage)
    }

    override fun isFinished(): Boolean {
        return tailPid.atSetpoint()
    }

    override fun end(interrupted: Boolean) {
        // not stopping motor because TailStayStillCommand() should hold the motor in place
        // when the tail is not being raised or lowered.
    }
}
