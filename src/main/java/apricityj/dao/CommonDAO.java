package apricityj.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonDAO {

    private static final Logger logger = LoggerFactory.getLogger(CommonDAO.class);

    private Connection conn;
    private ResultSet rs;

    public CommonDAO() { }

    private boolean isNullOrClosed() throws SQLException {
        return null == conn || conn.isClosed();
    }

    private Connection toConnection() throws SQLException {
        if (isNullOrClosed()) {
            conn = DataSourceFactory.INSTANCE.getDataSource().getConnection();
        }
        return conn;
    }

    public void close() throws SQLException {
        if (null != rs) {
            rs.close();
        }
        if (null != rs) {
            conn.close();
        }
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        logger.info("QueryExecute : {}", sql);
        rs = toConnection().createStatement().executeQuery(sql);
        return rs;
    }

    public void executeUpdate(String sql) throws SQLException {
        logger.info("UpdateExecute : {}", sql);
        int res = toConnection().createStatement().executeUpdate(sql);
        logger.info("ResultNum : {}", res);
    }

}
