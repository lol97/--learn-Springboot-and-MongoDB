package com.aglistech.mongoboot.groceryitem;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document(value = "groceryitems")
@AllArgsConstructor
@Setter
@Getter
public class GroceryItem {
	@Id
	private String id;

	private String name;
	private int quantity;
	private String category;
}
