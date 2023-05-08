package pro.sky.spring.service;

import org.springframework.stereotype.Service;
import pro.sky.spring.component.Basket;
import pro.sky.spring.model.Item;
import pro.sky.spring.repository.StoreReposiory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final Basket basket;
    private final StoreReposiory storeReposiory;

    public StoreService(Basket basket, StoreReposiory storeReposiory) {
        this.basket = basket;
        this.storeReposiory = storeReposiory;
    }
    public void add(Set<Integer> ids) {
        basket.add(ids);
    }

    public List<Item> get() {
        return basket.get().stream()
                .map(id ->storeReposiory.get(id))
                .collect(Collectors.toList());
    }
}


