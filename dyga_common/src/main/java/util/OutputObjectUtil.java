package util;

/**
 * 响应结果生成工具
 */
public class OutputObjectUtil {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static OutputObject genSuccessResult() {
        return new OutputObject()
                .setRespCode(ReturnCode.SUCCESS)
                .setRespMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static OutputObject genSuccessResult(Object data,String message) {
        return new OutputObject()
                .setRespCode(ReturnCode.SUCCESS)
                .setRespMessage(message)
                .setData(data);
    }
    public static OutputObject genSuccessResult(Object data) {
        return new OutputObject()
                .setRespCode(ReturnCode.SUCCESS)
                .setRespMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static OutputObject genFailResult(String message) {
        return new OutputObject()
                .setRespCode(ReturnCode.FAIL)
                .setRespMessage(message);
    }

    public static OutputObject genFailResult(String resultCode,String message) {
        return new OutputObject()
                .setRespCode(resultCode)
                .setRespMessage(message);
    }

}
