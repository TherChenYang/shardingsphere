import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("classpath:sharding.yml"));
        Connection connection = dataSource.getConnection();
        String sql = "delete FROM books where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        for (int i = 5; i < 10; i++) {
            preparedStatement.setLong(1, i);
            preparedStatement.addBatch();
        }

        int[] ints = preparedStatement.executeBatch();
    }
}
