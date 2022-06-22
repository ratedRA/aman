package com;

public class DataImportFilter {
    private String dataSelectorSql;
    private boolean doTrackImport;
    private String importTrackerDaoBean;
    private Integer pageStart;
    private Integer pageSize;
    private Boolean returnTotalResultsCount;
    private AscDesc ascDesc;

    public String getDataSelectorSql() {
        return dataSelectorSql;
    }

    public void setDataSelectorSql(String dataSelectorSql) {
        this.dataSelectorSql = dataSelectorSql;
    }

    public boolean isDoTrackImport() {
        return doTrackImport;
    }

    public void setDoTrackImport(boolean doTrackImport) {
        this.doTrackImport = doTrackImport;
    }

    public String getImportTrackerDaoBean() {
        return importTrackerDaoBean;
    }

    public void setImportTrackerDaoBean(String importTrackerDaoBean) {
        this.importTrackerDaoBean = importTrackerDaoBean;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getReturnTotalResultsCount() {
        return returnTotalResultsCount;
    }

    public void setReturnTotalResultsCount(Boolean returnTotalResultsCount) {
        this.returnTotalResultsCount = returnTotalResultsCount;
    }

    public AscDesc getAscDesc() {
        return ascDesc;
    }

    public void setAscDesc(AscDesc ascDesc) {
        this.ascDesc = ascDesc;
    }

    @Override
    public String toString() {
        return "DataImportFilter{" +
                "dataSelectorSql='" + dataSelectorSql + '\'' +
                ", doTrackImport=" + doTrackImport +
                ", importTrackerDaoBean='" + importTrackerDaoBean + '\'' +
                ", pageStart=" + pageStart +
                ", pageSize=" + pageSize +
                ", returnTotalResultsCount=" + returnTotalResultsCount +
                ", ascDesc=" + ascDesc +
                '}';
    }
}
