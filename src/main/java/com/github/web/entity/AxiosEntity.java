package com.github.web.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 测试axios的实体
 * @author peach
 * @since 2019/8/6 下午7:55
 */
@Data
public class AxiosEntity {
    private Integer id;
    private Map<String,String> map;
    private List<Axios> list;
}
