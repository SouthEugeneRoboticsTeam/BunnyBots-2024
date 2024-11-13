package org.sert2521.bunnybots2024.subsystems

import edu.wpi.first.wpilibj.PWM
import edu.wpi.first.wpilibj.Servo
import edu.wpi.first.wpilibj2.command.Subsystem
import org.sert2521.bunnybots2024.ElectricIDs


object Fan : Subsystem {

    private val fan = PWM(ElectricIDs.FAN_PWM_CHANNEL)
    private val fanServo = Servo(ElectricIDs.FAN_SERVO_CHANNEL)

    init {

    }



}