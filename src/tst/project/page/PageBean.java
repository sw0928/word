/**
 * 
 */
package tst.project.page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author sjb
 * 
 */
public class PageBean extends RowBounds {
	private int defaultLimit = 10;
	// 总记录数
	private int total;
	// 查询的起始位置
	private int offset;
	// 查询多少行记录
	private int limit;

	private int page;

	public int getPage() {
		return page==0?1:page;
	}

	public PageBean setPage(int page) {
		this.page=page;
		return this;
	}

	public PageBean setLimit(int limit) {
		this.limit = limit;
		return this;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit==0?defaultLimit:limit;
	}

	public void setMeToDefault() {
		this.offset = NO_ROW_OFFSET;
		this.limit = NO_ROW_LIMIT;
	}

	public int getSelectCount() {
		return limit + offset;
	}
}
