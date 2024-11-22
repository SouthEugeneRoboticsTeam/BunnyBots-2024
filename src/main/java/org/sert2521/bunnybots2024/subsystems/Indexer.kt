package org.sert2521.bunnybots2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sert2521.bunnybots2024.ElectricIDs

object Indexer : SubsystemBase() {
    private val beamBreak = DigitalInput(ElectricIDs.INDEXER_BEAM_BREAK_ID)
    private val indexerMotor = CANSparkMax(ElectricIDs.INDEXER_MOTOR_ID,CANSparkLowLevel.MotorType.kBrushless)
    init{
        indexerMotor.setSmartCurrentLimit(30)
        indexerMotor.inverted = false
        indexerMotor.idleMode = CANSparkBase.IdleMode.kBrake
    }
    fun setSpeed(speed:Double){
        indexerMotor.set(speed)
    }
    fun stop(){
        indexerMotor.stopMotor()
    }
    fun getBeamBreak():Boolean{
        return !beamBreak.get()
    }
}

