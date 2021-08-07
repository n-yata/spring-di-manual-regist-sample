package com.example.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.model.Mutter;
import com.example.repository.MutterRepository;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope(value = "prototype")
public class MutterComponent {
    @Autowired
    MutterRepository repository;
    @Autowired
    NestedComponent nestedComponent;

    @Getter @Setter
    private Optional<Mutter> mutter;

    @Getter
    private List<Mutter> mutterList = new ArrayList<>();

    public String getMutter(int id) {
        mutter =repository.findById(id);
        mutterList.add(mutter.get());

        int count = nestedComponent.countUp();

       return mutter.toString() + " count : " + count;
    }

    @Override
    public String toString() {
        return "MutterComponent =" + mutter.toString();
    }

}
