package org.sert2521.bunnybots2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sert2521.bunnybots2024.ElectricIDs

object TailSubsystem : SubsystemBase() {
    private val tailMotor = CANSparkMax(ElectricIDs.TAIL_ID, CANSparkLowLevel.MotorType.kBrushless)
    private val tailEncoder = tailMotor.encoder
    /*
    I'm not sure if using a relative encoder is the right move here
    because i'm relying on the up and down commands finishing at the
    same angles every time. I imagine that can lead to a compounding of slight
    errors over time.
     */
    private const val POSITION_CONVERSION_FACTOR = Math.PI/24

    init {
        tailMotor.setSmartCurrentLimit(40)
        tailMotor.idleMode = CANSparkBase.IdleMode.kBrake
//        setInversion(false)

        tailEncoder.setPositionConversionFactor(POSITION_CONVERSION_FACTOR)

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