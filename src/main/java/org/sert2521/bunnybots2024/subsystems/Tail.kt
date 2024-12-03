package org.sert2521.bunnybots2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sert2521.bunnybots2024.ElectricIDs

object TailSubsystem : SubsystemBase() {
    private val tailMotor = CANSparkMax(ElectricIDs.TAIL_ID, CANSparkLowLevel.MotorType.kBrushless)
    private val tailEncoder = tailMotor.encoder

    init {
        tailMotor.setSmartCurrentLimit(40)
        tailMotor.idleMode = CANSparkBase.IdleMode.kBrake
        tailMotor.inverted = false

        tailEncoder.setPositionConversionFactor(Math.PI/24) // conversion factor pi/24

    }

    fun setVoltage(voltage: Double) {
        tailMotor.setVoltage(voltage)
    }

    fun stopMotor() {
        tailMotor.stopMotor()
    }

    fun getAngleRads(): Double {
        return tailEncoder.position
    }

    fun getVelocity(): Double {
        return tailEncoder.velocity
    }
} //test