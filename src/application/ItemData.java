package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemData {
	StringProperty Id;
	StringProperty Item;
	StringProperty categ;
	StringProperty price;
	StringProperty quantity;

	public ItemData(String Id,String Item,String categ,String price,String quantity) {
		this.Id=new SimpleStringProperty(Id);
		this.Item=new SimpleStringProperty(Item);
		this.categ=new SimpleStringProperty(categ);
		this.price=new SimpleStringProperty(price);
		this.quantity=new SimpleStringProperty(quantity);
	}
	public StringProperty IdProperty() {
		return this.Id;
	}
	

	public String getId() {
		return this.IdProperty().get();
	}
	

	public void setId(final String Id) {
		this.IdProperty().set(Id);
	}
	

	public StringProperty ItemProperty() {
		return this.Item;
	}
	

	public String getItem() {
		return this.ItemProperty().get();
	}
	

	public void setItem(final String Item) {
		this.ItemProperty().set(Item);
	}
	

	public StringProperty categProperty() {
		return this.categ;
	}
	

	public String getcateg() {
		return this.categProperty().get();
	}
	

	public void setcateg(final String categ) {
		this.categProperty().set(categ);
	}
	
	public StringProperty priceProperty() {
		return this.price;
	}
	

	public String getprice() {
		return this.priceProperty().get();
	}
	

	public void setprice(final String price) {
		this.priceProperty().set(price);
	}
	
	
	public StringProperty quantityProperty() {
		return this.quantity;
	}
	

	public String getquantity() {
		return this.quantityProperty().get();
	}
	

	public void setquantity(final String quantity) {
		this.quantityProperty().set(quantity);
	}
	
	
	
}
