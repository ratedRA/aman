package com;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.solr.common.params.CommonParams;
import org.apache.solr.common.params.MultiMapSolrParams;
import org.apache.solr.servlet.SolrRequestParsers;

import java.util.ArrayList;
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

    public static void useSolrReqParser(String[] args) {
        MultiMapSolrParams entries =
                SolrRequestParsers.parseQueryString(
                        "/browse?spellcheck.collateExtendedResults=true&f.item_location_region_facets.facet.sort=count&facet.field={!key%3DsellerTier+ex%3Dst}seller_tier&facet.field={!key%3DartSize+ex%3Das}art_size_facets&facet.field={!key%3DartOrientation+ex%3Dao}art_orientation_facets&facet.field={!key%3DsellerRecognized+ex%3Dsr}seller_distinguished_status&facet.field={!key%3DwaysToShop+ex%3Dwts}ways_to_shop_facets&facet.field={!key%3DframingStatus+ex%3Dfs}attr_opt_facet_framingStatus&facet.field={!key%3DonSale}on_sale&facet.field={!key%3Dperiod+ex%3Dpr}attr_opt_facet_period&facet.field={!key%3Dcreator+ex%3Dcr}creator_facets&facet.field={!key%3DcategoryL3}cat_L3_facets&facet.field={!key%3DcategoryL2}cat_L2_facets&facet.field={!key%3DcategoryL1+ex%3Dl1}@categoryL1Facets@&facet.field={!key%3DframingOptionAvailable+ex%3Dfoa}attr_opt_facet_framingOptionAvailable&facet.field={!key%3Dstyle+ex%3Dsl}attr_opt_facet_style&facet.field={!key%3Dlocation+ex%3Dlc}item_location_region_facets&qt=/browse&spellcheck.dictionary=fileSpellchecker&fl=id,[child+parentFilter%3D\\\"doc_type:item\\\"+childFilter%3D\\\"sort_base_price:[1+TO+3000]+AND+hide_price:N\\\"]&spellcheck.maxCollations=10&f.attr_opt_facet_style.facet.limit=100&start=0&f.item_location_region_facets.facet.limit=-1&sort=marketplace_tier_sort+asc,release_date+desc,priority+asc&fq={!tag%3Dl2}cat_L2_url_labels:sculptures&fq=doc_type:item&fq=marketplace_publication_status:PUBLISHED&fq={!tag%3Dl1}seller_vertical:art&fq=seller_status:(active+nopay)&fq=item_status:COMPLETE+OR+(item_status:UNAVAILABLE+AND+unavailable_reason_code:(ON_HOLD+ON_HOLD_CUSTOM))&fq={!parent+which%3D\\\"doc_type:item\\\"+tag%3D\\\"p\\\"}+sort_base_price:[1+TO+3000]+AND+hide_price:N&spellcheck.maxCollationTries=5&rows=58&f.cat_L3_facets.facet.prefix=A_SCU&json.facet={\\\"color\\\":{\\\"field\\\":\\\"attr_opt_facet_color\\\",\\\"domain\\\":{\\\"filter\\\":\\\"sort_base_price:[1+TO+3000]+AND+hide_price:N\\\",\\\"excludeTags\\\":\\\"cl\\\",\\\"blockChildren\\\":\\\"doc_type:item\\\"},\\\"limit\\\":100,\\\"type\\\":\\\"terms\\\",\\\"facet\\\":{\\\"productsCount\\\":\\\"uniqueBlock(_root_)\\\"}},\\\"material\\\":{\\\"field\\\":\\\"attr_opt_facet_material\\\",\\\"domain\\\":{\\\"filter\\\":\\\"sort_base_price:[1+TO+3000]+AND+hide_price:N\\\",\\\"excludeTags\\\":\\\"mr\\\",\\\"blockChildren\\\":\\\"doc_type:item\\\"},\\\"limit\\\":10,\\\"type\\\":\\\"terms\\\",\\\"facet\\\":{\\\"productsCount\\\":\\\"uniqueBlock(_root_)\\\"}}}&f.attr_opt_facet_period.facet.limit=-1&spellcheck.maxResultsForSuggest=30&qf=title^3.0+creator_search^3.0+seller_name^0.1+id_text^0.1+description^0.1+cat_primary_names_deduped^10.0+attr_opt_search&spellcheck=true&pf=title^10+description^5&f.creator_facets.facet.limit=10&facet=true&spellcheck.collate=true");
        String[] params = entries.getParams(org.apache.solr.common.params.CommonParams.FQ);
        List<String> parsedFqs = Arrays.asList(entries.getParams(CommonParams.FQ));

        System.out.println(entries.get(CommonParams.Q));
        System.out.println(StringUtils.join(params, ","));
        List<String> qualifiedFqs = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(parsedFqs)) {
            for (String fq : parsedFqs) {
                String[] fqKeyValueArray = fq.split(":");
                String fqKey = fqKeyValueArray[0];
                String fqValue = fqKeyValueArray[1];

                if(fqValue.matches("[A-Za-z0-9]+")) {

                    if (fqKey.contains("}")) {
                        int i = fqKey.indexOf("}");
                        fqKey = fqKey.substring(i + 1);
                    }
                    qualifiedFqs.add(fqKey + ":" + fqValue);
                }
            }
        }
        System.out.println(StringUtils.join(qualifiedFqs, "&"));
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
