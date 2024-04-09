import org.apache.shardingsphere.infra.database.core.type.DatabaseType;
import org.apache.shardingsphere.infra.spi.type.typed.TypedSPILoader;
import org.apache.shardingsphere.sql.parser.api.CacheOption;
import org.apache.shardingsphere.sql.parser.api.SQLFormatEngine;

/**
 * @author: CY.Ma
 * @date: 2024/4/9 19:17
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        CacheOption cacheOption = new CacheOption(128, 1024L);
        String mysql = new SQLFormatEngine(TypedSPILoader.getService(DatabaseType.class, "Mysql"), cacheOption).format("select * from test", false, null);
        System.out.println(mysql);
    }
}
