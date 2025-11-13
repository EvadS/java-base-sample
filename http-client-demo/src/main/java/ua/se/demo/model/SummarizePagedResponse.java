package ua.se.demo.model;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SummarizePagedResponse {

    private int currentPage;
    private int totalPages;
    private int totalItems;
    private List<SummarizeItemResponse> content = new ArrayList<>();

    private List<LocalDate>dates = new ArrayList<>();

    public SummarizePagedResponse() {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<SummarizeItemResponse> getContent() {
        return content;
    }

    public void setContent(List<SummarizeItemResponse> content) {
        this.content = content;
    }

    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
    }
}