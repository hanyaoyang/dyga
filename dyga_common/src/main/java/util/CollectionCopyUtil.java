package util;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lyz
 * @version 1.0.0
 * @ClassName CollectionCopyUtil
 * @createTime 2019年07月01日 15:44
 */
public class CollectionCopyUtil {

    public static <T> List copyList(List<T> list, Class tClass) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList();
        }
        List<T> temp = JSON.parseArray(JSON.toJSONString(list), tClass);
        list.clear();
        list.addAll(temp);
        return list;
    }

    public static <T> PageBean copyList(PageBean<T> pageBean, Class tClass) {
        if (EmptyUtil.isEmpty(pageBean)) {
            return new PageBean<>(new ArrayList<>());
        }
        List<T> temp = JSON.parseArray(JSON.toJSONString(pageBean.getList()), tClass);
        pageBean.setList(temp);
        return pageBean;
    }

    public static Map<String, Object> copyMap(Map map) {
        return JSON.parseObject(JSON.toJSONString(map));
    }
}
