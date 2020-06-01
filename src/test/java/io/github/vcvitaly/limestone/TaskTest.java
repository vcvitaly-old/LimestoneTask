package io.github.vcvitaly.limestone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TaskTest {

    private Task task = new Task();

    @ParameterizedTest
    @MethodSource("correctArgs")
    void returnsCorrectDays(int i, String days) {
        assertThat(task.days(i)).isEqualTo(days);
    }

    @ParameterizedTest
    @MethodSource("incorrectArgs")
    void throwsExceptionOnIncorrectArgs(int i) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> task.days(i));
    }

    static Stream<Arguments> correctArgs() {
        return Stream.of(
                arguments(1, "1"),
                arguments(123, "1-3"),
                arguments(135, "1,3,5"),
                arguments(125, "1-2,5"),
                arguments(12367, "1-3,6-7"),
                arguments(134567, "1,3-7")
        );
    }

    static Stream<Arguments> incorrectArgs() {
        return Stream.of(
                arguments(0),
                arguments(10),
                arguments(81)
        );
    }
}