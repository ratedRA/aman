package com;

import com.google.gson.Gson;

import java.util.Map;

public class FilterTest {
    public static void main(String[] args) {
        Object json = " {\"dataSelectorSql\": \"select id from identity.unique_followed_page [#ifValue(cursor) #THEN AND id @compareOp|replace@ @cursor|NUMBER@] order by id limit @pageStart|replace@, @pageSize|replace@\", \"doTrackImport\": \"true\", \"importTrackerDaoBean\": \"favoriteMonitorImportTrackerDao\", \"cursor\":\"aman\", \"cursorEnabled\":\"true\", \"ascDesc\":\"DESC\"}";


        Gson gson = new Gson();
        String s = gson.toJson(json, Map.class);
        System.out.println(s);
        FavImportFilter favImportFilter = gson.fromJson(s, FavImportFilter.class);
        System.out.println(favImportFilter.getAscDesc());
        System.out.println(favImportFilter.getDataSelectorSql());

        System.out.println(favImportFilter.toString());
    }



}
