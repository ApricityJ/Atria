package apricityj.util;

import apricityj.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Paths;

public class UtilService {

    private static final Logger logger = LoggerFactory.getLogger(UtilService.class);

    public static void main(String[] args) {
        zipTest();
//        unzipTest();
    }

    public static void zipTest() {
        File srcFile = Paths.get(Constant.DATA_DIR_PATH, "hourglass.txt").toFile();
        File zipFile = Paths.get(Constant.DATA_DIR_PATH, "hourglass.zip").toFile();
        ZipUtil.zip(srcFile, zipFile);
    }

    public static void unzipTest() {
        File zipFile = Paths.get(Constant.DATA_DIR_PATH, "hourglass.zip").toFile();
        File dstDir = Paths.get(Constant.DATA_DIR_PATH, "out").toFile();
        ZipUtil.unzip(zipFile, dstDir);
    }
}
