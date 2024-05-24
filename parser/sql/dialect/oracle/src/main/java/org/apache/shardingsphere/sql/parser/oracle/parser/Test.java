package org.apache.shardingsphere.sql.parser.oracle.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.shardingsphere.infra.database.core.type.DatabaseType;
import org.apache.shardingsphere.infra.spi.type.typed.TypedSPILoader;
import org.apache.shardingsphere.sql.parser.api.SQLStatementVisitorEngine;
import org.apache.shardingsphere.sql.parser.core.ParseASTNode;
import org.apache.shardingsphere.sql.parser.core.database.parser.SQLParserExecutor;
import org.apache.shardingsphere.sql.parser.sql.common.statement.SQLStatement;

/**
 *
 */
public class Test {
    private static final String SQL = "select age from (select '0-1岁' age,count(*) countNum, '0' sortNum from T_EMPI_PATIENT_INFO t where t.birth > to_char((sysdate - interval '1' year(3)), 'yyyymmdd'))";
    public static void main(String[] args) {
        DatabaseType databaseType = TypedSPILoader.getService(DatabaseType.class, "Oracle");
        SQLParserExecutor sqlParserExecutor = new SQLParserExecutor(databaseType);
        ParseASTNode parse = sqlParserExecutor.parse(SQL);

        SQLStatement visit = new SQLStatementVisitorEngine(databaseType)
                .visit(parse);

        System.out.println(JSON.toJSONString(visit, SerializerFeature.SkipTransientField));
    }
}
