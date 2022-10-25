import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    @Test
    @DisplayName("문자열(1,2)을 쉼표(,)로 스플릿 하여 원소가 1과 2인 배열을 리턴한다.")
    void splitTwoString() {
        String input1 = "1,2";
        String[] result1 = input1.split(",");
        assertThat(result1).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열(1)을 쉼표(,)로 스플릿 하여 원소가 1인 배열을 리턴한다.")
    void splitOneString() {
        String input = "1";
        String[] result2 = input.split(",");
        assertThat(result2).contains("1");

    }

    @Test
    @DisplayName("substring() 메서드는 부분 문자열을 리턴한다")
    void subString() {
        String input = "(1,2)";
        String result = input.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }


    @Test
    @DisplayName("charAt() 메서드는 문자열의 해당 위치의 문자를 반환한다")
    void charAtSuccess() {
        String input = "abc";
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() 메서드의 index 기준 str.length()을 벗어나면 StringIndexOutOfBoundsException 발생")
    void charAtException() {
        String input = "abc";
        int overMaxIndex = input.length() + 1;
        assertThatThrownBy(() -> {
            input.charAt(overMaxIndex);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %s", overMaxIndex));

    }

}
