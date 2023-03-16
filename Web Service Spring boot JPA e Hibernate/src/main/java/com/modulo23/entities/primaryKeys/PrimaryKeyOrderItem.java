package com.modulo23.entities.primaryKeys;

import com.modulo23.entities.Order;
import com.modulo23.entities.Product;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable //para dizer que a classe é um subtipo de outra classe
public class PrimaryKeyOrderItem implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        @ManyToOne
        @JoinColumn(name = "identificador_pedido")
        private Order order;

        @ManyToOne
        @JoinColumn(name = "identificador_produto")
        private Product product;

        //?---------------------------------------   Getters and Setters   -------------------------------------------------

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
        //?---------------------------------------   HashCode and Equals   -------------------------------------------------

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PrimaryKeyOrderItem that)) return false;
            return getOrder().equals(that.getOrder()) && getProduct().equals(that.getProduct());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getOrder(), getProduct());
        }
}
