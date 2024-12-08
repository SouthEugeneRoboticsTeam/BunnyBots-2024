package org.sert2521.bunnybots2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj2.command.Subsystem
import org.sert2521.bunnybots2024.ElectricIDs

object Intake: Subsystem {
    val intakeMotor = CANSparkMax(ElectricIDs.INTAKE_ID, CANSparkLowLevel.MotorType.kBrushless)
    init{
        intakeMotor.idleMode = CANSparkBase.IdleMode.kBrake
        intakeMotor.setSmartCurrentLimit(30)
        intakeMotor.inverted = false
    }
    fun setMotor(speed:Double) {
        intakeMotor.set(speed)
    }
    fun stop(){
        intakeMotor.stopMotor()
    }
}