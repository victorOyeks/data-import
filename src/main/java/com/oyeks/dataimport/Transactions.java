package com.oyeks.dataimport;

import java.sql.Date;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tbl_transactions")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {

    @Id
    private String  transaction_id;

    private String STAN;
    private String response_code;
    private String authorization_id_response;
    private String transmission_date_time;
    private String time_completed;
    private String cbnacquirer_id;
    private String acquiring_institution_code;
    private String processing_institution_code;
    private String terminal_id;
    private String merchant_id;
    private String cardSequence_number;
    private String pan_masked;
    private String pos_entry_mode;

    private Date transaction_date_time;

    private String phone_number;
    private String network;
    private String plan_id;

    private String beneficiary_account_number;
    private String beneficiary_name;
    private String beneficiary_bank_code;

    private String electricity_type;
    private String customer_reference;

    private String smart_card_number;
    private Boolean acknowledged_by_agent_manager;

    @Column(length = 4000, columnDefinition = "VARCHAR")
    private String agent_token;

    private String channel;

    private String status;
    private String merchant_type;
    private String amount;
    private String transaction_currency;

    @Column(unique = true)
    private String retrieval_reference_number;

    private String transaction_type;

    private String system_acquirer_id;

}
