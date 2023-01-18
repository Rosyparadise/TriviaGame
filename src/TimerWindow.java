import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author Eleni Navrozidou
 * @author Evangelos Chalkias
 * @version 2.0
 * @since 2020
 *
 * This class is the timer being displayed in the timer mode.
 *
 *
 */
class TimerWindow extends JFrame implements ActionListener{
    /**
     * start is the second it starts.
     */
    private int start = 1;
    /**
     * label is the label displaying the countdown timer.
     */
    private JLabel label;
    /**
     * is the timer.
     */
    private Timer swingtimer;

    /**
     * Sets the timer in 5 seconds.
     */
    public TimerWindow(){
        start += 5;
        setTitle("Timer Window");
        setLayout(new FlowLayout());
        setSize(200,80);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    /**
     * Starts the timer.
     */
    public void setTimer(){
        label = new JLabel("You have 5 seconds to answer.");
        add(label);
        swingtimer = new Timer(1000,this);
        swingtimer.start();
    }

    public void actionPerformed(ActionEvent evnt){
        start--;
        if(start>=1){
            label.setText("Time : "+start); //changing the label of button as the timer decreases
        }else{
            label.setText("Timeout!");
            swingtimer.stop();
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

    /**
     * Ends the timer.
     */
    public void endTimer(){this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));}

}
