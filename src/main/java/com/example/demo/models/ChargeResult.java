package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "charge_results")
public class ChargeResult {
    @Id
    @Column(name = "id")
    public String id;

    @Column(name = "status")
    public String status;

    @Column(name = "charge_id")
    public String chargeId;

    @Column(name = "balance_transaction")
    public String balanceTransaction;

    public ChargeResult() {
    }

    public ChargeResult(String id, String status, String chargeId, String balanceTransaction) {
        this.id = id;
        this.status = status;
        this.chargeId = chargeId;
        this.balanceTransaction = balanceTransaction;
    }
}
