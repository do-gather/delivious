//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dogather.delivious.domain.order.entity;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "order"
)
public class entity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private UUID order_id;
    private UUID user_id;
    private UUID table_id;
    private Integer total_count;
    private Integer total_price;
    private String status_now;
    private Timestamp created_at;

    public entity(UUID order_id, UUID user_id, UUID table_id, Integer total_count, Integer total_price, String status_now, Timestamp created_at) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.table_id = table_id;
        this.total_count = total_count;
        this.total_price = total_price;
        this.status_now = status_now;
        this.created_at = created_at;
    }

    public UUID getOrder_id() {
        return this.order_id;
    }

    public UUID getUser_id() {
        return this.user_id;
    }

    public UUID getTable_id() {
        return this.table_id;
    }

    public Integer getTotal_count() {
        return this.total_count;
    }

    public Integer getTotal_price() {
        return this.total_price;
    }

    public String getStatus_now() {
        return this.status_now;
    }

    public Timestamp getCreated_at() {
        return this.created_at;
    }

    public void setOrder_id(final UUID order_id) {
        this.order_id = order_id;
    }

    public void setUser_id(final UUID user_id) {
        this.user_id = user_id;
    }

    public void setTable_id(final UUID table_id) {
        this.table_id = table_id;
    }

    public void setTotal_count(final Integer total_count) {
        this.total_count = total_count;
    }

    public void setTotal_price(final Integer total_price) {
        this.total_price = total_price;
    }

    public void setStatus_now(final String status_now) {
        this.status_now = status_now;
    }

    public void setCreated_at(final Timestamp created_at) {
        this.created_at = created_at;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof entity)) {
            return false;
        } else {
            entity other = (entity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$total_count = this.getTotal_count();
                    Object other$total_count = other.getTotal_count();
                    if (this$total_count == null) {
                        if (other$total_count == null) {
                            break label95;
                        }
                    } else if (this$total_count.equals(other$total_count)) {
                        break label95;
                    }

                    return false;
                }

                Object this$total_price = this.getTotal_price();
                Object other$total_price = other.getTotal_price();
                if (this$total_price == null) {
                    if (other$total_price != null) {
                        return false;
                    }
                } else if (!this$total_price.equals(other$total_price)) {
                    return false;
                }

                Object this$order_id = this.getOrder_id();
                Object other$order_id = other.getOrder_id();
                if (this$order_id == null) {
                    if (other$order_id != null) {
                        return false;
                    }
                } else if (!this$order_id.equals(other$order_id)) {
                    return false;
                }

                label74: {
                    Object this$user_id = this.getUser_id();
                    Object other$user_id = other.getUser_id();
                    if (this$user_id == null) {
                        if (other$user_id == null) {
                            break label74;
                        }
                    } else if (this$user_id.equals(other$user_id)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$table_id = this.getTable_id();
                    Object other$table_id = other.getTable_id();
                    if (this$table_id == null) {
                        if (other$table_id == null) {
                            break label67;
                        }
                    } else if (this$table_id.equals(other$table_id)) {
                        break label67;
                    }

                    return false;
                }

                Object this$status_now = this.getStatus_now();
                Object other$status_now = other.getStatus_now();
                if (this$status_now == null) {
                    if (other$status_now != null) {
                        return false;
                    }
                } else if (!this$status_now.equals(other$status_now)) {
                    return false;
                }

                Object this$created_at = this.getCreated_at();
                Object other$created_at = other.getCreated_at();
                if (this$created_at == null) {
                    if (other$created_at != null) {
                        return false;
                    }
                } else if (!this$created_at.equals(other$created_at)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof entity;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $total_count = this.getTotal_count();
        int result = result * 59 + ($total_count == null ? 43 : $total_count.hashCode());
        Object $total_price = this.getTotal_price();
        result = result * 59 + ($total_price == null ? 43 : $total_price.hashCode());
        Object $order_id = this.getOrder_id();
        result = result * 59 + ($order_id == null ? 43 : $order_id.hashCode());
        Object $user_id = this.getUser_id();
        result = result * 59 + ($user_id == null ? 43 : $user_id.hashCode());
        Object $table_id = this.getTable_id();
        result = result * 59 + ($table_id == null ? 43 : $table_id.hashCode());
        Object $status_now = this.getStatus_now();
        result = result * 59 + ($status_now == null ? 43 : $status_now.hashCode());
        Object $created_at = this.getCreated_at();
        result = result * 59 + ($created_at == null ? 43 : $created_at.hashCode());
        return result;
    }

    public String toString() {
        UUID var10000 = this.getOrder_id();
        return "User(order_id=" + var10000 + ", user_id=" + this.getUser_id() + ", table_id=" + this.getTable_id() + ", total_count=" + this.getTotal_count() + ", total_price=" + this.getTotal_price() + ", status_now=" + this.getStatus_now() + ", created_at=" + this.getCreated_at() + ")";
    }
}
