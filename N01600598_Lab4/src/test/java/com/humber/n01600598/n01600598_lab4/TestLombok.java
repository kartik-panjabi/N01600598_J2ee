package com.humber.n01600598.n01600598_lab4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestLombok {
    private Long id;
}

class Main {
    public static void main(String[] args) {
        TestLombok t = new TestLombok();
        t.setId(123L);
        System.out.println(t.getId()); // Should print 123
    }
}
