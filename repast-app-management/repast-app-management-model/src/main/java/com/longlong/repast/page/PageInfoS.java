package com.longlong.repast.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-09
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PageInfoS<T> {
    /**
     * 当前页码数
     */
    private Integer pageNum;
    /**
     * 每一页显示的条数
     */
    private Integer pageSize;

    /**
     * 查询出来的数据
     */
    private T t;
}
