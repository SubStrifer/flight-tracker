package tracker;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import javax.swing.*;

/**
 * Main GUI class for the FlightTracker application.
 */
public class FlightTrackerGUI extends JFrame {
    
    /**
     * FlightTracker GUI constructor.
     */
    public FlightTrackerGUI(FlightManager manager) {
        setTitle("FlightTracker");

        // Close program when window closes
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Add elements
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Label");
        JButton button = new JButton("Button");
        panel.add(label);
        panel.add(button);
        add(panel);

        pack();
        setVisible(true);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
              manager.generateReport();
            }
          });
    }
}
