package me.unvstore.dao;

import me.unvstore.entity.InformationEntity;

public interface IInformationDAO {
	InformationEntity findOne(Integer infId);
	void update(InformationEntity informationEntity);
	Integer insert(InformationEntity informationEntity);
	void delete(Integer informationId);
}
