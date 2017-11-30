package com.haina.news.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.haina.news.domin.Mynews;
@Mapper
public interface MynewsDao {

	public List<Mynews> findAll();

	public void add(Mynews mynews);

	public Mynews findbyid(int id);

	public Mynews staticfun();

	public void updatemn(Mynews mn);
	
}
