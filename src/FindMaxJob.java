import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arnab.ray on 12/10/17.
 */
public class FindMaxJob {


    public static boolean should_allow_charge(List<String> charge_and_rules) {
        // Write your code here
        Map<String, String> transactionMap = new HashMap<>();
        boolean evaluate;
        for(String inputStr : charge_and_rules) {
            String str = inputStr.replaceAll("\\s+", "");
            String[] ruleSplit = str.split(":");
            // For CHARGE store the pairs in map
            if(ruleSplit[0].equals("CHARGE")) {
                String[] chargeValues = ruleSplit[1].split("&");
                for(String chargeValue : chargeValues) {
                    String[] keyAndVal = chargeValue.split("=");
                    transactionMap.put(keyAndVal[0], keyAndVal[1]);
                }
            }
            else if(ruleSplit[0].equals("ALLOW")) {
                evaluate = false;
                if(!ruleSplit[1].contains("AND") || !ruleSplit[1].contains("OR")) {
                    if(ruleSplit[1].contains("==")) {
                        String[] keyAndVal = ruleSplit[1].split("==");
                        String val = transactionMap.get(keyAndVal[0]);
                        if(val.equals(keyAndVal[1]) ||
                                (transactionMap.keySet().contains(keyAndVal[1]) && val.equals(transactionMap.get(keyAndVal[1]))))
                            evaluate = true;
                        else
                            evaluate = false;
                    } else {
                        String[] keyAndVal = ruleSplit[1].split("!=");
                        String val = transactionMap.get(keyAndVal[0]);
                        if(val.equals(keyAndVal[1]) ||
                                (transactionMap.keySet().contains(keyAndVal[1]) && val.equals(transactionMap.get(keyAndVal[1]))))
                            evaluate = false;
                        else
                            evaluate = true;
                    }
                }
                else if(ruleSplit[1].contains("AND")) {
                    String[] compoundOps = ruleSplit[1].split("AND");
                    for(String compoundOp : compoundOps) {
                        if(compoundOp.contains("==")) {
                            String[] keyAndVal = compoundOp.split("==");
                            String val = transactionMap.get(keyAndVal[0]);
                            if(val.equals(keyAndVal[1]) ||
                                    (transactionMap.keySet().contains(keyAndVal[1]) && val.equals(transactionMap.get(keyAndVal[1]))))
                                evaluate = evaluate && true;
                            else
                                evaluate = evaluate && false;
                        } else {
                            String[] keyAndVal = compoundOp.split("!=");
                            String val = transactionMap.get(keyAndVal[0]);
                            if(val.equals(keyAndVal[1]) ||
                                    (transactionMap.keySet().contains(keyAndVal[1]) && val.equals(transactionMap.get(keyAndVal[1]))))
                                evaluate = evaluate && false;
                            else
                                evaluate = evaluate && true;
                        }
                    }
                } else if(ruleSplit[1].contains("OR")) {
                    String[] compoundOps = ruleSplit[1].split("OR");
                    for(String compoundOp : compoundOps) {
                        if(compoundOp.contains("==")) {
                            String[] keyAndVal = compoundOp.split("==");
                            String val = transactionMap.get(keyAndVal[0]);
                            if(val.equals(keyAndVal[1]) ||
                                    (transactionMap.keySet().contains(keyAndVal[1]) && val.equals(transactionMap.get(keyAndVal[1]))))
                                evaluate = evaluate || true;
                            else
                                evaluate = evaluate || false;
                        } else {
                            String[] keyAndVal = compoundOp.split("!=");
                            String val = transactionMap.get(keyAndVal[0]);
                            if(val.equals(keyAndVal[1]) ||
                                    (transactionMap.keySet().contains(keyAndVal[1]) && val.equals(transactionMap.get(keyAndVal[1]))))
                                evaluate = evaluate || false;
                            else
                                evaluate = evaluate || true;
                        }
                    }
                }

                if(evaluate)
                    return evaluate;
            }
            // case for BLOCK
            else {
                evaluate = false;

                if(!ruleSplit[1].contains("AND") && !ruleSplit[1].contains("OR")) {
                    if(ruleSplit[1].contains("==")) {
                        String[] keyAndVal = ruleSplit[1].split("==");
                        String val = transactionMap.get(keyAndVal[0]);
                        if(val.equals(keyAndVal[1]) ||
                                (transactionMap.keySet().contains(keyAndVal[1]) && val.equals(transactionMap.get(keyAndVal[1]))))
                            evaluate = true;
                        else
                            evaluate = false;
                    } else {
                        String[] keyAndVal = ruleSplit[1].split("!=");
                        String val = transactionMap.get(keyAndVal[0]);
                        if(val.equals(keyAndVal[1]) ||
                                (transactionMap.keySet().contains(keyAndVal[1]) && val.equals(transactionMap.get(keyAndVal[1]))))
                            evaluate = false;
                        else
                            evaluate = true;
                    }
                } else if(ruleSplit[1].contains("AND")) {
                    String[] compoundOps = ruleSplit[1].split("AND");
                    for(String compoundOp : compoundOps) {
                        if(compoundOp.contains("==")) {
                            String[] keyAndVal = compoundOp.split("==");
                            String val = transactionMap.get(keyAndVal[0]);
                            if(val.equals(keyAndVal[1]) ||
                                    (transactionMap.keySet().contains(keyAndVal[1]) && val.equals(transactionMap.get(keyAndVal[1]))))
                                evaluate = evaluate && true;
                            else
                                evaluate = evaluate && false;
                        } else {
                            String[] keyAndVal = compoundOp.split("!=");
                            String val = transactionMap.get(keyAndVal[0]);
                            if(val.equals(keyAndVal[1]) ||
                                    (transactionMap.keySet().contains(keyAndVal[1]) && val.equals(transactionMap.get(keyAndVal[1]))))
                                evaluate = evaluate && false;
                            else
                                evaluate = evaluate && true;
                        }
                    }
                } else if(ruleSplit[1].contains("OR")) {
                    String[] compoundOps = ruleSplit[1].split("OR");
                    for(String compoundOp : compoundOps) {
                        if(compoundOp.contains("==")) {
                            String[] keyAndVal = compoundOp.split("==");
                            String val = transactionMap.get(keyAndVal[0]);
                            if(val.equals(keyAndVal[1]) ||
                                    (transactionMap.keySet().contains(keyAndVal[1]) && val.equals(transactionMap.get(keyAndVal[1]))))
                                evaluate = evaluate || true;
                            else
                                evaluate = evaluate || false;
                        } else {
                            String[] keyAndVal = compoundOp.split("!=");
                            String val = transactionMap.get(keyAndVal[0]);
                            if(val.equals(keyAndVal[1]) ||
                                    (transactionMap.keySet().contains(keyAndVal[1]) && val.equals(transactionMap.get(keyAndVal[1]))))
                                evaluate = evaluate || false;
                            else
                                evaluate = evaluate || true;
                        }
                    }
                }

                if(evaluate)
                    return !evaluate;
            }
        }

        return true;

    }
    public static void main(String[] args) {
        List<String> charge_and_rules = new ArrayList<>();
        charge_and_rules.add("CHARGE: amount=300&card_country=US&currency=MYR&ip_country=MY");
        charge_and_rules.add("BLOCK: amount==100");
        charge_and_rules.add("BLOCK: amount==200");
        charge_and_rules.add("BLOCK: amount==300");
        charge_and_rules.add("BLOCK: amount==400");
        //charge_and_rules.add("ALLOW: card_country == ip_country");
        charge_and_rules.add("BLOCK: amount==500");
        //charge_and_rules.add("BLOCK: ip_country == SG");
        //charge_and_rules.add("BLOCK: currency == SDG");
        System.out.println(should_allow_charge(charge_and_rules));
    }
}
