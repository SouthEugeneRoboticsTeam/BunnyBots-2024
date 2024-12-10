package org.sert2521.bunnybots2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sert2521.bunnybots2024.ElectricIDs
import org.sert2521.bunnybots2024.commands.TailStayStillCommand

object TailSubsystem : SubsystemBase() {
    private val tailMotor = CANSparkMax(ElectricIDs.TAIL_ID, CANSparkLowLevel.MotorType.kBrushless)
    private val tailEncoder = tailMotor.encoder

    init {
        tailMotor.setSmartCurrentLimit(40)
        tailMotor.idleMode = CANSparkBase.IdleMode.kBrake

        tailEncoder.setPositionConversionFactor(Math.PI/24)

        // if inversion is false that means the tail was lowered when the motor was powered off
        if (!tailEncoder.inverted) {
            tailEncoder.setPosition(Math.PI/2)
        }

    }

    override fun setDefaultCommand(defaultCommand: Command?) {
        super.setDefaultCommand(TailStayStillCommand())
    }

    fun setVoltage(voltage: Double) {
        tailMotor.setVoltage(voltage)
    }

    fun setInversion(inverted: Boolean) {
        tailMotor.inverted = inverted
    }

    fun stopMotor() {
        tailMotor.stopMotor()

    }

    fun getAngleRads(): Double {
        return tailEncoder.position
    }



//    fun getVelocity(): Double {
//        return tailEncoder.velocity
//    }
}