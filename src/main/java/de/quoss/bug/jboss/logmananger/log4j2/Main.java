package de.quoss.bug.jboss.logmananger.log4j2;

import de.quoss.test.log.producer.log4j2.Log4j2LogMsgProducer;
import org.apache.logging.log4j.ThreadContext;
import org.jboss.logging.Logger;
import org.jboss.logging.MDC;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    private static final String LOG_MSG_FMT = "JBoss Logger %s message";

    private static final String MDC_KEY = "qualifier";

    public void run() {
        final String methodName = "run()";
        LOGGER.tracef("%s start", methodName);
        // MDC only available in jboss log messages
        String qualifier = "jboss-only";
        MDC.put(MDC_KEY, qualifier);
        printLogMsgs();
        // workaraound - put qualifier explicitly into log4j2 thread context map
        qualifier = "jboss-and-log4j2";
        MDC.put(MDC_KEY, qualifier);
        ThreadContext.put(MDC_KEY, qualifier);
        printLogMsgs();
        LOGGER.tracef("%s end", methodName);
    }

    private void printLogMsgs() {
        LOGGER.tracef(LOG_MSG_FMT, "Trace");
        LOGGER.debugf(LOG_MSG_FMT, "Debug");
        LOGGER.infof(LOG_MSG_FMT, "Info");
        LOGGER.warnf(LOG_MSG_FMT, "Warn");
        LOGGER.errorf(LOG_MSG_FMT, "Error");
        LOGGER.fatalf(LOG_MSG_FMT, "Fatal");
        Log4j2LogMsgProducer.run();
    }

}
