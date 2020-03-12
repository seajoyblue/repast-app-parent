package com.longlong.repast.status;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-09
 * @Description:
 */
public enum StatusEnums {
    SUCCESS("1","操作成功"),
    FAILED("2","操作失败"),
    ENOUGH("3","库存充足"),
    NOT_ENOUGH("4","库存不足"),
    CLEAR_CART_SUCCESS("5","清空购物车成功"),
    DELETE_OPERATION("6","删除操作"),
    UPDATE_OPERATION("7","修改操作"),
    INSERT_OPERATION("8","添加操作");

    StatusEnums(String code,String mag){
        this.code=code;
        this.mag=mag;
    };

    private String code;
    private String mag;

    public String getCode() {
        return code;
    }

    public String getMag() {
        return mag;
    }
}
