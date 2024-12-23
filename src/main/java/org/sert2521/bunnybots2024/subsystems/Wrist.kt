package org.sert2521.bunnybots2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.math.MathUtil
import edu.wpi.first.math.MathUtil.clamp
import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.wpilibj.DutyCycleEncoder
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.sert2521.bunnybots2024.ElectricIDs
import org.sert2521.bunnybots2024.ElectricIDs.DUTY_ENCODER_ID
import org.sert2521.bunnybots2024.PhysicalConstants
import kotlin.math.PI
import kotlin.math.max
import kotlin.math.min

object Wrist : SubsystemBase() {
    val wristMotor = CANSparkMax(ElectricIDs.WRIST_ID, CANSparkLowLevel.MotorType.kBrushless)
    val absEncoder = DutyCycleEncoder(DUTY_ENCODER_ID)

    init {
        //sets up motor
        wristMotor.idleMode = CANSparkBase.IdleMode.kCoast
        wristMotor.setSmartCurrentLimit(35)
        wristMotor.inverted = false


        //sets up encoder
        absEncoder.distancePerRotation = 2.79
        absEncoder.positionOffset = PhysicalConstants.WRIST_ENCODER_OFFSET
    }

    override fun periodic() {
        //println(wristMotor.appliedOutput)
    }

    //Adjusts voltage of motor
    fun setVoltage(voltage: Double) {
        wristMotor.setVoltage(clamp(voltage, -12.0, 12.0))
        //println(voltage)
    }

    //Resets Encoder
    fun rezeroEncoder(){
        absEncoder.reset()
    }

    //Adjusts the current limit of motor
    fun setCurrentLimit(current:Int){
        wristMotor.setSmartCurrentLimit(current)
    }

    //Returns the angle of the wrist
    fun getRadians():Double{
        return absEncoder.distance
    }

    fun getRotation(): Rotation2d {
        return Rotation2d(absEncoder.distance)
    }

    fun getWrappedAngle(): Double {
        return MathUtil.inputModulus(absEncoder.distance, -PI/2, 3*PI/2)
    }

    //Stops the wrist motor
    fun stop() {
        wristMotor.stopMotor()
    }
}