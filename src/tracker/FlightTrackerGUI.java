package tracker;
import javax.swing.*;

/**
 * Main GUI class for the FlightTracker application.
 */
public class FlightTrackerGUI extends JFrame {
    
    /**
     * FlightTracker GUI constructor.
     */
    public FlightTrackerGUI() {
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
    }
}
