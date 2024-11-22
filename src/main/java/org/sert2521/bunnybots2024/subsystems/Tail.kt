package org.sert2521.bunnybots2024.subsystems

import com.revrobotics.CANSparkBase
import com.revrobotics.CANSparkLowLevel
import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.sert2521.bunnybots2024.ElectricIDs

object TailSubsystem : SubsystemBase() {
    private val tailMotor = CANSparkMax(ElectricIDs.TAIL_ID, CANSparkLowLevel.MotorType.kBrushless)

    init {
        tailMotor.setSmartCurrentLimit(10)
        tailMotor.idleMode = CANSparkBase.IdleMode.kBrake
        tailMotor.inverted = false
    }




}