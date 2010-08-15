package net.cominfo.digiagent.persistence.sqlmapdao;

public class PaginationContext {
	// Special value for initial state  
    private static final int NO_TOTAL_COUNT = -1;  
  
    // Start on first page  
    private int skipResults = 0;  
  
    // Display 10 results per page  
    private int maxResults = 10;  
  
    // The total number of records is calculated on first page  
    private int totalCount = NO_TOTAL_COUNT;  
  
    public int getSkipResults() {  
        return skipResults;  
    }  
  
    public void setSkipResults(int skipResults) {  
        assert skipResults >= 0;  
        this.skipResults = skipResults;  
    }  
  
    public int getMaxResults() {  
        return maxResults;  
    }  
  
    public void setMaxResults(int maxResults) {  
        assert maxResults >= 0;  
        this.maxResults = maxResults;  
    }  
  
    public void updateTotalCount(int totalCount) {  
        assert totalCount >= 0;  
        this.totalCount = totalCount;  
    }  
  
    public int getTotalCount() {  
        return totalCount;  
    }  
  
    public boolean hasMorePages() {  
        if (!hasTotalCount())  
            // No totalCount yet, so display first page  
            return true;  
        if (skipResults + maxResults > totalCount)  
            return false;  
        return true;  
    }  
  
    public void nextPage() {  
        skipResults += maxResults;  
    }  
  
    public boolean hasTotalCount() {  
        return totalCount != NO_TOTAL_COUNT;  
    }  
}
