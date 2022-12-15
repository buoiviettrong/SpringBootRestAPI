package com.Nixagh.SpringBootRestAPI.Specifications;

import org.apache.logging.log4j.util.Strings;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class BookQuery {
//	private static Query query;
	
	public Query getQuery(String maSach, String tenSach, int soLuong, int gia, String maLoai, String tacGia) {
		Query query = new Query();
		if(Strings.isNotEmpty(maSach))
			query.addCriteria(Criteria.where("masach").is(maSach));
		if(Strings.isNotEmpty(tenSach))
			query.addCriteria(Criteria.where("tensach").regex("^.*"+tenSach+".*$"));
		if(soLuong != 0)
			query.addCriteria(Criteria.where("soLuong").is(soLuong));
		if(gia != 0)
			query.addCriteria(Criteria.where("gia").is(gia));
		if(Strings.isNotEmpty(maLoai))
			query.addCriteria(Criteria.where("maloai").is(maLoai));
		if(Strings.isNotEmpty(tacGia))
			query.addCriteria(Criteria.where("tacGia").is(tacGia));
		
		return query;
	}
}
