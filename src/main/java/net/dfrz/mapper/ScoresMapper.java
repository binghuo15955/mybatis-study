package net.dfrz.mapper;

import java.util.List;
import java.util.Map;

import net.dfrz.entity.Scores;

public interface ScoresMapper {
	
	List<Scores> getScoresBystuID(Map<String, Object> params);
	

}
