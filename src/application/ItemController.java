package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ItemController {
	@FXML
    private TextField categ;

    @FXML
    private TableColumn<ItemData, String> dataCategory;

    @FXML
    private TableColumn<ItemData, String> dataId;

    @FXML
    private TableColumn<ItemData, String> dataItemName;

    @FXML
    private TableColumn<ItemData, String> dataPrice;

    @FXML
    private TableColumn<ItemData, String> dataQuantity;

    @FXML
    private TextField id;

    @FXML
    private TextField item;

    @FXML
    private TableView<ItemData> itemtab;

    @FXML
    private TextField price;

    @FXML
    private TextField quantity;
    
    @FXML
	private ObservableList<ItemData> data;


public void Displaydata(ActionEvent event) {
	try {
		Connection con=Sqliteconnection.connector();
		this.data=FXCollections.observableArrayList();
		ResultSet rs=con.createStatement().executeQuery("select * from item");
		
		while(rs.next()) {
			this.data.add(new ItemData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	this.dataId.setCellValueFactory(new PropertyValueFactory<ItemData, String>("Id"));
	this.dataItemName.setCellValueFactory(new PropertyValueFactory<ItemData, String>("Item"));
	this.dataCategory.setCellValueFactory(new PropertyValueFactory<ItemData,String>("categ"));
	this.dataPrice.setCellValueFactory(new PropertyValueFactory<ItemData, String>("price"));
	this.dataQuantity.setCellValueFactory(new PropertyValueFactory<ItemData,String>("quantity"));
	this.itemtab.setItems(null);
	this.itemtab.setItems(this.data);
	}
public void InsertData(ActionEvent event) {
	System.out.println("Item Added successfully");
	try {
		Connection con=Sqliteconnection.connector();
		PreparedStatement prs=con.prepareStatement("insert into item (Itemname,Category,Price,Quantity)values(?,?,?,?)");
		//prs.setString(1,this.id.getText());
		prs.setString(1,this.item.getText());
		prs.setString(2,this.categ.getText());
		prs.setString(3,this.price.getText());
		prs.setString(4,this.quantity.getText());
		prs.executeUpdate();
		con.close();
		}
	catch(Exception e) {
		e.printStackTrace();
	}
	Displaydata(event);
	}
public void Delete(ActionEvent event) {
	System.out.println("Cleared");
	try {
		Connection con=Sqliteconnection.connector();
		PreparedStatement prs1=con.prepareStatement("delete from item where Itemname=?");
		prs1.setString(1,this.item.getText());
		//prs1.setString(1,this.pass.getText());
		prs1.executeUpdate();
		con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	Displaydata(event);
	}


public void update(ActionEvent event) {
	System.out.println("update data");
	try
	{
		Connection con=Sqliteconnection.connector();
		PreparedStatement prs2=con.prepareStatement("update item set Itemname=? where "+"Quantity=?");
		prs2.setString(1,this.item.getText());
		prs2.setString(2,this.quantity.getText());
		prs2.executeUpdate();
		con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	Displaydata(event);
}
}

