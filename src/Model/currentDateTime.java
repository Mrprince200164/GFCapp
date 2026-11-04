package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class currentDateTime {

    private final SimpleDateFormat dateFormatter;

    
    public currentDateTime() {
        this.dateFormatter = new SimpleDateFormat("HH:mm:ss a | yyyy-MMM-dd");
    }
   
    private String getCurrentFormattedDateTime() {
        Date currentDateTime = new Date(); 
        return dateFormatter.format(currentDateTime); 
    }
    
    public void startRealTimeUpdate(JLabel label) {
        Runnable updateTask = () -> {
            while (true) {
                String currentTime = getCurrentFormattedDateTime();
                label.setText(currentTime); 
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

       
        Thread updateThread = new Thread(updateTask);
        updateThread.start();
    }
}
