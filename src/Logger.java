import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private String logFileName = "myLogFile.log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private static final Logger INSTANCE = new Logger();
    public static final Logger getInstance(){
        return INSTANCE;
    }

    private Logger() {
        File logFile = new File(logFileName);
        if (!logFile.isFile()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Logging to: " + logFile.getAbsolutePath());
    }

    public void log(String message) {
        try {
            String formattedDate = LocalDateTime.now().format(formatter);
            String fullMessage = System.lineSeparator() + formattedDate + " - " + message;

            // NOTE, this is not the best way.  But good enough for this assignment
            Files.write(Paths.get(logFileName), fullMessage.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(Exception ex) {
        log(ex.toString());
    }

    public void log(Exception ex, String msg) {
        log(msg + ": " + ex.toString());
    }


}
