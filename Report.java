
public class Report {
    private int reportId;
    private String createdDate;

    public Report(int reportId, String createdDate){
        this.reportId = reportId;
        this.createdDate = createdDate;
    }

    public int getReportId() { return reportId; }
    public String getCreatedDate() { return createdDate; }

    void generateSalesReport(){

    }

    void generatePopularMoviesReport(){

    }

    void generateCustomerReport(){
        
    }
}
