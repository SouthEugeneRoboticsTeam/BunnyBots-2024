package org.sert2521.bunnybots2024.commands

import edu.wpi.first.math.MathUtil
import edu.wpi.first.math.controller.ArmFeedforward
import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.TunedConstants
import org.sert2521.bunnybots2024.subsystems.Wrist
import kotlin.math.PI

//Need to input the goal angle of the wrist
class SetWrist(private val goal: Double) : Command() {
    private var wristAngle = Wrist.getWrappedAngle()
    private var feedForward = ArmFeedforward(TunedConstants.WRIST_S, TunedConstants.WRIST_G, TunedConstants.WRIST_V, TunedConstants.WRIST_A)
    private var pid = /*Profiled*/PIDController(TunedConstants.WRIST_P, TunedConstants.WRIST_I, TunedConstants.WRIST_D/*, TunedConstants.WRIST_TRAP*/)

    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(Wrist)
    }

    override fun initialize() {
        wristAngle = Wrist.getWrappedAngle()
        pid.reset()
    }

//Gets the wrist where it needs to go, hopefully
    override fun execute() {
        wristAngle = Wrist.getWrappedAngle()

        //Calculates voltage needed to get the wrist to its goal angle, then sets the voltage accordingly
        val pidResult = pid.calculate(wristAngle, goal)
        val feedforwardResult = feedForward.calculate(wristAngle, /*pid.setpoint.velocity*/ 0.0)
        Wrist.setVoltage(feedforwardResult + pidResult)
    }

//Returns false because the command should always be running, keeping the wrist in place
    override fun isFinished(): Boolean {
        return false;
    }

}
