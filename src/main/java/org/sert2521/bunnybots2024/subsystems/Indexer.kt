package org.sert2521.bunnybots2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import com.revrobotics.ColorSensorV3
import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.I2C
import edu.wpi.first.wpilibj2.command.Subsystem;
import org.sert2521.bunnybots2024.ElectricIDs
import org.sert2521.bunnybots2024.commands.IndexerRun

object Indexer : Subsystem {
    private val indexerMotor = CANSparkMax(ElectricIDs.INDEXER_MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless)
    private val beamBreak = DigitalInput(ElectricIDs.INDEXER_BEAM_BREAK_ID)
    private val colorSensor = ColorSensorV3(I2C.Port.kOnboard)

    init {
        indexerMotor.idleMode = CANSparkBase.IdleMode.kBrake
        indexerMotor.setSmartCurrentLimit(30)
        indexerMotor.inverted = false

        this.defaultCommand = IndexerRun()
    }


    fun setMotor(speed: Double) {
        indexerMotor.set(speed)
    }

    fun stopMotor(){
        indexerMotor.stopMotor()
    }

    fun getBeamBreak():Boolean{
        return !beamBreak.get()
    }

    /*fun getEncoderValue(){

    }*/

}