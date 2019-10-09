package util;

/**
 * 字符串形式的数组或集合的工具类
 * @author lsw
 * @date 2019-8-12
 */
public class ArrayStringUtil {

    /**
     * 去除字符串形式的数组或集合的中括号
     * @param arrayString
     * @return 结果
     */
    public static String removeBracket(String arrayString){
        if(EmptyUtil.isEmpty(arrayString)){
            return null;
        }
        return arrayString.substring(1, arrayString.length()-1);
    }

}
