package tst.project.page;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;

@Intercepts(@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})) 
public class MySqlPagingInterceptor extends PageInterceptor {

    /**
     * 改造sql变成查询总数的sql
     * @param targetSql 正常查询数据的sql: select id, name from user where name = ?
     * @return select count(1) from user where name = ?
     */
    @Override
    protected String getSelectTotalSql(String targetSql) {
        String sql = targetSql.toLowerCase();
      /*  StringBuilder sqlBuilder = new StringBuilder(sql);
        
        int orderByPos = 0;
        if((orderByPos = sqlBuilder.lastIndexOf(ORDER_BY)) != -1) {
            sqlBuilder.delete(orderByPos, sqlBuilder.length());
        }
        
        if(sqlBuilder.indexOf(UNION) != -1) {
            sqlBuilder.insert(0, "select count(1) as _count from ( ").append(" ) as _alias");
            return sqlBuilder.toString();
        }
        
        int fromPos = sqlBuilder.indexOf(FROM);
        if(fromPos != -1) {
            sqlBuilder.delete(0, fromPos);
            sqlBuilder.insert(0, "select count(1) as _count ");
        }
        */
        return "select count(*) from ("+sql+")as t";
    }

    /**
     * 改造sql变成支持分页的sql
     * @param targetSql 正常查询数据的sql: select id, name from user where name = ?
     * @return WITH query AS (SELECT inner_query.*, ROW_NUMBER() OVER (ORDER BY CURRENT_TIMESTAMP) 
     * as __mybatis_row_nr__ FROM ( select id, name from user where name = ? ) inner_query ) 
     * SELECT * FROM query WHERE __mybatis_row_nr__ >= 3 AND __mybatis_row_nr__ <= 6 
     */
    @Override
    protected String getSelectPagingSql(String targetSql, PageBean bounds) {
    	String sql = targetSql.toLowerCase();
    	String str="";
    	
    	int order_index=targetSql.lastIndexOf("order by");
    	if(order_index!=-1){
    		str="select * from (";
    		str=str+sql.substring(0, order_index);
    		str=str+") as a "+sql.substring(order_index, sql.length())+" limit "+(bounds.getPage()-1)*bounds.getLimit()+","+bounds.getLimit();
    	}else{  
	        str="select * from (";
	        str=str+sql;
	        str=str+") as a	limit "+(bounds.getPage()-1)*bounds.getLimit()+","+bounds.getLimit();
    	}
        return str;
    }

}
