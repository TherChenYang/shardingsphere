import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.springframework.util.ResourceUtils.getFile;

/**
 * @author: CY.Ma
 * @date: 2024/3/18 10:56
 * @description:
 */
public class JdbcTest {
    public static void main(String[] args) throws IOException, SQLException {
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("classpath:encrypt.yaml"));
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM encrypt.dbo.t_user");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1)
                    + "," + resultSet.getString(2)
                    + "," + resultSet.getString(3)
                    + "," + resultSet.getString(4)
                    + "," + resultSet.getString(5)
                    + "," + resultSet.getString(6));
        }
    }
}
