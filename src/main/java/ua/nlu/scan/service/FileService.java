package ua.nlu.scan.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by pc8 on 06.11.15.
 */
@Service
public class FileService {
    private static final Logger logger = Logger.getLogger(FileService.class);

    public FileService() {
    }

    @Value("${directory}")
    private String DIRECTORY;

    /**
     * This method deletes all file from directory of books
     */
    public void deleteAllFiles() {
        File file = new File(DIRECTORY);
        for (File f : file.listFiles()) {
            if (!f.getName().equals("1")) {
                deleteFile(f);
            }
        }
    }

    /**
     * Method deletes file from directory
     *
     * @param file
     */
    public void deleteFile(File file) {
        if (!file.exists())
            return;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    deleteFile(f);
                }
            }
        }
        if (!file.delete()) {
            if (logger.isDebugEnabled()) {
                logger.debug("File -- " + file + " was not delete");
            }
        }
    }

}
