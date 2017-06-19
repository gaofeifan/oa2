package com.pj.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.system.pojo.Record;
import com.pj.system.pojo.RecordQuery;

public interface RecordMapper {
    int countByExample(RecordQuery example);

    int deleteByExample(RecordQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(RecordQuery example);

    Record selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") RecordQuery example);

    int updateByExample(@Param("record") Record record, @Param("example") RecordQuery example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

	List<Record> findRecordsBymessageId(Integer recordid);
}