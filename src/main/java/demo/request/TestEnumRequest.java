package demo.request;

import demo.enums.CheckState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEnumRequest implements Serializable {

    private CheckState checkState;
}
