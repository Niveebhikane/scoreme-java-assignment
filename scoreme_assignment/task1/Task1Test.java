

    @Test
    void testGetOverdueLoans_withNullAndValidData() {
        Task1 service = new Task1();

        LoanAccount valid = new LoanAccount(new Date(System.currentTimeMillis() - 100000), 100.0);
        LoanAccount zeroBalance = new LoanAccount(new Date(System.currentTimeMillis() - 100000), 0.0);
        LoanAccount nullDate = new LoanAccount(null, 100.0);

        List<LoanAccount> input = Arrays.asList(valid, zeroBalance, nullDate);

        List<LoanAccount> result = service.getOverdueLoans(input);

        assertEquals(1, result.size());
        assertTrue(result.contains(valid));
    }

