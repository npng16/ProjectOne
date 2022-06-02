package com.revature.pms.dao;

import com.revature.pms.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDAO extends JpaRepository<Item, Integer> {
    @Query("SELECT i FROM Item i ")
    public List<Item> getAllItems();
}
