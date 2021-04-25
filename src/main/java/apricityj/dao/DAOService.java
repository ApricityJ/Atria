package apricityj.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOService {

    private static final Logger logger = LoggerFactory.getLogger(DAOService.class);

    public static void main(String[] args) throws SQLException {
//        CommonDAO testDAO = new CommonDAO("ciao");
        CommonDAO testDAO = new CommonDAO();

        ResultSet result = testDAO.executeQuery("select * from hello");
        while (result.next()) {
            int id = result.getInt(1);
            String name = result.getString("name");
            logger.info("{} : {}", id, name);
        }

//        testDAO.executeUpdate("insert into hello (id, name) "
//                + "values (3, 'Michelia')");
        testDAO.executeUpdate("delete from hello where id=3");

        testDAO.close();
    }
}
