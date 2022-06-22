package com.codersbid;

import org.apache.solr.common.params.CommonParams;
import org.apache.solr.common.params.MultiMapSolrParams;
import org.apache.solr.servlet.SolrRequestParsers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Date createdDateAfter;
    private static Date createdDateBefore;
    protected static int age;
    private static TimeUnit timeUnit;

    public static void main(String[] args) throws UnsupportedEncodingException {
        String solrQuery = "/browse?spellcheck.collateExtendedResults=true&spellcheck.dictionary=fileSpellchecker&bf=recip(ms(NOW/HOUR,marketplace_publish_date),3.16e-11,1,1)&fl=id,[child+parentFilter%3D\"doc_type:item\"]&spellcheck.maxCollations=10&f.item_location_region_facets.facet.limit=-1&fq=doc_type:item&fq=marketplace_publication_status:PUBLISHED&fq={!tag%3Dl1}seller_vertical:furniture&fq=item_status:COMPLETE+OR+(item_status:UNAVAILABLE+AND+unavailable_reason_code:(ON_HOLD+ON_HOLD_CUSTOM))&fq=-(auction_lot_status:CLOSED+AND+auction_enabled:true)&fq=seller_status:(active+nopay)&fq=translated_locales:(en_US)&spellcheck.maxCollationTries=5&spellcheck.maxResultsForSuggest=30&spellcheck.q=prouvé+antony&qf=title^3.0+creator_search^3.0+seller_name^0.1+id_text^0.1+description^0.1+cat_primary_names_deduped^10.0+attr_opt_search&f.creator_facets.facet.limit=10&keyword=prouvé+antony&f.item_location_region_facets.facet.sort=count&facet.field={!key%3DsellerTier+ex%3Dst}seller_tier&facet.field={!key%3Ditem_type+ex%3Dit}item_type_facets&facet.field={!key%3Dlocation+ex%3Dlc}item_location_region_facets&facet.field={!key%3DwaysToShop+ex%3Dwts}ways_to_shop_facets&facet.field={!key%3Dcreator+ex%3Dcr}creator_facets&facet.field={!key%3DcategoryL2}cat_L2_facets&facet.field={!key%3DcategoryL1+ex%3Dl1}@categoryL1Facets@&facet.field={!key%3Dperiod+ex%3Dpr}attr_opt_facet_period&facet.field={!key%3Dcustomizable+ex%3Dcu}attr_opt_facet_customizable&facet.field={!key%3DonSale}on_sale&facet.field={!key%3Dstyle+ex%3Dsl}attr_opt_facet_style&facet.field={!key%3Dorigin+ex%3Dor}attr_opt_facet_origin&facet.field={!key%3DsellerRecognized+ex%3Dsr}seller_distinguished_status&qt=/browse&f.attr_opt_facet_style.facet.limit=100&start=0&sort=marketplace_tier_sort+asc,release_date+desc,priority+asc&rows=60&q=prouvé+antony&json.facet={\"color\":{\"field\":\"attr_opt_facet_color\",\"domain\":{\"excludeTags\":\"cl\",\"blockChildren\":\"doc_type:item\"},\"limit\":100,\"type\":\"terms\",\"facet\":{\"productsCount\":\"uniqueBlock(_root_)\"}},\"material\":{\"field\":\"attr_opt_facet_material\",\"domain\":{\"excludeTags\":\"mr\",\"blockChildren\":\"doc_type:item\"},\"limit\":10,\"type\":\"terms\",\"facet\":{\"productsCount\":\"uniqueBlock(_root_)\"}},\"lead_time_bucket\":{\"field\":\"lead_time_facets\",\"domain\":{\"excludeTags\":\"lb\",\"blockChildren\":\"doc_type:item\"},\"limit\":100,\"type\":\"terms\",\"facet\":{\"productsCount\":\"uniqueBlock(_root_)\"}}}&f.attr_opt_facet_period.facet.limit=-1&f.attr_opt_facet_origin.facet.limit=10&spellcheck=true&pf=title^10+description^5&facet=true&spellcheck.collate=true";
        String encode = URLEncoder.encode(solrQuery, "UTF-8");
        MultiMapSolrParams solrParams = SolrRequestParsers.parseQueryString(encode);

        String parsedQ = solrParams.get(CommonParams.Q);

        System.out.println(parsedQ);
    }

}
 class TestValuePassing{
    private String queryTemplate;
    private String pageSize;
    private String pageStart;
     private Map<String, Object> qp = new HashMap<>();

     public String getQueryTemplate() {
         return queryTemplate;
     }

     public void setPageStart(String pageStart) {
         this.pageStart = pageStart;
     }

     public String getPageSize() {
         return pageSize;
     }

     public String getPageStart() {
         return pageStart;
     }

     public void setPageSize(String pageSize) {
         this.pageSize = pageSize;
     }

     public void setQueryTemplate(String queryTemplate) {
         this.queryTemplate = queryTemplate;
     }

     public Map<String, Object> getQp() {
         return qp;
     }

     public void setQp(Map<String, Object> qp) {
         this.qp = qp;
     }

     @Override
     public String toString() {
         return "TestValuePassing{" +
                 "queryTemplate='" + queryTemplate + '\'' +
                 ", pageSize='" + pageSize + '\'' +
                 ", pageStart='" + pageStart + '\'' +
                 ", qp=" + qp +
                 '}';
     }
 }
