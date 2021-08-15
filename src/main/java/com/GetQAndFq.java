package com;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GetQAndFq {
    public static void main(String[] args) {
        String solrQuery = "/browse?spellcheck.collateExtendedResults=true&f.item_location_region_facets.facet.sort=count&facet.field={!key%3DsellerTier+ex%3Dst}seller_tier&facet.field={!key%3Dlocation+ex%3Dlc}item_location_region_facets&facet.field={!key%3Dcreator+ex%3Dcr}creator_facets&facet.field={!key%3DcategoryL1+ex%3Dl1}seller_vertical_facets&facet.field={!key%3Dperiod+ex%3Dpr}attr_opt_facet_period&facet.field={!key%3DonSale}on_sale&facet.field={!key%3DsellerRecognized+ex%3Dsr}seller_distinguished_status&qt=/browse&spellcheck.dictionary=fileSpellchecker&bf=recip(ms(NOW/HOUR,marketplace_publish_date),3.16e-11,1,1)&fl=id,[child+parentFilter%3D\\\"doc_type:item\\\"]&spellcheck.maxCollations=10&start=0&f.item_location_region_facets.facet.limit=-1&sort=score+desc,release_date+desc&fq=doc_type:item&fq=marketplace_publication_status:PUBLISHED&fq=item_status:COMPLETE+OR+(item_status:UNAVAILABLE+AND+unavailable_reason_code:(ON_HOLD+ON_HOLD_CUSTOM))&fq=seller_status:(active+nopay)&spellcheck.maxCollationTries=5&rows=60&q=dioscuri&json.facet={}&f.attr_opt_facet_period.facet.limit=-1&spellcheck.maxResultsForSuggest=30&spellcheck.q=dioscuri&spellcheck=true&f.creator_facets.facet.limit=10&facet=true&spellcheck.collate=true";
        String q = getQBySplit(solrQuery);
        String fqBySplit = getFqBySplit(solrQuery);
        System.out.println(q);
        System.out.println(fqBySplit);
    }

    private static String getQBySplit(String solrQuery){
        String[] splittedStringArray = solrQuery.split("&");
        List<String> stringStartWithq = Arrays.stream(splittedStringArray).filter(s -> s.startsWith("q="))
                .map(s -> s.split("=")[1]).collect(Collectors.toList());
        return stringStartWithq.get(0);

    }

    private static String getFqBySplit(String solrQuery){
        String[] splittedStringArray = solrQuery.split("&");
        List<String> stringStartWithq = Arrays.stream(splittedStringArray).filter(s -> s.startsWith("fq="))
                .collect(Collectors.toList());

        return StringUtils.join(stringStartWithq, "&");

    }

    private static String getQ(String solrQuery){
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int strLen = solrQuery.length();

        while(i<strLen){
            boolean flag = false;
            if(i > 0 && i+1<strLen && solrQuery.charAt(i-1) != 'f' && solrQuery.charAt(i) == 'q' && solrQuery.charAt(i+1) == '='){
                int j;
                for(j=i+2; j<strLen && solrQuery.charAt(j)!='&'; j++){
                    stringBuilder.append(solrQuery.charAt(j));
                }
                flag = true;
            }
            if (flag){
                break;
            } else {
                i+=1;
            }
        }
        return stringBuilder.toString();
    }

    private static String getFq(String solrSearchString) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int strLen = solrSearchString.length();
        Stack<Character> trackBrackets = new Stack<>();
        while (i < strLen) {
            boolean flag = false;
            if (i + 1 < strLen
                    && i + 2 < strLen
                    && i + 3 < strLen
                    && solrSearchString.charAt(i) == 'f'
                    && solrSearchString.charAt(i + 1) == 'q'
                    && solrSearchString.charAt(i + 2) == '=') {
                int j;
                for (j = i + 3; j < strLen && solrSearchString.charAt(j) != '&'; j++) {
                    //                    if (solrSearchString.charAt(j) == '(') {
                    //                        trackBrackets.push('(');
                    //                    }
                    //                    if (solrSearchString.charAt(j) == ' ' &&
                    // trackBrackets.peek() == '(') {
                    //                        stringBuilder.append(" OR ");
                    //                    } else {
                    stringBuilder.append(solrSearchString.charAt(j));

                    //                    if (solrSearchString.charAt(j) == ')') {
                    //                        trackBrackets.push(')');
                    //                    }
                }
                if (solrSearchString.charAt(j) == '&') {
                    stringBuilder.append(" AND ");
                }
                flag = true;
                i += j - i;
            }
            if (!flag) {
                i += 1;
            }
        }
        String removeTrailingAnd =
                stringBuilder.substring(stringBuilder.length() - 1 - 4, stringBuilder.length());
        if (stringBuilder.toString().endsWith(" AND ")) {
            stringBuilder.delete(stringBuilder.length() - 1 - 4, stringBuilder.length());
        }
        String queryString = stringBuilder.toString();

        String sampleQuery =
                "doc_type:item AND marketplace_publication_status:PUBLISHED AND seller_vertical:art AND creator_url_labels:(mark-beard) AND seller_status:(active+nopay) AND seller_vertical:art AND item_status:(COMPLETE+UNAVAILABLE)  AND unavailable_reason_code:(ON_HOLD+ON_HOLD_CUSTOM)";

        return queryString;
    }
}
