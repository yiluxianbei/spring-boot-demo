package demo.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * tab状态 checkState
 * Created by of2975 on 2019/4/22.
 */
public enum CheckState {

    /**
     * 待审核 0
     */
    CHECK("待审核"),

    /**
     * 已完成 1
     */
    FINISH("已完成"),

    /**
     * 提现失败 2
     */
    FAIL("提现失败"),

    /**
     * 审核未通过 3
     */
    NOT_AUDIT("审核未通过"),

    /**
     * 已取消 4
     */
    CANCEL("已取消");

    private String desc;

    CheckState(String desc) {
        this.desc = desc;
    }

    /**
     * 自定义json反序列化成对象的规则，这里是从枚举名序列化成对象
     * @param value
     * @return
     */
//    @JsonCreator
//    public static CheckState fromValue(String value) {
//        return CheckState.valueOf(value);
//    }
    /**
     * 自定义json反序列化成对象的规则，这里是从枚举顺序序列化成对象(不配置，默认是这中方式)
     */
    @JsonCreator
    public static CheckState fromValue(int value) {
        return CheckState.values()[value];
    }
    /**
     * 自定义对象序列化成json的值，这里是返回枚举的顺序
     * @return
     */
    @JsonValue
    public int toValue() {
        return this.ordinal();
    }
}
