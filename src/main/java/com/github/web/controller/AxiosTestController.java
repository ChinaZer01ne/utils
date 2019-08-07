package com.github.web.controller;

import com.github.web.common.Result;
import com.github.web.entity.Axios;
import com.github.web.entity.AxiosEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 测试axios
 * @author peach
 * @since 2019/8/6 下午7:53
 */
@RestController
@RequestMapping("/axios")
public class AxiosTestController {

    @GetMapping("/get")
    public Result get(AxiosEntity axios){

        System.out.println(axios);

        axios.setId(1);

        HashMap<String, String> map = new HashMap<>(3);
        map.put("axios","get");
        map.put("name","test");
        axios.setMap(map);
        List<Axios> list = new ArrayList<>();
        Axios axiosEle = new Axios();
        axiosEle.setId(1);
        axiosEle.setMethod("GET");
        list.add(axiosEle);

        Axios axiosEle2 = new Axios();
        axiosEle2.setId(2);
        axiosEle2.setMethod("GET2");
        list.add(axiosEle2);

        axios.setList(list);
        return Result.success(axios);
    }

    @PostMapping("/post")
    public Result post(@RequestBody AxiosEntity axios){
        System.out.println(axios);
        return Result.success(axios);
    }
}
