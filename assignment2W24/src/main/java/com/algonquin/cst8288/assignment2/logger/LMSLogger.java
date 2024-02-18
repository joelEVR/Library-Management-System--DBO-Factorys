package com.algonquin.cst8288.assignment2.logger;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class LMSLogger {

    private static LMSLogger instance = null;
    private final Logger logger;
    private FileHandler fh;

    // Private constructor for Singleton
    private LMSLogger() {
        logger = Logger.getLogger("LMSLogger");
        try {
            // Configuración del FileHandler para escribir en un archivo de log.
            // Cambia "app.log" al nombre de archivo que prefieras y la ruta según sea necesario.
            fh = new FileHandler("app.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método público estático 'getInstance' para obtener la instancia
    public static synchronized LMSLogger getInstance() {
        if (instance == null) {
            instance = new LMSLogger();
        }
        return instance;
    }

    // Método para registrar mensajes con diferentes niveles
    public void log(LogLevel level, String message) {
        switch (level) {
            case TRACE:
                logger.log(Level.FINEST, message);
                break;
            case DEBUG:
                logger.log(Level.FINE, message);
                break;
            case INFO:
                logger.log(Level.INFO, message);
                break;
            case WARN:
                logger.log(Level.WARNING, message);
                break;
            case ERROR:
                logger.log(Level.SEVERE, message);
                break;
        }
    }

    // Método para cerrar el FileHandler
    public void close() {
        fh.close();
    }
}
 