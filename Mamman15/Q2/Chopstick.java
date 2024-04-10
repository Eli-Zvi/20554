/**
 * Student Name: Ilay Zvi
 *  Date: 5/2/2023
 *  Class Name: ChopStick
 */
package com.example.mamman15q2;

import javafx.scene.shape.Line;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

    private Line chopStick;
    private Lock lock = new ReentrantLock();

    public Chopstick(Line chopStick)
    {
        this.chopStick = chopStick;
    }

    /**
     * changes the visibility of the chopstick in the GUI
     * @param vis true to show the chopstick false otherwise
     */
    public void setStickVis(boolean vis)
    {
        chopStick.setVisible(vis);
    }

    /**
     * attempt to lock the chopstick and pick it up if successful
     */
    public boolean takeChopStick()
    {
        return lock.tryLock();
    }

    /**
     * puts down stick by unlocking the lock on the chopstick
     */
    public void putDownStick()
    {
        lock.unlock();
    }
}
