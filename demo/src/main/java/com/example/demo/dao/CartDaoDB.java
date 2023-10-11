package com.example.demo.dao;

import com.example.demo.domain.Cart;
import com.example.demo.domain.CartItem;
import com.example.demo.domain.Customer;
import com.example.demo.domain.StatusType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import static com.example.demo.domain.StatusType.*;

public class CartDaoDB implements CartDao {

    @Override
    public Cart getCartById(Long id) {
        return null;
    }

    @Override
    public Set<Cart> getAllCarts() {
        return null;
    }

    @Override
    public Cart addCart(Cart cart) {
        return null;
    }

    @Override
    public void updateCart(Cart cart) {

    }

    @Override
    public void deleteCartById(Long id) {

    }

    @Override
    public Set<CartItem> getCartItemsForCart(Cart cart) {
        return null;
    }

    @Override
    public Customer getCustomerForCart(Cart cart) {
        return null;
    }

    public static final class CartMapper implements RowMapper<Cart> {

        @Override
        public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cart cart = new Cart();
            cart.setId(rs.getLong("id"));
            cart.setOrderTrackingNumber(rs.getString("orderTrackingNumber"));
            cart.setPackage_price(rs.getBigDecimal("package_price"));
            cart.setPart_size(rs.getInt("part_size"));
            cart.setStatus(setCartStatus(rs.getString("status")));
            cart.setCreate_date(rs.getDate("create_date"));
            cart.setLast_update((rs.getDate("last_update")));

            return cart;
        }

        private StatusType setCartStatus(String rs) {
            switch(rs.toUpperCase()) {
                case "PENDING":
                    return PENDING;
                case "ORDERED":
                    return ORDERED;
                case "CANCELLED":
                    return CANCELLED;
                default:
                    throw new UnsupportedOperationException("Unknown order status:" + rs);
            }
        }
    }
}



