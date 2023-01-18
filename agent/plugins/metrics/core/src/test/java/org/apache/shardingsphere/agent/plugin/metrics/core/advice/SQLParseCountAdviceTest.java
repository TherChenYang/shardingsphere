/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.agent.plugin.metrics.core.advice;

import org.apache.shardingsphere.agent.plugin.metrics.core.collector.MetricsCollectorRegistry;
import org.apache.shardingsphere.agent.plugin.metrics.core.config.MetricCollectorType;
import org.apache.shardingsphere.agent.plugin.metrics.core.config.MetricConfiguration;
import org.apache.shardingsphere.agent.plugin.metrics.core.fixture.MetricsCollectorFixture;
import org.apache.shardingsphere.distsql.parser.statement.rdl.create.RegisterStorageUnitStatement;
import org.apache.shardingsphere.distsql.parser.statement.rql.show.ShowStorageUnitsStatement;
import org.apache.shardingsphere.distsql.parser.statement.rul.sql.FormatStatement;
import org.apache.shardingsphere.migration.distsql.statement.ShowMigrationListStatement;
import org.apache.shardingsphere.sql.parser.sql.common.segment.generic.DatabaseSegment;
import org.apache.shardingsphere.sql.parser.sql.common.statement.SQLStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowDatabasesStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dcl.MySQLCreateUserStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.ddl.MySQLCreateDatabaseStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dml.MySQLDeleteStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dml.MySQLInsertStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dml.MySQLSelectStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dml.MySQLUpdateStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.tcl.MySQLCommitStatement;
import org.junit.After;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

public final class SQLParseCountAdviceTest {
    
    private final MetricConfiguration config = new MetricConfiguration("parsed_sql_total",
            MetricCollectorType.COUNTER, "Total count of parsed SQL", Collections.singletonList("type"), Collections.emptyMap());
    
    @After
    public void reset() {
        ((MetricsCollectorFixture) MetricsCollectorRegistry.get(config, "FIXTURE")).reset();
    }
    
    @Test
    public void assertParseInsertSQL() {
        assertParse(new MySQLInsertStatement());
    }
    
    @Test
    public void assertParseDeleteSQL() {
        assertParse(new MySQLDeleteStatement());
    }
    
    @Test
    public void assertParseUpdateSQL() {
        assertParse(new MySQLUpdateStatement());
    }
    
    @Test
    public void assertParseSelectSQL() {
        assertParse(new MySQLSelectStatement());
    }
    
    @Test
    public void assertParseDDL() {
        assertParse(new MySQLCreateDatabaseStatement());
    }
    
    @Test
    public void assertParseDCL() {
        assertParse(new MySQLCreateUserStatement());
    }
    
    @Test
    public void assertParseDAL() {
        assertParse(new MySQLShowDatabasesStatement());
    }
    
    @Test
    public void assertParseTCL() {
        assertParse(new MySQLCommitStatement());
    }
    
    @Test
    public void assertParseRQL() {
        assertParse(new ShowStorageUnitsStatement(new DatabaseSegment(0, 0, null), null));
    }
    
    @Test
    public void assertParseRDL() {
        assertParse(new RegisterStorageUnitStatement(false, Collections.emptyList()));
    }
    
    @Test
    public void assertParseRAL() {
        assertParse(new ShowMigrationListStatement());
    }
    
    @Test
    public void assertParseRUL() {
        assertParse(new FormatStatement("SELECT * FROM t_order"));
    }
    
    private void assertParse(final SQLStatement sqlStatement) {
        new SQLParseCountAdvice().afterMethod(new MockTargetAdviceObject(), mock(Method.class), new Object[]{}, sqlStatement, "FIXTURE");
        assertThat(((MetricsCollectorFixture) MetricsCollectorRegistry.get(config, "FIXTURE")).getValue(), is(1d));
    }
}