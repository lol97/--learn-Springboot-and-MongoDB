package com.aglistech.mongoboot.groceryitem;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomItemRepository {
	void updateItemQuantity(String name, float newQuantity);
}
