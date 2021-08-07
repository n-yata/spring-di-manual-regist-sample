package com.example.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class NestedComponent {
    private int count;

    public int countUp() {
        this.count++;
        return count;
    }
}
