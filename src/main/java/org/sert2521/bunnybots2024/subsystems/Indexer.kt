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
        //sets the motor to brake, have a limit of 30, and not be inverted
        indexerMotor.idleMode = CANSparkBase.IdleMode.kBrake
        indexerMotor.setSmartCurrentLimit(30)
        indexerMotor.inverted = false

        //will run the IndexerRun command as the default
        this.defaultCommand = IndexerRun()
    }


    //doubles speed
    fun setMotor(speed: Double) {
        indexerMotor.set(speed)
    }

    //stops motor
    fun stopMotor(){
        indexerMotor.stopMotor()
    }

    //gets beam break
    fun getBeamBreak():Boolean{
        return false
    }

    /*fun getEncoderValue(){

    }*/

}