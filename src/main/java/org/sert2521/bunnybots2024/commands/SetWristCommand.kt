package org.sert2521.bunnybots2024.commands

import edu.wpi.first.math.controller.ArmFeedforward
import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.RuntimeConstants
import org.sert2521.bunnybots2024.TunedConstants
import org.sert2521.bunnybots2024.subsystems.WristSubsystem
import kotlin.math.PI

class SetWristCommand(private val goal: Double) : Command() {
    private var wristAngle = WristSubsystem.getRadians()
    private var feedForward = ArmFeedforward(TunedConstants.WRIST_S, TunedConstants.WRIST_G, TunedConstants.WRIST_V, TunedConstants.WRIST_A)
    private var pid = PIDController(TunedConstants.WRIST_P, TunedConstants.WRIST_I, TunedConstants.WRIST_D)

    private var done = false

    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(WristSubsystem)
    }

    override fun initialize() {
        wristAngle = WristSubsystem.getRadians()
        pid.reset()
        RuntimeConstants.wristSetPoint=goal
    }

    override fun execute() {
        done = false
        wristAngle = WristSubsystem.getRadians()
        val pidResult = pid.calculate(wristAngle+2*PI, goal+2*PI)
        val feedforwardResult = feedForward.calculate(wristAngle, pid.setpoint)
        WristSubsystem.setVoltage(feedforwardResult + pidResult)

        if(WristSubsystem.getRadians() > goal-TunedConstants.WRIST_ANGLE_TOLERANCE && WristSubsystem.getRadians() > goal + TunedConstants.WRIST_ANGLE_TOLERANCE) {
            done = true
        }
    }

    override fun isFinished(): Boolean {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return done
    }

    override fun end(interrupted: Boolean) {
        if (interrupted) {
            RuntimeConstants.wristSetPoint
        }
    }
}
