package org.firstinspires.ftc.teamcode.EncoderPositioning;

public class EncoderPosition implements Runnable {

    //Thead run condition
    private boolean isRunning = true;

    public EncoderPosition() [

    }
    /**
     * Runs the thread
     */
    @Override
    public void run() {
        while(isRunning) {
            positionUpdate();
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Stops the position update thread
     */
    public void stop(){ isRunning = false; }

}
