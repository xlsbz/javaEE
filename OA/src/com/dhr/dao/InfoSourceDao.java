package com.dhr.dao;

import java.util.List;

import com.dhr.domain.InfoSource;

/**
 * 信息来源表数据接口层
 * 
 * @author Mr DU
 *
 */
public interface InfoSourceDao {

	/**
	 * 查询所有信息来源数据
	 * 
	 * @return
	 */
	List<InfoSource> findAll();

	/**
	 * 新增信息来源
	 * 
	 * @param infoSource
	 */
	void save(InfoSource infoSource);

	/**
	 * 根据ID查询某个信息来源
	 * 
	 * @param infoSourceId
	 * @return
	 */
	InfoSource findOne(String infoSourceId);

	/**
	 * 更新信息来源
	 * 
	 * @param infoSource
	 */
	void update(InfoSource infoSource);

	/**
	 * 批量删除
	 * 
	 * @param infoSourceId
	 */
	void delete(String... infoSourceId);

}
