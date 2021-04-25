package apricityj.util;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ZipUtil {

    static final Logger logger = LoggerFactory.getLogger(ZipUtil.class);

    private static final ZipParameters parameters;

    static {
        parameters = new ZipParameters();
        parameters.setCompressionMethod(CompressionMethod.DEFLATE);
        parameters.setCompressionLevel(CompressionLevel.NORMAL);
    }

    public static void zip(File srcFile, File zipFile) {
        try {
            ZipFile outFile = new ZipFile(zipFile);
            outFile.addFile(srcFile, parameters);
        } catch (ZipException e) {
            logger.error("Zip Error : {}", e.getMessage());
        }
    }

    public static void unzip(File zipFile, File dstDir) {
        try {
            ZipFile inFile = new ZipFile(zipFile);
            inFile.extractAll(dstDir.toString());
        } catch (ZipException e) {
            logger.error("Unzip Error : {}",e.getMessage());
        }
    }

}
