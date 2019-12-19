package org.firstinspires.ftc.teamcode.testing.MuiltthreadTest;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.SkyStone6547Qualifter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by Drew from 11874 on 12/19/2019.
 */
public class testCompletableFuture extends LinearOpMode {

    SkyStone6547Qualifter bot;

    @Override
    public void runOpMode() throws InterruptedException, ExecutionException {

        bot = new SkyStone6547Qualifter(this);

        telemetry.log().add("ready to start");
        waitForStart();

        CompletableFuture<Void> leftBack = CompletableFuture.runAsync(() -> bot.runMotor(bot.LeftBack ,.4, 1000));
        CompletableFuture<Void> rightBack = CompletableFuture.runAsync(() -> bot.runMotor(bot.RightBack ,.4, 1000));
        CompletableFuture<Void> leftFront = CompletableFuture.runAsync(() -> bot.runMotor(bot.LeftFront ,.4, 1000));
        CompletableFuture<Void> rightFront = CompletableFuture.runAsync(() -> bot.runMotor(bot.RightFront ,.4, 1000));

        CompletableFuture<Void> everything = CompletableFuture.allOf(leftBack,rightBack,leftFront,rightFront);

        while (!everything.isDone() && opModeIsActive())
        {
            bot.outputTelemetry();
        }

    }
}
