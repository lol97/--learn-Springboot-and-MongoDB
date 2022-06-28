package com.aglistech.mongoboot.groceryitem;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;

@Service
public class CustomItemRepositoryImpl implements CustomItemRepository{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void updateItemQuantity(String name, float newQuantity) {
		Query query = new Query(Criteria.where("name").is(name));
		Update update = new Update();
		update.set("quantity", newQuantity);
		
		UpdateResult updateFirst = mongoTemplate.updateFirst(query, update, GroceryItem.class);
		
		if(updateFirst == null) {
			System.out.println(MessageFormat.format("Document with name {0} not found", name));
		}else {
			System.out.println(MessageFormat.format("Document with name {0} the quantity updated to {1}", name, newQuantity));
		}
		
	}

}
