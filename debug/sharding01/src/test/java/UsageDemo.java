import com.google.common.collect.Lists;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.broadcast.api.config.BroadcastRuleConfiguration;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.algorithm.core.config.AlgorithmConfiguration;
import org.apache.shardingsphere.infra.config.mode.ModeConfiguration;
import org.apache.shardingsphere.infra.config.props.ConfigurationPropertyKey;
import org.apache.shardingsphere.mode.repository.standalone.StandalonePersistRepositoryConfiguration;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.keygen.KeyGenerateStrategyConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.single.api.config.SingleRuleConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UsageDemo {

    public DataSource getDataSource() throws SQLException {
        Map<String, DataSource> dataSourceMap = createDataSources();

        Properties properties = new Properties();
        properties.put(ConfigurationPropertyKey.SQL_SHOW.getKey(), true);

        return ShardingSphereDataSourceFactory.createDataSource("ds",
                new ModeConfiguration("Standalone", null),
                dataSourceMap,
                Arrays.asList(createShardingRuleConfiguration(), createBroadcastRuleConfiguration()),
                properties);
    }

    private Map<String, DataSource> createDataSources() {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        HikariDataSource dataSource1 = new HikariDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setJdbcUrl("jdbc:mysql://localhost:3306/ds0");
        dataSource1.setUsername("root");
        dataSource1.setPassword("mcycxc19740203");
        dataSourceMap.put("ds", dataSource1);
        return dataSourceMap;
    }

    private BroadcastRuleConfiguration createBroadcastRuleConfiguration() {
        //no broadcast
        return new BroadcastRuleConfiguration(Collections.emptyList());
    }


    private ShardingRuleConfiguration createShardingRuleConfiguration() {
        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();


        //key generator
        shardingRuleConfiguration.getKeyGenerators().put("snowflake", new AlgorithmConfiguration("SNOWFLAKE", new Properties()));

        ShardingTableRuleConfiguration productTableRuleConfiguration = new ShardingTableRuleConfiguration("product", "ds.product_$->{2019..2099}-${(1..12).collect{t -> t.toString().padLeft(2,'0')}}");
        productTableRuleConfiguration.setKeyGenerateStrategy(new KeyGenerateStrategyConfiguration("id", "snowflake"));
        productTableRuleConfiguration.setTableShardingStrategy(new StandardShardingStrategyConfiguration("begin_time", "begin_time_interval"));

        Properties properties = new Properties();
        properties.setProperty("datetime-pattern", "yyyy-MM-dd HH:mm:ss");
        properties.setProperty("datetime-lower", "2024-01-01 01:01:01");
        properties.setProperty("sharding-suffix-pattern", "yyyy-MM");
        properties.setProperty("datetime-interval-unit", "MONTHS");
        shardingRuleConfiguration.getShardingAlgorithms().put("begin_time_interval", new AlgorithmConfiguration("INTERVAL", properties));

        shardingRuleConfiguration.getTables().add(productTableRuleConfiguration);

        return shardingRuleConfiguration;
    }


    public static void main(String[] args) throws SQLException {
        UsageDemo usageDemo = new UsageDemo();
        DataSource dataSource = usageDemo.getDataSource();

        String sql = "select * from product where begin_time = '2024-06-01 10:10:10'";
        try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String logId = resultSet.getString("id");
                System.out.println("logId = " + logId);
            }
        }
    }


}
