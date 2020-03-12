package com.longlong.repast.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.longlong.repast.page.PageInfoS;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-09
 * @Description:
 */
public abstract class BaseService<T> {
    public abstract Mapper<T> getMapper();


    /**
     * @Author longlong
     * @Description
     * 保存/新增方法
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected Integer save(T t) throws Exception{
        return getMapper().insert(t);
    }

    /**
     * @Author longlong
     * @Description
     * 通过主键进行更新
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected Integer update(T t) throws Exception{
        return getMapper().updateByPrimaryKey(t);
    }

    /**
     * @Author longlong
     * @Description 
     * 通过key进行删除
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected Integer deleteByPrimaryKey(Object key) throws Exception{
        return getMapper().deleteByPrimaryKey(key);
    }
    
    /**
     * @Author longlong
     * @Description
     * 通过实体类属性进行删除（属性为唯一键）
     * @Date 2020/3/9
     * @Param 
     * @Return 
     **/
    protected Integer delete(T t) throws Exception{
        return getMapper().delete(t);
    }

    
    /**
     * @Author longlong
     * @Description
     * 通过主键进行查询
     * @Date 2020/3/9
     * @Param 
     * @Return 
     **/
    protected T get(Object key) throws Exception{
        return getMapper().selectByPrimaryKey(key);
    }

    /**
     * @Author longlong
     * @Description
     * 查询所有信息
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected List<T> get() throws Exception{
        return getMapper().selectAll();
    }

    /**
     * @Author longlong
     * @Description
     * 通过实体类属性进行查询
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected T selectOne(T t) throws Exception{
        return getMapper().selectOne(t);
    }


    /**
     * @Author longlong
     * @Description
     * 通过实体类属性进行查询
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected List<T> selectModel(T t) throws Exception{
        return getMapper().select(t);
    }


    /**
     * @Author longlong
     * @Description
     * 查询每页数量,带条件的分页查询
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected List<T> selectPage(T t, PageInfoS<T> pageInfos ) throws Exception{
        return getMapper().selectByRowBounds(t,new RowBounds(pageInfos.getPageNum(),pageInfos.getPageSize()));
    }

    /**
     * @Author longlong
     * @Description
     * 查询数量（带条件）
     * @Date 2020/3/9
     * @Param
     * @Return
     **/
    protected Integer selectCount(T t) throws Exception{
        return getMapper().selectCount(t);
    }
    
    /**
     * @Author longlong
     * @Description
     * 根据实体类中的属性进行分页查询
     * @Date 2020/3/10
     * @Param 
     * @Return 
     **/
    protected PageInfo<T> getPageInfo(PageInfoS<T> pageInfoS) throws Exception{
        if (pageInfoS.getPageNum()==null){
            pageInfoS.setPageNum(0);
        }
        PageHelper.startPage(pageInfoS.getPageNum(),pageInfoS.getPageSize());
        List<T> list= this.selectModel(pageInfoS.getT());
        PageInfo<T> pageInfo = new PageInfo<T>();
        pageInfo.setTotal(this.selectCount(pageInfoS.getT()));
        return pageInfo;

    }
}
