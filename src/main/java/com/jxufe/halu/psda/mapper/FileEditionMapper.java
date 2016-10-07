package com.jxufe.halu.psda.mapper;

import com.jxufe.halu.psda.pojo.FileEdition;

public interface FileEditionMapper {
    int deleteByPrimaryKey(Short editionid);

    int insert(FileEdition record);

    int insertSelective(FileEdition record);

    FileEdition selectByPrimaryKey(Short editionid);

    int updateByPrimaryKeySelective(FileEdition record);

    int updateByPrimaryKey(FileEdition record);
}