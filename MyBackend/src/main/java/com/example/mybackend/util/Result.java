package com.example.mybackend.util;
import java.io.Serializable;

public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    // 状态码，比如200表示成功，其他自定义的状态码对应不同情况
    private int code;
    // 提示信息，用于简单描述请求结果情况
    private String message;
    // 具体的数据内容，可以是对象、集合等各种类型，使用泛型来适配不同的数据返回需求
    private T data;

    // 构造函数，用于创建成功且带有数据的返回结果
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 构造函数，用于创建成功但无数据的返回结果（比如删除操作成功等情况）
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 构造函数，用于创建失败的返回结果
    public Result(int code, String message, Throwable throwable) {
        this.code = code;
        this.message = message;
        // 可根据实际需求，将异常信息等记录下来，这里暂未处理，只是示意
    }

    // 以下是Getter和Setter方法

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // 以下是一些静态方法，方便快速创建不同类型的Result实例，可根据实际需求调整

    // 创建成功且带有数据的返回结果的静态方法
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    // 创建成功但无数据的返回结果的静态方法（比如删除操作成功等情况）
    public static Result<Void> success() {
        return new Result<>(200, "操作成功");
    }

    // 创建失败的返回结果的静态方法，传入自定义的提示信息
    public static <T> Result<T> fail(String message) {
        return new Result<>(500, message, null);
    }

    // 创建失败的返回结果的静态方法，传入自定义的提示信息和异常对象（可用于记录详细的错误原因等）
    public static Result<Void> fail(String message, Throwable throwable) {
        return new Result<>(500, message, throwable);
    }
}