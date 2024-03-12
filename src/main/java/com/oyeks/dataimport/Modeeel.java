//package com.oyeks.dataimport;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Entity
//@Table
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Modeeel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String affiliate;
//    private String agentcode;
//    private String terminalid;
//    private String agentname;
//    private String rrn;
//    @Column(name = "transactionamount", precision = 10, scale = 2)
//    private BigDecimal transactionamount;
//    @Column(name = "transactiondatetime")
//    private Date transactiondatetime;
//    private String transactionnarration;
//    private String transactiontype;
//}
//
