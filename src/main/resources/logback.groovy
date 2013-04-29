import static ch.qos.logback.classic.Level.*
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.classic.encoder.PatternLayoutEncoder

def highlight = System.getProperty("log.highlight") == "true" ?: false

appender("STDOUT", ConsoleAppender) {
    withJansi = true
    encoder(PatternLayoutEncoder) {
        pattern = (highlight) ?
            "%white(%date{HH:mm:ss.SSS}) %highlight(%-5level) %cyan(%logger{15}) %highlight(%message) %n" :
            "%date{HH:mm:ss.SSS} %-5level %logger{15} %message%n"
    }
}
root(INFO, [ "STDOUT" ])
logger("net.physalis", TRACE, [ "STDOUT" ], false)
logger("org.springframework", INFO, [ "STDOUT" ], false)
logger("org.eclipse.jetty", INFO, [ "STDOUT" ], false)
