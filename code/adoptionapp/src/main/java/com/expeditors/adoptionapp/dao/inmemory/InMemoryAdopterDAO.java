package com.expeditors.adoptionapp.dao.inmemory;

import com.expeditors.adoptionapp.domain.Adopter;
import com.expeditors.adoptionapp.dao.AdopterDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryAdopterDAO implements AdopterDAO {

    private Map<Integer, Adopter> adopters = new HashMap<>();
    private int nextId = 1;
    @Override
    public Adopter insert(Adopter adopter) {
        int id = nextId++;
        adopter.setId(id);
        adopter.setName(adopter.getName());

        adopters.put(adopter.getId(), adopter);
        return adopter;
    }

    @Override
    public boolean delete(int id) {
        return adopters.remove(id) != null;
    }

    @Override
    public boolean update(Adopter adopter) {
        return adopters.replace(adopter.getId(), adopter) != null;
    }

    @Override
    public Adopter findBy(int id) {
        return adopters.get(id);
    }

    @Override
    public Adopter findBy(String name) {
        Map.Entry<Integer, Adopter> result = adopters.entrySet().stream()
                .filter(a-> a.getValue().getName().equals(name))
                .findFirst().orElse(null);
        return result != null ? result.getValue() : null;
    }

    @Override
    public List<Adopter> findAll() {
        return new ArrayList<>(adopters.values());
    }

    @Override
    public List<Adopter> sortByNaturalOrder() {
        return new ArrayList<>(adopters.values()).stream().sorted().toList();
    }

    @Override
    public List<Adopter> sortByName() {
        return adopters.values().stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
    }
}
