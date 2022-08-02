package pl.sdacademy.java.advanced.exercises.day2.task16;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RunnerTest {

    @Test
    void shouldBeClassifiedAsBeginner() {
        //when
        Runner result = Runner.getFitnessLevel(201);
        //then
        assertThat(result).isEqualTo(Runner.BEGINNER);
    }

    @Test
    void shouldBeClassifiedAsIntermediate_1() {
        //when
        Runner result = Runner.getFitnessLevel(101);
        //then
        assertThat(result).isEqualTo(Runner.INTERMEDIATE);
    }

    @Test
    void shouldBeClassifiedAsIntermediate_2() {
        //when
        Runner result = Runner.getFitnessLevel(200);
        //then
        assertThat(result).isEqualTo(Runner.INTERMEDIATE);
    }

    @Test
    void shouldBeClassifiedAsAdvanced_1() {
        //when
        Runner result = Runner.getFitnessLevel(0);
        //then
        assertThat(result).isEqualTo(Runner.ADVANCED);
    }

    @Test
    void shouldBeClassifiedAsAdvanced_2() {
        //when
        Runner result = Runner.getFitnessLevel(100);
        //then
        assertThat(result).isEqualTo(Runner.ADVANCED);
    }

    @Test
    void shouldBeClassifiedAsBeginner_NegativeCase() {
        //when
        Runner result = Runner.getFitnessLevel(-100);
        //then
        assertThat(result).isEqualTo(Runner.BEGINNER);
    }
}