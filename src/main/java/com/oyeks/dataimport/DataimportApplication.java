package com.oyeks.dataimport;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class DataimportApplication {

    public static void main(String[] args) throws ParseException {

//        public static Date convertStringToDate(String dateString) throws ParseException {

        String dateString = "0221094206";

            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR);
            dateString = currentYear + dateString;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

            Date fmtedDate =  sdf.parse(dateString);

            System.out.println("FORMATTED DATE: " + fmtedDate);
        }
//        JSONParser jsonParser = new JSONParser();
//
//        try (FileReader reader = new FileReader("/Users/MacBook/Downloads/ecobank.json")) {
//            // Read JSON file
//            Object obj = jsonParser.parse(reader);
//
//            // Assuming the top-level object is a JSON object with a key "data"
//            JSONObject jsonObject = (JSONObject) obj;
//
//            // Extract the "data" array
//            JSONArray data = (JSONArray) jsonObject.get("data");
//
//            // Iterate over the array
//            data.forEach(emp -> parseDataObject((JSONObject) emp));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (org.json.simple.parser.ParseException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static void parseDataObject(JSONObject data) {
//        // Access the properties directly, as data is already an individual transaction object
//        Long terminalId = (Long) data.get("terminalId");
//        System.out.println("Terminal ID: " + terminalId);
//
//        String name = (String) data.get("name");
//        System.out.println("Name: " + name);
//
//        String rrn = (String) data.get("rrn");
//        System.out.println("RRN: " + rrn);
//    }


//        }

