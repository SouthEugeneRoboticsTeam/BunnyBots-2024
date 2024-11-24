package org.sert2521.bunnybots2024.commands

import edu.wpi.first.wpilibj2.command.Command
import org.sert2521.bunnybots2024.TunedConstants
import org.sert2521.bunnybots2024.subsystems.Fan

class SetServo() : Command() {

    private val upAngle = TunedConstants.FAN_UP_ANGLE
    private val downAngle = TunedConstants.FAN_DOWN_ANGLE
    private var servoAngle = 0.0

    init {
        addRequirements(Fan)
    }

    override fun initialize() {
        servoAngle = Fan.getServoAngle()
    }

    fun setUp() {
        Fan.setServo(upAngle)
    }

    fun setDown() {
        Fan.setServo(downAngle)
    }
}