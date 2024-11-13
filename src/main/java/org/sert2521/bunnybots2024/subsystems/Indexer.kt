package org.sert2521.bunnybots2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import com.revrobotics.jni.CANSparkMaxJNI
import edu.wpi.first.wpilibj2.command.Subsystem;
import org.sert2521.bunnybots2024.ElectricIDs

object Indexer : Subsystem {
    private val motor = CANSparkMax(ElectricIDs.INDEXER_MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless)
    private val encoder = motor.encoder

    init {
        motor.idleMode = CANSparkBase.IdleMode.kBrake
        motor.setSmartCurrentLimit(30)
        motor.inverted = false
    }


    fun setMotor(speed: Double) {
        motor.set(speed)
    }

    fun stopMotor(){
        motor.stopMotor()
    }

    fun getEncoderValue(){

    }

}