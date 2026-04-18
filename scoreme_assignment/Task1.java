import java.util.*;

public class Task1 {
    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        // FIX: Initialize result list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        if (accounts == null) {
            return result; // FIX: handle null input safely
        }

        for (LoanAccount account : accounts) {

            // FIX: check for null dueDate before calling before()
            if (account.getDueDate() != null &&
                account.getDueDate().before(new Date())) {

                // FIX: ensure only positive outstanding balance
                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }
        return result; // FIX: return empty list instead of null
    }
}
