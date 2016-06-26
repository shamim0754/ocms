package com.deltagroupbd.ocms.merchandising.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity(name="order_basic_info")
public class OrderBasic implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Size(min=2, max=30)
    @Column(name="buyer_name", length=50, nullable=true)
    private String buyerName;

    @NotNull
    @Column(name="mkt_name", length=50, nullable=true)
    private String mktHeadName;
    
    //only need for the sake of JPA 
    public OrderBasic() {

    }

    //for create object by JPA 
    public OrderBasic(long id , String buyerName, String mktHeadName) {
        this.id = id;
        this.buyerName = buyerName;
        this.mktHeadName = mktHeadName;
    }
    
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
    
    public String getBuyerName() {
        return buyerName;
    }
 
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
    public String getMktHeadName() {
        return mktHeadName;
    }
 
    public void setMktHeadName(String mktHeadName) {
        this.mktHeadName = mktHeadName;
    }
}



    
    