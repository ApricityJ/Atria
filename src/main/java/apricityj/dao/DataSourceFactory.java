package apricityj.dao;

import apricityj.Constant;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.nio.file.Paths;

public enum DataSourceFactory {

    INSTANCE;
    private HikariDataSource source;

    DataSourceFactory() {
        String propPath = Paths.get(Constant.DB_CONFIG_FILE_PATH).toString();
        source = new HikariDataSource(new HikariConfig(propPath));
    }

    public DataSource getDataSource() {
        return source;
    }

}
