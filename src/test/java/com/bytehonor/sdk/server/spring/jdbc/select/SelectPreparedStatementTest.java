package com.bytehonor.sdk.server.spring.jdbc.select;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.server.spring.jdbc.select.SelectPreparedStatement;
import com.bytehonor.sdk.server.spring.query.MatchColumn;
import com.bytehonor.sdk.server.spring.query.QueryCondition;
import com.bytehonor.sdk.server.spring.query.QueryOrder;

public class SelectPreparedStatementTest {

    private static final Logger LOG = LoggerFactory.getLogger(SelectPreparedStatementTest.class);

    @Test
    public void test() {
        QueryCondition condition = QueryCondition.create(0, 10)
                .and(MatchColumn.eq("name", "john';drop table tbl_other;--")).orderBy(QueryOrder.descOf("age"));
        SelectPreparedStatement statement = SelectPreparedStatement.create("tbl_user", "id", "id,name,age", condition);

        LOG.info("sql:{}", statement.toSelectSql());
        LOG.info("count:{}", statement.toCountSql());
        List<Object> args = statement.args();
        LOG.info("args:{}", args);
        assertTrue("test", args.size() == 1);
    }

}
