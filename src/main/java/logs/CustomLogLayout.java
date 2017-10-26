package logs;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class CustomLogLayout  extends PatternLayout {
    public String format(LoggingEvent event) {
        String log = (String) event.getMessage();
        return log.toLowerCase();
    }
}