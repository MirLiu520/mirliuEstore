package com.briup.estore.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class EOrder implements Serializable {
    private Integer id;

    private double total;

    private Date orderdate;

    private Integer customerId;

    private static final long serialVersionUID = 1L;
    
    private Collection<EOrderline> lines;

    public Collection<EOrderline> getLines() {
		return lines;
	}

	public void setLines(Collection<EOrderline> lines) {
		this.lines = lines;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}