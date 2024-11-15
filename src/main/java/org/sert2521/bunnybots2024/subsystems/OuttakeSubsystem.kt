package org.sert2521.bunnybots2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.sert2521.bunnybots2024.ElectricIDs

object OuttakeSubsystem : SubsystemBase() {
    val outtakeMotor = CANSparkMax(ElectricIDs.OUTTAKE_ID, CANSparkLowLevel.MotorType.kBrushless)

    init {
        outtakeMotor.idleMode = CANSparkBase.IdleMode.kBrake
        outtakeMotor.setSmartCurrentLimit(30)
        outtakeMotor.inverted = false
    }

    fun setMotor(speed:Double) {
        outtakeMotor.set(speed)
    }

    fun stop() {
        outtakeMotor.stopMotor()
    }
}