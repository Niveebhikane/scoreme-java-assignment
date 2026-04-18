

    private static final Logger logger = LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {
        try {

            // FIX: use specific exception
            if (doc == null) {
                throw new IllegalArgumentException("Document is null");
            }

            String content = doc.extractContent();

            if (content == null || content.isEmpty()) {
                throw new IllegalArgumentException("Empty content");
            }

            return runValidationRules(content);

        } catch (IllegalArgumentException e) {
            // FIX: expected case
            logger.warn("Validation failed: {}", e.getMessage());
            return new ValidationResult(false);

        } catch (Exception e) {
            // FIX: unexpected case
            logger.error("Unexpected error", e);
            return new ValidationResult(false);
        }
    }

    public void validateBatch(List<Document> docs) {
        for (Document doc : docs) {
            try {
                ValidationResult r = validate(doc);

                // FIX: null safety
                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {
                // FIX: do not swallow
                logger.error("Batch processing error", e);
            }
        }
    }

    private ValidationResult runValidationRules(String c) { return new ValidationResult(true); }
    private void saveResult(ValidationResult r) {}

