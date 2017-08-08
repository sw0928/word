package tst.project.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import tst.project.page.PageBean;

public class ElasticsearchUtils {
	private Client client;

	public ElasticsearchUtils(String clusterName, String ipAddress) {
		Settings settings = ImmutableSettings.settingsBuilder()
				// 设置集群名称
				.put("cluster.name", clusterName).put("client.transport.ignore_cluster_name", false)
				.put("node.client", true).put("client.transport.sniff", true).build();
		client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(ipAddress, 9300));// 此处端口号为9300
	}
	
	/**
	 * 分页查询 SOBang
	 * @param resultMap
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public void findByPage(String indexName,String typeName,PageBean pageBean){		
		SearchRequestBuilder srb = client.prepareSearch(indexName);
		srb.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
		srb.setTypes(typeName);
//		srb.setQuery(resultMap);
		srb.setFrom((pageBean.getPage() - 1) * pageBean.getLimit()).setSize(pageBean.getLimit()).setExplain(true);
		
		SearchResponse response = srb.execute().actionGet();
		SearchHits hits = response.getHits();
		
		pageBean.setTotal((int)hits.getTotalHits());
		List list = new ArrayList();
		for (SearchHit searchHit : hits) {
			Map source = searchHit.getSource();
			//list.add(entity);
		}
		//return page;
	}
	/** 
     * 创建索引 
     * @param indexName 索引名称，相当于数据库名称 
     * @param typeName 索引类型，相当于数据库中的表名 
     * @param id id名称，相当于每个表中某一行记录的标识 
     * @param jsonData json数据 
     */  
    public void createIndex(String indexName, String typeName, String id,  
            String jsonData) {  
        IndexRequestBuilder requestBuilder = client.prepareIndex(indexName,  
            typeName, id).setRefresh(true);//设置索引名称，索引类型，id  
        requestBuilder.setSource(jsonData).execute().actionGet();//创建索引  
    }  
    
    
    /** 
     * 执行搜索 
     * @param indexname 索引名称 
     * @param type 索引类型 
     * @param queryBuilder 查询条件 
     * @return 
     */  
    public SearchResponse searcher(String indexName, String typeName,  
            QueryBuilder queryBuilder) {  
        SearchResponse searchResponse = client.prepareSearch(indexName)  
                .setTypes(typeName).setQuery(queryBuilder).execute()  
                .actionGet();//执行查询  
        return searchResponse;  
    }  
    
    
    /** 
     * 更新索引 
     * @param indexName 索引名称 
     * @param typeName 索引类型 
     * @param id id名称 
     * @param jsonData json数据 
     */  
    public void updateIndex(String indexName, String typeName, String id,  
            String jsonData) {  
        UpdateRequest updateRequest = new UpdateRequest();  
        updateRequest.index(indexName);//设置索引名称  
        updateRequest.id(id);//设置id  
        updateRequest.type(typeName);//设置索引类型  
        updateRequest.doc(jsonData);//更新数据  
        client.update(updateRequest).actionGet();//执行更新  
    }  
    
    
    /** 
     * 删除索引 
     * @param indexName 
     * @param typeName 
     * @param id 
     */  
    public void deleteIndex(String indexName, String typeName, String id) {  
        client.prepareDelete(indexName, typeName, id).get();  
    }  
}
