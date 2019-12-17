package net.dfrz.mapper;

import net.dfrz.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(String stuID);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String stuID);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}