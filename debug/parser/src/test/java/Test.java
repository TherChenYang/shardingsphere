import org.apache.shardingsphere.infra.database.core.type.DatabaseType;
import org.apache.shardingsphere.infra.spi.type.typed.TypedSPILoader;
import org.apache.shardingsphere.sql.parser.api.CacheOption;
import org.apache.shardingsphere.sql.parser.api.SQLFormatEngine;
import org.apache.shardingsphere.sql.parser.api.SQLParserEngine;
import org.apache.shardingsphere.sql.parser.core.ParseASTNode;

/**
 * @author: CY.Ma
 * @date: 2024/4/9 19:17
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        CacheOption cacheOption = new CacheOption(128, 1024L);
        ParseASTNode oracle = new SQLParserEngine(TypedSPILoader.getService(DatabaseType.class, "Oracle"), cacheOption)
                .parse("select age from (select '0-1岁' age,count(*) countNum, '0' sortNum from T_EMPI_PATIENT_INFO t where t.birth > to_char((sysdate - interval '1' year(3)), 'yyyymmdd'))", false);
        System.out.println(oracle);
    }
}
