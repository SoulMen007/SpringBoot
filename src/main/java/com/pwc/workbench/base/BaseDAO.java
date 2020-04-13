package com.pwc.workbench.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class BaseDAO extends SqlSessionDaoSupport{
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){

        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> selectList(String sqlid, Object paramObj) {
        return (List<T>) this.getSqlSession().selectList(sqlid, paramObj);
    }

    @SuppressWarnings("unchecked")
    public <T> Page<T> selectPageList(String sqlid, Object paramObj, int currpage, int prePageRows) {
        PageHelper.startPage(currpage, prePageRows);
        return (Page<T>) this.getSqlSession().selectList(sqlid, paramObj);
    }
    @SuppressWarnings("unchecked")
    public <T> Page<T> selectPageList(String sqlid, int currpage, int prePageRows) {
        PageHelper.startPage(currpage, prePageRows);
        return (Page<T>) this.getSqlSession().selectList(sqlid);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> selectList(String sqlid) {
        return (List<T>) this.getSqlSession().selectList(sqlid);
    }
    @SuppressWarnings("unchecked")
    public <T> List<T> selectList(String sqlid,Object paramObj,RowBounds arg3) {
        return (List<T>) this.getSqlSession().selectList(sqlid, paramObj, arg3);
    }
    @SuppressWarnings("unchecked")
    public <T> T selectOne(String sqlid) {
        return (T) this.getSqlSession().selectOne(sqlid);
    }
    @SuppressWarnings("unchecked")
    public <T> T selectOne(String sqlid, Object paramObj) {
        return (T) this.getSqlSession().selectOne(sqlid, paramObj);
    }
    @SuppressWarnings("unchecked")
    public Map selectMap(String arg0, String arg1) {
        return this.getSqlSession().selectMap(arg0, arg1);
    }
    @SuppressWarnings("unchecked")
    public Map selectMap(String arg0,Object arg1,String arg2) {
        return this.getSqlSession().selectMap(arg0, arg1, arg2);
    }
    @SuppressWarnings("unchecked")
    public Map selectMap(String arg0,Object arg1,String arg2,RowBounds arg3) {
        return this.getSqlSession().selectMap(arg0, arg1, arg2, arg3);
    }
    public int delete(String sqlid) {
        return this.getSqlSession().delete(sqlid);
    }

    public int delete(String sqlid,Object paramObj) {
        return this.getSqlSession().delete(sqlid, paramObj);
    }

    public int insert(String sqlid,Object paramObj) {
        return this.getSqlSession().insert(sqlid, paramObj);
    }
    public int insert(String sqlid) {
        return this.getSqlSession().insert(sqlid);
    }
    public void select(String sqlid,ResultHandler arg1) {
        this.getSqlSession().select(sqlid, arg1);
    }
    public void select(String sqlid,Object paramObj,ResultHandler arg1) {
        this.getSqlSession().select(sqlid, paramObj,arg1);
    }
    public void select(String sqlid,Object paramObj,RowBounds arg3,ResultHandler arg1) {
        this.getSqlSession().select(sqlid,paramObj,arg3, arg1);
    }

    public int update(String sqlid,Object paramObj) {
        return this.getSqlSession().update(sqlid, paramObj);
    }
    public int update(String sqlid) {
        return this.getSqlSession().update(sqlid);
    }
}
