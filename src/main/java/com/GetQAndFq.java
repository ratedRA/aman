package com;

import java.util.Stack;

public class GetQAndFq {
    public static void main(String[] args) {
        String solrQuery = "/browse?spellcheck.collateExtendedResults=true&f.item_location_region_facets.facet.sort=count\"&facet.field={!key%3DsellerTier+ex%3Dst}seller_tier&facet.field={!key%3Ditem_type+ex%3Dit}item_type_facets&facet.field={!key%3Dlocation+ex%3Dlc}item_location_region_facets&facet.field={!key%3Dcreator+ex%3Dcr}creator_facets&facet.field={!key%3DcategoryL3}cat_L3_facets&facet.field={!key%3DcategoryL2}cat_L2_facets&facet.field={!key%3DcategoryL1+ex%3Dl1}seller_vertical_facets&facet.field={!key%3Dperiod+ex%3Dpr}attr_opt_facet_period&facet.field={!key%3Dcustomizable}attr_opt_facet_customizable&facet.field={!key%3DonSale}on_sale&facet.field={!key%3Dstyle+ex%3Dsl}attr_opt_facet_style&facet.field={!key%3Dorigin+ex%3Dor}attr_opt_facet_origin&facet.field={!key%3DsellerRecognized+ex%3Dsr}seller_distinguished_status&qt=/browse&spellcheck.dictionary=fileSpellchecker&fl=id,[child+parentFilter%3D\"doc_type:item\"+childFilter%3D\"sort_base_price:[1+TO+2000]+AND+hide_price:N\"]&spellcheck.maxCollations=10&f.attr_opt_facet_style.facet.limit=100&start=0&f.item_location_region_facets.facet.limit=-1&sort=marketplace_tier_sort+asc,release_date+desc,priority+asc&fq=doc_type:item&fq=marketplace_publication_status:PUBLISHED&fq={!tag%3Dl1}seller_vertical:furniture&fq=item_status:COMPLETE+OR+(item_status:UNAVAILABLE+AND+unavailable_reason_code:(ON_HOLD+ON_HOLD_CUSTOM))&fq=seller_status:(active+nopay)&fq={!tag%3Dl2}cat_L2_url_labels:lighting&fq={!parent+which%3D\"doc_type:item\"+tag%3D\"p\"}+sort_base_price:[1+TO+2000]+AND+hide_price:N&spellcheck.maxCollationTries=5&rows=58&f.cat_L3_facets.facet.prefix=F_LIG&json.facet={\"color\":{\"field\":\"attr_opt_facet_color\",\"domain\":{\"filter\":\"sort_base_price:[1+TO+2000]+AND+hide_price:N\",\"excludeTags\":\"cl\",\"blockChildren\":\"doc_type:item\"},\"limit\":100,\"type\":\"terms\",\"facet\":{\"productsCount\":\"uniqueBlock(_root_)\"}},\"material\":{\"field\":\"attr_opt_facet_material\",\"domain\":{\"filter\":\"sort_base_price:[1+TO+2000]+AND+hide_price:N\",\"excludeTags\":\"mr\",\"blockChildren\":\"doc_type:item\"},\"limit\":10,\"type\":\"terms\",\"facet\":{\"productsCount\":\"uniqueBlock(_root_)\"}},\"matchingSets\":{\"field\":\"matching_sets_facets\",\"domain\":{\"filter\":\"sort_base_price:[1+TO+2000]+AND+hide_price:N\",\"excludeTags\":\"ms\",\"blockChildren\":\"doc_type:item\"},\"limit\":100,\"type\":\"terms\",\"facet\":{\"productsCount\":\"uniqueBlock(_root_)\"}},\"lead_time_bucket\":{\"field\":\"lead_time_facets\",\"domain\":{\"filter\":\"sort_base_price:[1+TO+2000]+AND+hide_price:N\",\"excludeTags\":\"lb\",\"blockChildren\":\"doc_type:item\"},\"limit\":100,\"type\":\"terms\",\"facet\":{\"productsCount\":\"uniqueBlock(_root_)\"}}}&f.attr_opt_facet_period.facet.limit=-1&spellcheck.maxResultsForSuggest=30&f.attr_opt_facet_origin.facet.limit=10&spellcheck=true&f.creator_facets.facet.limit=10&facet=true&spellcheck.collate=true";
        String q = getQ(solrQuery);

        System.out.println(q);
    }

    private static String getQ(String solrQuery){
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int strLen = solrQuery.length();

        while(i<strLen){
            boolean flag = false;
            if(i+1<strLen && solrQuery.charAt(i) == 'q' && solrQuery.charAt(i+1) == '='){
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
