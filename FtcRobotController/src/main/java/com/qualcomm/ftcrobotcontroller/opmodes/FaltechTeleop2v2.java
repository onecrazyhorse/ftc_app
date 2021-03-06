/* Copyright (c) 2014 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * TeleOp Mode
 * <p>
 * Enables control of the robot via the gamepad
 */
public class FaltechTeleop2v2 extends OpMode {
	int MtrsLeftPosition=0, MtrsRightPosition=0;
	DcMotor LiftRight;
	DcMotor LiftLeft;
	DcMotor MtrsLeft;
	DcMotor MtrsRight;
	DcMotor Elevator;
	DcMotor Spinners;
	Servo   SrvSlide;
	double slide_Max = 900;
	double slide_Min = -900;
	double slide_start = 0;
	public FaltechTeleop2v2() {


	}

	/*
	 * Code to run when the op mode is first enabled goes here
	 * 
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
	 */
	@Override
	public void init() {
		LiftRight = hardwareMap.dcMotor.get("LiftRight");
		LiftLeft = hardwareMap.dcMotor.get("LiftLeft");
		MtrsLeft = hardwareMap.dcMotor.get("MtrsLeft");
		MtrsRight = hardwareMap.dcMotor.get("MtrsRight");
		//Spinners = hardwareMap.dcMotor.get("Spinner");
		Elevator = hardwareMap.dcMotor.get("Elevator");
		SrvSlide = hardwareMap.servo.get(" SrvSlide");
		boolean Elevator = false;
	}

	/*
	 * This method will be called repeatedly in a loop
	 * 
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#run()
	 */
	@Override
	public void loop() {
		boolean  SrvSlide = gamepad2.right_bumper;
		float MtrsLeftFloat = -gamepad1.left_stick_y;
		float MtrsRightFloat = gamepad1.right_stick_y;
		float LiftRightFloat = gamepad2.right_stick_y;
		float LiftLeftFloat = -gamepad2.right_stick_y;
		MtrsRight.setPower(MtrsRightFloat);
		MtrsLeft.setPower(MtrsLeftFloat);
		LiftLeft.setPower(LiftLeftFloat);
		LiftRight.setPower(LiftRightFloat);
		MtrsLeftPosition = MtrsLeft.getCurrentPosition();
		MtrsRightPosition = MtrsRight.getCurrentPosition();
		telemetry.addData("Right Position",MtrsRightPosition);
		telemetry.addData("Left Position",MtrsLeftPosition);
		telemetry.addData("Right Speed",gamepad1.right_stick_y);
		telemetry.addData("Left Speed",gamepad1.left_stick_y);

	}

	/*
	 * Code to run when the op mode is first disabled goes here
	 * 
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
	 */
	@Override
	public void stop() {

	}

	}


