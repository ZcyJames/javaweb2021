package main.com.chinasoft.javaweb2021.util;



public class ReturnData {

    /**
     * 鐘舵�鐮�
     */
    private int code;

    /**
     * 杩斿洖鏁版嵁
     */
    private Object data;

    /**
     * 杩斿洖淇℃伅
     */
    private String message;

    public ReturnData() {
    }

    public ReturnData(Object data) {
        this.data = data;
    }

    public ReturnData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ReturnData(int code, Object data, String message) {

        this.code = code;
        this.data = data;
        this.message = message;
    }
    public ReturnData(int code,  String message) {

        this.code = code;
        this.data = false;
        this.message = message;
    }

    /*public ReturnData(StatusCode userResponseEnum,Object data,String message){
        this.data = data;
        this.message = message;
        this.code = userResponseEnum.getCode();
    }*/

    public ReturnData success(){
        this.code = 200;
        this.data = true;
        this.message = "成功";
        return this;
    }

    public ReturnData success(Object data){
        this.code = 200;
        this.data = data;
        this.message = "成功";
        return this;
    }

    public ReturnData error(){
        this.code = 500;
        this.data = false;
        this.message = "服务器错误";
        return this;
    }

    public ReturnData error(Object data,String message){
        this.code = 500;
        this.data = data;
        this.message = message;
        return this;
    }

    /*set get鏂规硶*/

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    //----------
}
