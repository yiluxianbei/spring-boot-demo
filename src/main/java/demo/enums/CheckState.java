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

    @JsonValue
    public int toValue() {
        return this.ordinal();
    }
}
