package org.sert2521.bunnybots2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj.DutyCycleEncoder
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.sert2521.bunnybots2024.ElectricIDs
import org.sert2521.bunnybots2024.ElectricIDs.DUTY_ENCODER_ID
import org.sert2521.bunnybots2024.PhysicalConstants
import kotlin.math.PI

object WristSubsystem : SubsystemBase() {
    val wristMotor = CANSparkMax(ElectricIDs.WRIST_ID, CANSparkLowLevel.MotorType.kBrushless)
    val absEncoder = DutyCycleEncoder(DUTY_ENCODER_ID)

    init {
        wristMotor.idleMode = CANSparkBase.IdleMode.kBrake
        wristMotor.setSmartCurrentLimit(35)
        wristMotor.inverted = false;
        absEncoder.distancePerRotation = 2*PI
        absEncoder.positionOffset = PhysicalConstants.WRIST_ENCODER_OFFSET
    }

    fun setVoltage(voltage: Double) {
        wristMotor.setVoltage(voltage)
    }

    fun rezeroEncoder(){
        absEncoder.reset()
    }

    fun getEncoder():Double{
        //println(absEncoder.get())
        return absEncoder.distance
    }

    fun setCurrentLimit(first:Int){
        wristMotor.setSmartCurrentLimit(first)
    }

    fun getRadians():Double{
        return absEncoder.distance
    }

    fun stop() {
        wristMotor.stopMotor();
    }
}