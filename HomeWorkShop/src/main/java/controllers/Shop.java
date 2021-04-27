package controllers;

import entity.Product;
import entity.User;
import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<User> users = new ArrayList<User>();

    public String createUser(User newUser){
        users.add(newUser);
        return "user created successfully";
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public String createProduct(Product product){
        products.add(product);
        return "product created successfully";
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public String buyProduct(String productName, String userEmail, Integer noOfProduct){
        Product productToSell = findProductByName(productName);
        if(productToSell == null){ return "product not found"; }
        if(productToSell.getQuantity() < noOfProduct) { return "not enough items to fulfill your order";}

        User buyer = findUserByEmail(userEmail);
        if(buyer == null){ return "user not found"; }

        float buyerBalance = buyer.getBalance();
        float totalCostOfPurchase = productToSell.getPrice() * noOfProduct;

        if(buyerBalance < totalCostOfPurchase ) { return "not enough balance on users account";}

        buyer.setBalance(buyerBalance - totalCostOfPurchase);
        productToSell.setQuantity(productToSell.getQuantity() - noOfProduct);

        updateUser(buyer);

        return "Product purchase successful";
    }

    private Product findProductByName(String productName) {
        for (Product currentProduct: this.products){
            if(currentProduct.getName().toLowerCase().equals(productName.toLowerCase())){
                return currentProduct;
            }
        }
        return null;
    }

    private User findUserByEmail(String userEmail) {
        for (User currentUser: this.users){
            if(currentUser.getEmail().toLowerCase().equals(userEmail.toLowerCase())){
                return currentUser;
            }
        }
        return null;
    }

    private void updateUser(User userToUpdate){
        for (User currentUser: this.users){
            if(currentUser.getId().equals(userToUpdate.getId())){
                currentUser.setBalance(userToUpdate.getBalance());
                // its possible to update something more here
            }
        }
    }
}
