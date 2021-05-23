package com.example.component;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Mutter;
import com.example.repository.MutterRepository;

import lombok.Getter;
import lombok.Setter;

public class MutterComponent {
    @Autowired
    MutterRepository repository;

    @Getter @Setter
    private Optional<Mutter> mutter;

    public String getMutter(int id) {
        mutter =repository.findById(id);
       return mutter.toString();
    }

    @Override
    public String toString() {
        return "MutterComponent =" + mutter.toString();
    }

}
