package com.chefmattalter.models;
import jakarta.persistence.*;

@Entity
@Table(name = "line_items")
public class LineItem {
    public LineItem(Order order, String menuItem, int quantity, double price) {
        this.order = order;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(nullable = false)
    private String menuItem; // Name of the menu item

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price; // Price per item


    // Getters and Setters
    public long getId() {
        return this.id;
    }
    public Order getOrder() {
        return this.order;
    }

    public String getMenuItem() {
        return this.menuItem;
    }
    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }
}