//        String jdbcURL = "jdbc:mysql://localhost:3306/sales";
//        String jdbcURL = "jdbc:postgresql://localhost:5432/sampleimport";
//        String jdbcURL = "jdbc:postgresql://31.222.229.46:5432/tmsdb";
//        String username = "agency";
//        String password = "agency";
//
//        String csvFilePath = "/Users/MacBook/Downloads/Import-Sheet1.csv";
//
//        int batchSize = 20;
//
//        Connection connection = null;
//
//        ICsvBeanReader beanReader = null;
//        CellProcessor[] processors = new CellProcessor[] {
//                new Optional(),  // transaction_id
//                new Optional(),  // stan
//                new Optional(),  // acknowledged_by_agent_manager
//                new Optional(),  // acquiring_institution_code
//                new Optional(),  // amount
//                new ParseBigDecimalWithFormat("#,##0.00"),  // Use your format
//                new Optional(new ParseDate("MM/dd/yy HH:mm")),  // transaction_date_time
//                new Optional(),  // beneficiary_account_number
//                new Optional(),  // beneficiary_bank_code
//                new Optional(),  // beneficiary_name
//                new Optional(),  // card_sequence_number
//                new Optional(),  // cbnacquirer_id
//                new Optional(),  // customer_reference
//                new Optional(),  // electricity_type
//                new Optional(),  // merchant_id
//                new Optional(),  // merchant_type
//                new Optional(),  // network
//                new Optional(),  // pan_masked
//                new Optional(),  // phone_number
//                new Optional(),  // plan_id
//                new Optional(),  // pos_entry_mode
//                new Optional(),  // processing_institution_code
//                new Optional(),  // response_code
//                new Optional(),  // retrieval_reference_number
//                new Optional(),  // smart_card_number
//                new Optional(),  // status
//                new Optional(),  // terminal_id
//                new Optional(),  // time_completed
//                new Optional(),  // transaction_currency
//                new Optional(),  // transaction_type
//                new Optional(),  // transmission_date_time
//                new Optional(),  // system_acquirer_id
//                new Optional(),  // agent_token
//                new Optional()   // channel
//        };
//
//        try {
//            long start = System.currentTimeMillis();
//
//            connection = DriverManager.getConnection(jdbcURL, username, password);
//            connection.setAutoCommit(false);
//
//            String sql = "insert into tbl_transactions (transaction_id, stan, acknowledged_by_agent_manager, acquiring_institution_code, amount,\n" +
//                    "                              authorization_id_response, beneficiary_account_number, beneficiary_bank_code,\n" +
//                    "                              beneficiary_name, card_sequence_number, cbnacquirer_id, customer_reference,\n" +
//                    "                              electricity_type, merchant_id, merchant_type, network, pan_masked, phone_number, plan_id,\n" +
//                    "                              pos_entry_mode, processing_institution_code, response_code, retrieval_reference_number,\n" +
//                    "                              smart_card_number, status, terminal_id, time_completed, transaction_currency,\n" +
//                    "                              transaction_date_time, transaction_type, transmission_date_time, system_acquirer_id,\n" +
//                    "                              agent_token, channel)\n" +
//                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//            PreparedStatement statement = connection.prepareStatement(sql);
//
//            beanReader = new CsvBeanReader(new FileReader(csvFilePath),
//                    CsvPreference.STANDARD_PREFERENCE);
//
//            beanReader.getHeader(true); // skip header line
//
//            String[] header = {
//                    "transaction_id", "stan", "acknowledged_by_agent_manager", "acquiring_institution_code", "amount",
//                    "authorization_id_response", "beneficiary_account_number", "beneficiary_bank_code",
//                    "beneficiary_name", "card_sequence_number", "cbnacquirer_id", "customer_reference",
//                    "electricity_type", "merchant_id", "merchant_type", "network", "pan_masked", "phone_number", "plan_id",
//                    "pos_entry_mode", "processing_institution_code", "response_code", "retrieval_reference_number",
//                    "smart_card_number", "status", "terminal_id", "time_completed", "transaction_currency",
//                    "transaction_date_time", "transaction_type", "transmission_date_time", "system_acquirer_id",
//                    "agent_token", "channel"
//            };
//            Transactions bean = null;
//
//            int count = 0;
//
//            while ((bean = beanReader.read(Transactions.class, header, processors)) != null) {
//
//                String transactionId = generateRandomTransactionId();
//                String stan = generateRandomStan();
//                String responseCode = bean.getResponse_code();
//                String authorizationIdResponse = bean.getAuthorization_id_response();
//                String transmissionDateTime = bean.getTransmission_date_time();
//                String timeCompleted = bean.getTime_completed();
//                String cbnacquirerId = bean.getCbnacquirer_id();
//                String acquiringInstitutionCode = bean.getAcquiring_institution_code();
//                String processingInstitutionCode = bean.getProcessing_institution_code();
//                String terminalId = bean.getTerminal_id();
//                String merchantId = bean.getMerchant_id();
//                String cardSequenceNumber = bean.getCardSequence_number();
//                String posEntryMode = bean.getPos_entry_mode();
//                Date transactionDateTime = bean.getTransaction_date_time();
//                String planId = bean.getPlan_id();
//                String beneficiaryAccountNumber = bean.getBeneficiary_account_number();
//                String beneficiaryName = bean.getBeneficiary_name();
//                String beneficiaryBankCode = bean.getBeneficiary_bank_code();
//                String electricityType = bean.getElectricity_type();
//                String customerReference = bean.getCustomer_reference();
//                String smartCardNumber = bean.getSmart_card_number();
//                Boolean acknowledgedByAgentManager = bean.getAcknowledged_by_agent_manager();
//                String amount = bean.getAmount();
//                String transactionCurrency = bean.getTransaction_currency();
//                String retrievalReferenceNumber = bean.getRetrieval_reference_number();
//                String transactionType = bean.getTransaction_type();
//                String acquirer = bean.getSystem_acquirer_id();
//                String panMasked = generateMaskedPan();
//
//                statement.setString(1, transactionId);
//                statement.setString(2, stan);
//                statement.setString(3, null); // Assuming acknowledgedByAgentManager is a Boolean
//                statement.setString(4, acquiringInstitutionCode);
//                statement.setString(5, amount);
//                statement.setString(6, authorizationIdResponse);
//                statement.setString(7, beneficiaryAccountNumber);
//                statement.setString(8, beneficiaryBankCode);
//                statement.setString(9, beneficiaryName);
//                statement.setString(10, cardSequenceNumber);
//                statement.setString(11, cbnacquirerId);
//                statement.setString(12, customerReference);
//                statement.setString(13, electricityType);
//                statement.setString(14, merchantId);
//                statement.setString(15, null);
//                statement.setString(16, null);
//                statement.setString(17, panMasked);
//                statement.setString(18, null);
//                statement.setString(19, planId);
//                statement.setString(20, posEntryMode);
//                statement.setString(21, processingInstitutionCode);
//                statement.setString(22, responseCode);
//                statement.setString(23, retrievalReferenceNumber);
//                statement.setString(24, smartCardNumber);
//                statement.setString(25, null);
//                statement.setString(26, terminalId);
//                statement.setString(27, timeCompleted);
//                statement.setString(28, transactionCurrency);
//                statement.setString(29, null); // Assuming transactionDateTime is a Date
//                statement.setString(30, transactionType);
//                statement.setString(31, transmissionDateTime);
//                statement.setString(32, "ECOB01022024035243");
//                statement.setString(33, null);
//                statement.setString(34, null);
//
//                statement.addBatch();
//
//                count++;
//
//                if (count % batchSize == 0) {
//                    statement.executeBatch();
//                }
//            }
//
//// execute the remaining queries
//            statement.executeBatch();
//
//            connection.commit();
//            connection.close();
//
//            long end = System.currentTimeMillis();
//            System.out.println("Execution Time: " + (end - start));
//
//
//        } catch (IOException ex) {
//            System.err.println(ex);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//
//            try {
//                connection.rollback();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//



    private static String generateRandomStan() {
        Random random = new Random();
        return String.format("%010d", random.nextInt(1000000000));
    }

//    private static String generateMaskedPan() {
//        return "519911******9143";
//    }

    private static String generateMaskedPan() {
        Random random = new Random();
        int randomNUmbers = 1000 + random.nextInt(9000);
        return randomNUmbers + "******" + randomNUmbers;
    }


    private static String generateRandomTransactionId() {
        Random random = new Random();
        int randNumber = 10000000 + random.nextInt(90000000); // 8-digit random number
        return "TMS" + randNumber + "R" + System.currentTimeMillis();
    }
}